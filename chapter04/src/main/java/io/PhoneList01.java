package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		// 브라우저 http 헤더 분석
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");
			// 파일존재여부
			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}
			System.out.println("======= 파일정보=========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes"); // byte 단위
//		TimeStamp
//		System.out.println(file.lastModified()); //마지막 수정 long값
//		Date d = new Date(file.lastModified());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date = sdf.format(d);
//		System.out.println(date);
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
			System.out.println("======= 전화번호=========");
			// 1. 기반스트림(FileInputStream)
			FileInputStream fis = new FileInputStream(file);

			// 2. 보조스트림1(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");

			// 3. 보조스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
//				System.out.println(line);
//				토큰
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index =0;
				while(st.hasMoreElements()) {
					String token =st.nextToken();
					//0이면 이름
					//1이면 전화번호 시작
					if(index ==0) {			//이름
						System.out.print(token +": ");
					}else if(index ==1) {	//전화번호1
						System.out.print(token+"-");
					}else if(index ==1) {	//전화번호2
						System.out.print(token+"-");						
					}else {					//전화번호3
						System.out.print(token);												
					}
					index++;
				}
				//한줄 처리 후 개행
				System.out.println();
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error : " + e);
		} catch (IOException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
