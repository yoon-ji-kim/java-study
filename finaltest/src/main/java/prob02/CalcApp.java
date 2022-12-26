package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 1 ] );
			String op = String.valueOf(tokens[2]);
			Arithmetic arithmetic = null;
			
			/* 코드 작성 */
			if(op.equals("+")) {
				arithmetic = new Add();
			}else if(op.equals("-")) {
				arithmetic = new Sub();
			}else if(op.equals("*")) {
				arithmetic = new Mul();
			}else if(op.equals("/")) {
				arithmetic = new Div();
			}else {
				System.out.println( ">> 알 수 없는 식입니다.");
			}
			int result = arithmetic.calculate(lValue, rValue);
			System.out.println( ">> " + result );
		}
		
		scanner.close();
	}
}