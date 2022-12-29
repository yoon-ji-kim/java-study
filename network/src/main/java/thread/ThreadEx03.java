package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread01 = new DigitThread();
		Thread thread02 = new AlphabetThread(); 
		Thread thread03 = new Thread(new UpperCaseAlphabetRunnableImpl());
						//new Thread 생성자 안에 runnable 넣어주기
		thread01.start(); 
		thread02.start(); 
		thread03.start(); 
	}

}
