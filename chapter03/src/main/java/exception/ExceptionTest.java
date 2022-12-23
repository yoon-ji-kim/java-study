package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			int a = 10;
			int b = 10 - a;
			System.out.println("Some Code1...");
			System.out.println("Some Code2...");
			System.out.println("Some Code3...");
			int result = (1 + 2 + 3) / b; // ArithmeticException
			System.out.println("Some Code4...");
			System.out.println("Some Code5...");

		} catch (ArithmeticException ex) {
//			예외 내용이 객체에 담겨있음, 변수가 쌓여있던 정보도 있음(몇번째 줄에서 예외 발생했는지)
			/*예외 처리
			 * 1. 로깅
			 * 2. 사용자에게 알리기
			 * 3. 정상종료
			 */
			System.out.println("error: "+ ex);
			System.out.println("사용자에게 사과");
//			return;
			System.exit(0);
//			ex.printStackTrace();
		} finally {
			System.out.println("자원정리 예: file close...");
		}
		System.out.println("Some Code6...");
		System.out.println("Some Code7...");

	}

}
