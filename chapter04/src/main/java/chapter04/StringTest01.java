package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// c:\temp
		System.out.println("c:\temp"); //탭으로 인식해서 c:	emp 로 출력 
		System.out.println("c:\\temp");  // \ 하나 더 입력해서 escape
		// "HELLO"
//		System.out.println(""Hello""); //systax error
		System.out.println("\"Hello\"");
//		\t: tab
//		\r: carriage return
//		\n: new line
//		\b: bell
		System.out.print("1" + "\n");
//		n을 만나면 커서가 같은 위치 다음줄로 옮겨감
//		ooo \nㅁ
//		ooo
//		  ㅁ
//		ooo \r\nㅁ
//		ooo
//		ㅁ
		System.out.println("1");
		System.out.print("2");
		System.out.println();
		//print와 println의 차이점
		System.out.print("hello\tworld\n");
		System.out.println("hello\tworld\n");
		// '
		char c = '\'';
		System.out.println(c);
	}

}
