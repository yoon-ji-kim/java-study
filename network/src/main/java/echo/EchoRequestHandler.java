package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

//Thread 클래스 - run 구현가능
public class EchoRequestHandler extends Thread {
	private Socket socket;
	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remotePort = inetRemoteSocketAddress.getPort();
		log("connected by client["+remoteHostAddress+":"+remotePort+"]]");
		
		try {
			//보조스트림
			//																	      Buffer를 즉시 flush하기
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
				//bufferedreader에서 읽을땐 client에서 개행을 붙여서 보내 경계 만들기 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			while(true) {
				//데이터 받기, 개행 단위
				String data = br.readLine();
				if(data == null) {
					//명시적 close, 정상종료
					log("close by client");
					break;
				}
				log("received: "+data);
				pw.println(data);  //개행해서 보내기
//				pw.print(data + "\n");
			}				
		} catch(SocketException ex) {
			System.out.println("[server] suddenly closed by client");
		}  catch(IOException e) {
			log("error"+e);
		}finally {
			try {
				if(socket != null & !socket.isClosed()) {
					socket.close();											
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	//Thread를 상속받아 threadID를 알 수 있음
	private void log(String message) {
		System.out.println("[EchoServer#"+getId()+"] " + message);
	}
}
