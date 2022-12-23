package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
//		Checked Exception을 던지는 메소드를 쓸 가능성이 있어 try catch를 강제함
		try {
			fis = new FileInputStream("hello.txt");
			int data = fis.read();
			System.out.println((char)data);
			//catch문 여러개일때 상속관계 주의
		} catch (FileNotFoundException e) {
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.err.println("error: " + e);
		} finally {
			try {
				if(fis != null) {
					fis.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
