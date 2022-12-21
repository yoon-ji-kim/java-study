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
		
//      가격이 이상한 값을 넣으면 로직을 통해 데이터 보호	(정보은닉)
		camera.setPrice(-1);
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		camera.setPrice(4000000);;
		System.out.println(camera.calcDiscountPrice(0.5f));
		
		
		//TV
		Goods tv = new Goods("TV", 4000000, 10, 20);
		tv.printInfo();
		System.out.println(Goods.countOfGoods);
	}

}
