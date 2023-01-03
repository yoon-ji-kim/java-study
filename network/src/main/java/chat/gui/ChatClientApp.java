package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "0.0.0.0";

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		try {
			while (true) {

				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();

				if (name.isEmpty() == false) {
					break;
				}

				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}

			scanner.close();
			// 1. create socket
			socket = new Socket();
			// 2. connect to server
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			// 3. get iostream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			// 4. join protocol 진행
			pw.println("join:"+name);
			String line = br.readLine(); // 요청에 대한 응답받아서 ex)JOIN:OK
			if ("JOIN:OK".equals(line)) {
				new ChatWindow(name,socket).show();
				return;
			}else {
				System.out.println("대화명을 다시 설정해주세요.");
				return;
			}
			// OK 아닐경우 종료 또는 다시 실행하기
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if(!socket.isClosed() && socket != null) {
					socket.close();					
				}
			} catch (IOException es) {
				es.printStackTrace();
			}
		} 
	}

}
