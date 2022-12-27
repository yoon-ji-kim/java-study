package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		for(String arg: args) {
			System.out.println(arg);
		}
		InputStream is = null;
		OutputStream os = null;
		try {
			is =  new FileInputStream("byul.jpg");
			os = new FileOutputStream("byul.copy.jpg");
			//읽기 끝에는 -1이라서 -1일때까지 읽고 쓰기
			int data = -1;
			while((data = is.read()) != -1) {
				os.write(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+e);
		} catch (IOException e) {
			System.out.println("error: "+e);
		} finally {
			//자원정리
			try {
				//null 체크 주의
				if(is != null) {
					is.close();					
				}
				if(os != null) {
					os.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
