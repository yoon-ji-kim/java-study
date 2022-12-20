package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			int cnt = 0;
			int big = i / 10;
			int small = i % 10;
			if (isCorrect(big)) {
				cnt++;
			}
			if (isCorrect(small)) {
				cnt++;
			}
			if(cnt !=0) print(i, cnt);
		}
	}

	private static void print(int num, int cnt) {
		System.out.print(num + " ");
		for (int i = 0; i < cnt; i++) {
			System.out.print("짝");
		}
		System.out.println();
	}

	private static boolean isCorrect(int i) {
		if (i == 3 || i == 6 || i == 9) {
			return true;
		}
		return false;
	}
}
