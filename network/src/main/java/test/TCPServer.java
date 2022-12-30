package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
//Server 틀 만들기
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();
			// 1-1. FIN_WAIT -> TIME_WAIT상태에서도 소켓 포트 할당이 가능하도록 하기 위해 설정 해둬야함
							//서버가 포트를 끊어도 다시 사용할 수 있음
			serverSocket.setReuseAddress(true);
			// 2. binding (주소를 소켓에 붙이는 작업)
			// Server Socket에 InetSocketAddress(IPAddress +Port)를 바인딩 한다.(붙인다)
			// IP Address는 일반적으로 0.0.0.0으로 사용한다
			// -> 특정 호스트 IP에 바인딩 하지 않는다. 최소 2개 이상 될 수 있기 때문에 구애받지 않기 위해서
//			serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost().getHostAddress() , 5000));
			//Queue 최대 개수 지정 (Accept 처리하는 동안 대기하는 애들)
			serverSocket.bind(new InetSocketAddress("0.0.0.0" , 5000),10);
			
			// 3. Accept
			Socket socket = serverSocket.accept(); //프로그램은 blocking된다(멈춤)
			// Xshell telnet ip 5000
			//원격 정보 가져오기
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client["+remoteHostAddress+":"+remotePort+"]");    //blocking되어 출력 안됨
				
				// 4. IO Stream 받아오기
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
				
				// 5. 데이터 읽기
				while(true) {
					//1byte씩 안읽게 buffer 만들기
					byte[] buffer = new byte[256];
					//blocking
					int readByteCount = is.read(buffer);
					//클라이언트가 정상적으로 종료한 경우(close()호출한 경우
					if(readByteCount == -1) {
						System.out.println("[server] closed by client");
						break;
					}
					//화면 출력 byte -> 문자로 encoding  개수만큼
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received: "+data);
						// 소켓 SO_TIMEOUT 옵션 테스트용
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					// 6. 데이터 쓰기 (echoing)
					os.write(data.getBytes("utf-8"));  //byte로 쓰기
				}				
			} catch(SocketException ex) {
				System.out.println("[server] suddenly closed by client");
			} catch(IOException e) {
				System.out.println("[server] error"+e);
			}finally {
				try {
					if(socket != null & !socket.isClosed()) {
						socket.close();											
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (IOException e) {
			//Server Socket용
			System.out.println("[server] error: " + e);
		} finally {
			//소켓 닫기
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
