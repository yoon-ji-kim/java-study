package exception;

public class MyException extends Exception {

	/**
	 * 객체를 구분할 수 있는 ID
	 */
	private static final long serialVersionUID = 1L;
	
	//오버로딩으로 생성자 2개 만듦
	public MyException() {
		super("MyException Occurs");
		//부모생성자 호출
	}
	public MyException(String message) {
		super(message);
	}
}
