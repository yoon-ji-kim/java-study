package chapter04;

public class object03Test {

	public static void main(String[] args) {
		String s1 = new String("hello");	//heap에 생김
		String s2 = new String("hello");	
		System.out.println(s1 == s2); 		//동일성 비교
		System.out.println(s1.equals(s2));  //동질성 비교
//		내용기반 해시코드 같음
		System.out.println(s1.hashCode() + ":"+ s2.hashCode());
//		String이라스 이미 오버라이드되었지만 (객체 id인) 주소기반 해시코드를 알아보기
		System.out.println(System.identityHashCode(s1) +":"+System.identityHashCode(s2));
		
		System.out.println("==============================");
		String s3 = "hello";				//heap에 생길수도 안생길수도
		String s4 = "hello";				//한번 만들어시 String은 변경 불가!
		//JVM 내부 상수pool(Constant Pool) : String용
		// reference | hash -> 해싱 값을 찾아봄 ->heap에 객체 생성 -> 레퍼런스 값 
		
		System.out.println(s3 == s4); 			//true
		System.out.println(s3.equals(s4));  
		System.out.println(s3.hashCode() + ":"+ s4.hashCode());
		System.out.println(System.identityHashCode(s3) +":"+System.identityHashCode(s4));
		//string이 불변이 되어야 하는 이유
	}

}
