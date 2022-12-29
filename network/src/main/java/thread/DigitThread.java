package thread;

public class DigitThread extends Thread {

	//run 메소드 overriding
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			//재우기 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
