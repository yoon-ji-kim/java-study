package prob4;

public class SoundTest {

	public static void main(String[] args) {
//		Sound클래스만들고 인터페이스 구현 
		printSound( new Cat() );
		printSound( new Dog() );
		printSound( new Sparrow() );
		printSound( new Duck() );
	}
	
	private static void printSound( Soundable soundable ) {
		System.out.println( "\""+soundable.sound()+"\"" );
	}
}