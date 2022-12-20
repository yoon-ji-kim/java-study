package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		/* 코드 작성 */
		while(true) {
			int sum =0;
			System.out.print("숫자를 입력하세요: ");
			int num = scanner.nextInt();
			if(num %2 ==0) {
				for(int i=0; i<=num; i++) {
					if(i%2 ==0) sum += i;
				}
			}else {
				for(int i=0; i<=num; i++) {
					if(i%2 !=0) sum +=i;
				}
			}
			System.out.println("결과 값 : "+sum);
			System.out.println();
		}
//		scanner.close();
	}
}
