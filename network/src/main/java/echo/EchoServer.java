package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT = 8000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0" , PORT));
			log("[starts....[port :"+ PORT+"]");      //서버가 작동하는지 알려줌
			Socket socket = serverSocket.accept();
			
			//remote 주소랑 port 정보 가져오기
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
//					pw.print(data + "\n");
				}				
			} catch(IOException e) {
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
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}
}
