package thread;

public class ThreadEx01 {

	public static void main(String[] args) {
//		for(int i=0; i<10; i++) {
//			System.out.print(i);
//		}
		new DigitThread().start(); //객체 만들어서 start
		for(char c = 'a'; c<= 'z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//모든 thread가 종료되어야 main도 끝남
	}

}
