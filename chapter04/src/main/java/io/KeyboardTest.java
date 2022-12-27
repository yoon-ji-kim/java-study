package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardTest {

	public static void main(String[] args) {
		// 키보드 엔터 입력 시 읽기
		BufferedReader br =null;
		try {
			// 1. 기반 스트림(표준 입력, stdin, System.in) 만들필요 XX
			
			// 2. 보조스트림1(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
			
			// 3. 보조스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				if("quit".equals(line)) {
					break; //quit 입력시 멈춤
				}
				System.out.println(line);
			}
		}catch (IOException ex) {
			System.out.println("Error :"+ex);
		}finally {
			try {
				if(br != null) {
					br.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
