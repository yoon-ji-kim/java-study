package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	//연결된 클라이언트 닉네임 저장
	private String nickname;
	//통신을 위한 스트림 얻어 오기 위해 Socket 객체 저장
	private Socket socket;
	private List<Writer> listWriters;
	private PrintWriter pw = null;
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	//Run 메소드 오버라이딩
	@Override
	public void run() {
		try {
			//문자 단위 처리와 라인 단위 읽기를 위해 보조 스트림 객체 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);
			
			//요청 처리
			while(true) {
				String request = br.readLine();
//				System.out.println(request);
				//프로토콜 분석
				//요청명령: 파라미터1:파라미터2:..\r\n ->요청구분
				if(request == null || request.equals("quit")) {
					doQuit(pw);
					break;
				}else {
					String[] tokens = request.split(":");
					if("join".equals(tokens[0])) {
						doJoin(tokens[1], pw);
					}else if("message".equals(tokens[0])) {
						doMesasge(tokens[1]);
					}else {
						ChatServer.log("에러: 알 수 없는 요청 ("+tokens[0]+")");
					}
				}
			}
//			if(!socket.getKeepAlive()) {
//			System.out.println("closed by client");
//		}
		} catch (SocketException e) {
//			e.printStackTrace();
			ChatServer.log("closed by client");
		} catch (IOException e) {
		} finally {
			if(socket != null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
//		catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장 하였습니다.";
		System.out.println(data);
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doMesasge(String string) {
		String data = nickname+":"+string; 
		broadcast(data);
		System.out.println(nickname+":"+string);
	}

	private void doJoin(String nickname, Writer writer) {
		//프로토콜
		//join:nickname\r\n
		this.nickname = nickname;
		
		String data = nickname +"님이 참여하였습니다.";
		System.out.println(data);
		broadcast(data);
		//writer pool에 저장
		addWriter(writer);
		//ack 방 참여 성공을 클라이언트에게 알리기
		//중복 체크
		pw.println("JOIN:OK");
	}

	private void addWriter(Writer writer) {
		//여러 스레드가 하나의 공유객체에 접근할때 동기화 보장 synchronized
		synchronized (listWriters) {
			//Writer pool(list)에 Writer 추가
			listWriters.add(writer);
		}
	}
	
	//서버에 연결된 모든 클라이언트에게 메시지 보내는 메소드
	private void broadcast(String data) {
		//동기화 처리
		synchronized (listWriters) {
			for(Writer writer: listWriters) {
										//다운캐스팅
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
	
}
