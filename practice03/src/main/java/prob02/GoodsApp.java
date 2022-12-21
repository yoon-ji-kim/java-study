package prob02;

import java.util.Scanner;

public class GoodsApp {
	//final 상수, 대문자로 작성
//	메소드 정의(오버라이드X라는 의미), 변수 앞, 클래스 앞(상속 금지)에 올 수 있음 
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i=0; i<COUNT_GOODS; i++) {
			String info = scanner.nextLine();
			String[] infos = info.split(" ");
			
			Goods infosToGoods = new Goods(infos[0], Integer.parseInt(infos[1]), Integer.parseInt(infos[2]));
			goods[i] = infosToGoods;
		}
		// 상품 출력
		for(int i=0; i<COUNT_GOODS; i++) {
			goods[i].print();
		}
		// 자원정리
		scanner.close();
	}
}
