package chapter03;

import mypackage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 g = new Goods2();
		g.name = "camera"; 			//public 모든 접근 가능
//		g.price = 10000;			//protected 같은 패키지/자식클래스에서 접근 가능
									//자식에서 접근 가능하다는 것이 더 중요!
//		g.countStock = 30;			//디폴트는 같은 패키지에서 접근 가능
//		g.countSold = 50;			//private은 같은 클래스에서만 접근할 수 있어 보이지 않음
		
	
	}

}
