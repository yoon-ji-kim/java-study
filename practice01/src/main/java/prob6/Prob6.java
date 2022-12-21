package prob6;

public class Prob6 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			String num = String.valueOf(i);
			int cnt =0;
			for(int j=0; j< num.length(); j++) {
				char c = num.charAt(j);
				if(c =='3' || c =='6' || c=='9') {
					cnt++;
				}
			}
			if(cnt ==0) continue;
			System.out.print(i+" ");
			for(int j=0; j<cnt; j++) {
				System.out.print("짝");
			}
			System.out.println();
		}
	}
}
