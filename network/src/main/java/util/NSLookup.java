package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
// 과제. nsLookUp 구현하기
	public static void main(String[] args) {
//		사용하는 메소드 
		// scanner로 입력받기
		Scanner sc = new Scanner(System.in);
		String line ="";
		String exit = "exit";
		try {
			// while => exit 일때 까지
			while (true) {
				line = sc.nextLine();
				if(line.equals(exit)) break;
				// 도메인 입력 받기
				// IP 모두 받아오는 getAllByName(도메인)
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);
				//반복문하면서 getHostAddress
				for (InetAddress inetAddress : inetAddresses) {
					System.out.println(line +" : "+ inetAddress.getHostAddress());
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
