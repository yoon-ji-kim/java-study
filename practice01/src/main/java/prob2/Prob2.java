package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		for(int i=1; i<10; i++) {
			for(int j=i; j<i+10; j++) {
				System.out.print(j);
				if(j != i+9) {
					System.out.print(" ");					
				}
			}
			System.out.println();
		}
	}
}
