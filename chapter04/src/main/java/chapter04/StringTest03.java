package chapter04;

import java.util.Arrays;

public class StringTest03 {

	public static void main(String[] args) {
		//String Buffer
//		String s1 = "Hello" + "World" + "Java" + 17;
		String s1 = new StringBuffer("Hello")    //new: 객체 생김 -> append: 객체 늘림
				.append("World")
				.append("Java")
				.append(17)
				.toString(); 		//character 배열을 string으로 바꿈
		//주의 !
		String s2 = ""; //빈 문자열에
						//많은 루프 안에서 string을 더하면
		for(int i=0; i< 1000000; i++) {
//			s2 = s2 +i;
//			s2 = new StringBuffer(s2).append(i).toString();
			//연속적으로 new 하면 메모리 할당을 1000000번해서 cpu를 엄청 하게됨 -> 느려짐
//			저장하고 빼오고 계속 반복해서!
		}
//		===> 명시적으로 바꾸기
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i< 1000000; i++) {
			sb.append(i);
		}
		String s3 = sb.toString();
		//String Method들
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc",7));
		System.out.println(s4.indexOf("d"));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3,5));
		
		String s5 = "     ab    cd    ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		//굵은 가지 옆에 잔가지를 깎는것 -> trim
		System.out.println("---"+s5.trim()+"---"); //양옆space를 없앰
		System.out.println("---"+s5.replaceAll(" ", "")+"---"); 
		
		String[] tokens = s6.split(",");
		for (String s : tokens) {
			System.out.println(s);
		}
		String[] tokens2 = s6.split(" ");
		for (String s : tokens2) {
			System.out.println(s);
		}
	}

}
