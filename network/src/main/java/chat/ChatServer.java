package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8000;

//멀티스레드 + 브로드캐스팅
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		// PrintWriter를 담을 수 있는 List 생성
		List<Writer> listWriters = new ArrayList<>();
		try {
			// 1.서버 소켓 생성
			serverSocket = new ServerSocket();
			// 2.바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결 기다림... " + PORT);
			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();
				// 클라이언트와 연결된 후 채팅 데이터 통신은 CharServerThread가 한다
				// 요청이 수락하고 스레드를 생성할 때 list객체를 스레드 생성자를 통해 전달
				new ChatServerThread(socket, listWriters).start();
			}
		} catch (IOException e) {
			log("error" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String message) {
		System.out.println("[ChatServer] : " + message);
	}

}
