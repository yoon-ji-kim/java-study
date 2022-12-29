package httpd;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private static final int PORT = 8088;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			// 1. Create Server Socket

			serverSocket = new ServerSocket();
			serverSocket.bind( new InetSocketAddress("0.0.0.0", PORT));
			   
			// 2. Bind
			consoleLog("starts... [port: " + PORT + "]");

			while (true) {
				// 3. Wait for connecting ( accept )
				Socket socket = serverSocket.accept();

				// 4. Delegate Processing Request 요청 처리(위임)
				new RequestHandler(socket).start();
			}

		} catch (IOException ex) {
			consoleLog("error:" + ex);
		} finally {
			// 5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	public static void consoleLog(String message) {
		System.out.println("[Httpd#" + Thread.currentThread().getId()  + "] " + message);
	}
}
