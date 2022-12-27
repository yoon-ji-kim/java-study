package io;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림
			FileOutputStream fos = new FileOutputStream("hello.txt");
			// 보조 스트림
//			BufferedOutputStream bos = new BufferedOutputStream(fos); //연결, 내가 쓸 것은 bos
			bos = new BufferedOutputStream(fos);
			
//			for(int i= 'a'; i <= 'z'; i++) {
//			ASCII 코드 ->
			for(int i= 97; i<=122; i++) {
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if(bos != null) {
					bos.close();
				}
			} catch (IOException e) {
			}
		}
	}

}
