package chapter03;

public class GoodsApp {
	public static void main(String[] args) {
		//객체 생성
		Goods camera = new Goods();
		//객체 사용& 값 세팅
		camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCntStock(30);
		camera.setCntSold(50);
		//객체 프린트
		camera.printInfo();
	}

}
