package prob01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GugudanApp {

	static int resultNumber = 0;

	public static void main(String[] args) {
		// 특정 곱셈 만들기
		int l = randomize(1, 9);
		int r = randomize(1, 9);
		// 곱셈의 답
		resultNumber = l * r;
		// 랜덤하게 구구단의 곱셈 만들기
		int[] answerNumbers = randomizeAnswers();
		// 답 넣을 자리 정하기
		int loc = randomize(0, 8);
		answerNumbers[loc] = resultNumber;

		System.out.println(l + " x " + r + " = ?");
		//출력
		int length = answerNumbers.length;
		for (int i = 0; i < length; i++) {
			if (i % 3 == 0) {
				System.out.print("\n");
			} else {
				System.out.print("\t");
			}

			System.out.print(answerNumbers[i]);
		}

		System.out.print("\n\n");
		System.out.print("answer:");

		Scanner s = new Scanner(System.in);
		int answer = s.nextInt();
		s.close();

		System.out.println((answer == resultNumber) ? "정답" : "오답");
	}

	private static int randomize(int lNum, int rNum) {
		int random = (int) (Math.random() * rNum) + lNum;
		return random;
	}

	private static int[] randomizeAnswers() {
		/* 코드 작성(수정 가능) random수 배열 구하기 */
		final int COUNT_ANSWER_NUMBER = 9;
		int[] boardNumbers = new int[COUNT_ANSWER_NUMBER];
		//Set에 넣어 중복된 수 없이 구하기
		Set<Gugudan> set = new HashSet<>();
//		while(set.size() <COUNT_ANSWER_NUMBER) {
//			Gugudan gugudan = new Gugudan(randomize(1, 9), randomize(1, 9));
//			if(!set.equals(gugudan)) {  --->set이라서 할 필요 없음
//				set.add(gugudan);				
//			}
//		}
		while(set.size() < COUNT_ANSWER_NUMBER) {
			Gugudan gugudan = new Gugudan(randomize(1, 9), randomize(1, 9));
			set.add(gugudan);
		}
		int idx =0;
		for(Gugudan gugudan : set) {
			int num = gugudan.mul();
			boardNumbers[idx++] = num;
		}
		return boardNumbers;
	}
}
