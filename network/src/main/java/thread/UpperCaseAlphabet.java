package thread;

//thread와 상관없는 일반클래스의 메소드를 thread에 태우고 싶다면
//UpperCaseAlphaAlphabetRunnableImpl의 run을 만들어스
public class UpperCaseAlphabet {
	public void print() {
		for(char c = 'A'; c<= 'Z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
