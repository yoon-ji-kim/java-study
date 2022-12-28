package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {
// 과제. nsLookUp 구현하기
	public static void main(String[] args) {
//		사용하는 메소드 
		//scanner로 입력받기
		String line = "www.douzone.com";
		//while => exit 일때 까지
		//IP 모두		getAllByName(도메인)
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.douzone.com");
//			반복문하면서 getHostAddress
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
