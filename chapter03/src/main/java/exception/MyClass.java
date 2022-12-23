package exception;

import java.io.IOException;

public class MyClass {
	//내부에서 exception을 던지는 코드가 있으면 표시해서 알려줘야함
	public void danger() throws IOException, MyException{
		System.out.println("some code1.....");
		System.out.println("some code2.....");
		
		if(3-3 == 0) {
			throw new MyException();
		}
		//구문 체크만 해서 컴파일러가 잡지 못함
		if( 5-5 == 0) {
			throw new IOException();			
		}
		
		System.out.println("some code3.....");
		System.out.println("some code4.....");
	}
}
