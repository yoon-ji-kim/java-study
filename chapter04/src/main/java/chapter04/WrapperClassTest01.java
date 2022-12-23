package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		//직접 생성하면 바로 heap에 만들어져서 객체가 존재하게 된다. ->constant pool이 관리 못하게 됨
		// 리터럴을 사용하게 되면 JVM 안의 Constant Pool이 관리한다.
		//조만간 없어질거니까 쓰지마라는 뜻
		Integer i = new Integer(10); 
		Character c = new Character('c');
		Boolean b = new Boolean(true);

		//자동으로 클래스를 만들어주는 것 :Auto Boxing
		//Constant Pool이 관리
		Integer j1 = 10;
		Integer j2 = 10; 
		System.out.println( j1 == j2);
		System.out.println(j2.equals(j1));
		
		// Auto Unboxing
		int m = j1 + 10;
//	---->	int m=j1.intValue() +10;
	}

}
