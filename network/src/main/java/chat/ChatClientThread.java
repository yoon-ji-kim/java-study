package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	// Socket Read
	private Socket socket;
	private PrintWriter pw =null;
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			//reader를 통해 읽은 데이터 콘솔에 출력하기(message 처리)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);
			while(true) {
				String data = br.readLine();
				System.out.println(data);
				if(data == null) {
					ChatClient.log("closed by server");
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			ChatClient.log("error: " +e);
		} catch (IOException e) {
			e.printStackTrace();
			ChatClient.log("closed by server");
//			return;
//			System.exit(0);
		} finally {
			if(!socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
