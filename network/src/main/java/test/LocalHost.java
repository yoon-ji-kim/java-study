package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		//IP 주소 알아보기
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			//컴퓨터 이름
			String hostName = inetAddress.getHostName();
			//주소 얻기
			String hostIpAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostIpAddress);
			byte[] IpAddresses= inetAddress.getAddress();  //4byte 진짜 주소 체계로 받아옴
			for(byte IpAddress : IpAddresses) {
				//부호 bit를 유지한 채로 올라와서 reset 시키기
//				System.out.print(IpAddress);
				System.out.print(IpAddress & 0x000000ff);
				System.out.print(".");
			}
		} catch (UnknownHostException e) {
			//TCP 설치 안되어있으면 생기는 Exception
			e.printStackTrace();
		}
	}

}
