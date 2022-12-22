package prob5;

public class MyStackException extends RuntimeException {
	public MyStackException() {
		System.out.println("Prob5.MyStackException: stack is empty");
	}
}
