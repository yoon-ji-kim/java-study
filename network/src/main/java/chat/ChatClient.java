package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "0.0.0.0";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		try {
			// 1. 키보드 연결
//			sc = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("연결 됨");
			// 4. Reader/Writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 5. join 프로토콜
			System.out.print("닉네임>> ");
			
			String nickname = sc.nextLine();
			pw.println("join:" + nickname);
			String response = br.readLine();
			if(response.equals("JOIN:OK")) {
				// 6. ChatClientReceiveThread시작
				new ChatClientThread(socket).start();
			}else {
//				JOIN:OK 아닐 경우 어떻게 처리할 지 **
				log("닉네임을 다시 설정해주세요.");
				return;
			}

			// 7. 키보드 입력 처리
			while (true) {
				String input = sc.nextLine();
				if(input == null) {
					break;
				}
				if ("quit".equals(input)) {
					// 8. quit 프로토콜 처리
					pw.println("quit");
					break;
				} else {
					// 9. 메시지 처리
					pw.println("message:"+input);
				}
			}
		} catch (NoSuchElementException e) {
			log("채팅방 강제 종료");
		} catch (SocketException e) {
			log("error: "+ e);
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
//				if (sc != null) {
//					sc.close();
//				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String message) {
		System.out.println("[ChatClient] " + message);
	}
}
