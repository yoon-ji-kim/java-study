package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		// String 불변성 immutability(불변성)
		// String 메소드들 이해하기
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		
		s2 = s1.toUpperCase();
		String s4 = s2.concat("??");
		String s5 = "!".concat(s2).concat("@");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println(equalsHello("hello"));
		System.out.println(equalsHello(null));
		
//		+ 연산자 지원해서 내부 stringbuffer로 바뀜
		
	}

	private static boolean equalsHello(String s) {
		//문자열 비교
		// 문자열 null 들어오면 nullPointerException 발생
//		return s.equals("hello");
		return "hello".equals(s);
	}

}
