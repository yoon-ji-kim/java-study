package prob01;

public class Printer {
//	public void println(int num) {
//		System.out.println(num);
//	}
//
//	public void println(Boolean check) {
//		System.out.println(check);
//	}
//
//	public void println(Double num) {
//		System.out.println(num);
//	}
//
//	public void println(String str) {
//		System.out.println(str);
//	}

	// 제너릭으로 쓸 파라미터, 리턴타입 아님!
//	public <T, M, L> void println(T t) {
	public <T> void println(T... t) {
//	Number의 자식이 들어오면됨, 제너릴 타입에 제한 걸기
//	public <T extends Number> void println(T t) {
		for (T ti : t) {
			System.out.println(ti);			
		}
	}
	
	public int sum(Integer...nums) {
		int s =0;
		for (Integer n : nums) {
			s += n;
		}
		return s;
	}
	
}
