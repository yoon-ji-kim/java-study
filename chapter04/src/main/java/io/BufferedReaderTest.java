package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
//		text 라인 단위로 읽기
		BufferedReader br =null;
		try {
			//기반 스트림 						경로지정
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			
			//보조 스트림
			br = new BufferedReader(fr);
			//읽기  readLine -> String 리턴
			String line = null; //String 리턴이라 끝은 Null
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
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
