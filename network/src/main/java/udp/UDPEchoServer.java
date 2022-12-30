package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class UDPEchoServer {
	public static final int PORT = 5000;
	public static final int BUFFER_SIZE = 256;
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			//1.소켓 생성
			//Datagram Socket 사용					포트번호
			socket = new DatagramSocket(PORT);
			while(true) {
				//2.데이터 수신                             받는 데이터와 보내는 데이터 크기는 같아야함
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);//수신 패킷
				socket.receive(rcvPacket); //Blocking
		
				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				String message = new String(rcvData, 0, offset, "utf-8");
				
				System.out.println("[UDP Echo server] received: "+message);
				
				//3.데이터 송신
				byte[] sndData = message.getBytes("utf-8"); //보낼 데이터 byte 배열로 뺴오기
																			         // 받는 사람주소와           포트 번호
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, rcvPacket.getAddress(), rcvPacket.getPort());
				socket.send(sndPacket);
			}

		} catch(SocketException e) {
			System.out.println("[UDP Echo server] error:" + e);
		}catch(IOException e) {
			System.out.println("[UDP Echo server] error:" + e);
		} finally {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
		
	}

}
