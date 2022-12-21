package mypackage;

public class Goods2 {
	//접근제한자
	public String name;			// 접근제한없음
	protected int price;		// 같은 패키지& 자식 클래스에서 접근 가능**
	int countStock;				// (default) 같은 패키지
	private int countSold;		// 클라스 내부에서만
	
	public void m() {
		countSold = 50; 		//클래스 내에서 countSold에 접근 가능
	}
}
