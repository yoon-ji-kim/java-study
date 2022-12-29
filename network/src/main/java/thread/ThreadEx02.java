package thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		//main
		// |
		// thread01 - thread02
		// thread3게
		Thread thread01 = new DigitThread(); //스레드 객체만 만들어줌 실행 되지 않았음
		Thread thread02 = new AlphabetThread(); 
		thread01.start(); 
		thread02.start(); 
		//모든 thread가 종료되어야 main이 내려감
		// main thread 먼저 끝남 -> digit- >alphabet  순
	}

}
