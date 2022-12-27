package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		try {
			in = new FileReader("text.txt");
//			encoding을 자동으로 하여 count 7번
			int count = 0;
			int data = -1;
			while ((data = in.read()) != -1) {
				System.out.print((char) data);
				count++;
			}
			System.out.println();
			System.out.println("count: " + count);
			System.out.println("======================");
			
			count =0;
			data = -1;
			is = new FileInputStream("text.txt");
			byte[] code = new byte[3];
			while((data = is.read()) != -1) {
				System.out.print((char)data);
				count++;
				//3byte 배열을 만들어서 new String 만들어서 encoding
				if(count %3 ==0) {
					
				}

			}
			System.out.println();
			System.out.println("count: " + count);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e);
		} catch (IOException e) {
			System.out.println("File Not Found: " + e);
		} finally {
			try {
				// null 체크
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
