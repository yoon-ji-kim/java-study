package chapter03;

public class Goods {
	public static int countOfGoods =0;
	private String name;
	private int price;
	private int cntStock;
	private int cntSold;
	
	//작성 안하면 java가 넣어줌
	public Goods() {
		Goods.countOfGoods = Goods.countOfGoods +1;
		//같은 클래스 내에서는 Goods. 명시하지 않아도 됨 
	}
	
	public Goods(String name, int price, int cntStock, int cntSold) {
		this.name = name;
		this.price =price;
		this.cntStock = cntStock;
		this.cntSold = cntSold;
		//코드 중복 발생*
		countOfGoods = Goods.countOfGoods +1;
	}
	
	public int calcDiscountPrice(float discountRate) {
		//명시적 캐스팅 (큰->작은)
//		int i = (int)4.5;
		//암시적 캐스팅
//		float f = 3;
		return (int)(price *discountRate);
	}
	public void printInfo() {
		System.out.println(name + ":" + price + ":" + cntStock + ":" + cntSold);
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {  //price가 0보다 작은 값이 들어오는 경우 데이터 보호
			price = 0;
		}
		this.price = price;
	}
	public int getCntStock() {
		return cntStock;
	}
	public void setCntStock(int cntStock) {
		this.cntStock = cntStock;
	}
	public int getCntSold() {
		return cntSold;
	}
	public void setCntSold(int cntSold) {
		this.cntSold = cntSold;
	}
}
