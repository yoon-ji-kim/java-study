package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "123456";
		int i = Integer.parseInt(s);
		
		//비교
//		cf1 반대로
		String s1 = String.valueOf(i); //Integer to String
		//cf2 반대로
		String s2 = "" + i;
		System.out.println(s + ":"+ s1 + ":"+s2);
		
		char c = 'A';
		//16진수
		int a = Character.getNumericValue('A');
		System.out.println(a);
		//ASCII 65 -> int 
		System.out.println((int)c);
		
		//2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		//16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
	}

}
