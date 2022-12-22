package prob3;

public class Prob2 {
	public static void main(String[] args) {
//		name은 Bird에
//		fly, sing(추상화 해서) 받아서 구현하기
		Bird bird01 = new Duck();
		bird01.setName( "꽥꽥이" );
		bird01.fly();
		bird01.sing();
		System.out.println( "오리의 이름은 "+bird01.name.toString()+" 입니다." );
		
		Bird bird02 = new Sparrow();
		bird02.setName( "짹짹이" );
		bird02.fly();
		bird02.sing();
		System.out.println( "참새의 이름은 "+bird02.name.toString()+" 입니다.");
	}
}
