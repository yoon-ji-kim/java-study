package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	public static void main(String[] args) {
		Socket socket = null;

		Scanner scanner = null;
		try {
			socket = new Socket();
														
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			log("connected");
			                                                                                 //decoding
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
																					            //encoding
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			scanner = new Scanner(System.in);
			while(true) {
				System.out.print(">");
				//입력받기
				String line = scanner.nextLine();
				if("exit".equals(line)) {
					break;
				}
				//보내기
				pw.println(line);
				//서버에서 나한테 준 거 받기
				String data = br.readLine();
				if(data == null) {
					log("closed by server");
					break;
				}
				//echo data 화면에 출력하기
				System.out.println("<"+ data);
			}
		} catch (IOException e) {
			log("error: "+e);
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();					
				}
				if(scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void log(String message) {
		System.out.println("[EchoClient] " + message);
	}
}
