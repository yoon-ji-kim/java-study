package prob02;

public class Goods {
	private String name;
	private int price;
	private int countStock;
	public Goods(String name, int price, int countStock) {
		super();
		this.name = name;
		this.price = price;
		this.countStock = countStock;
	}
	public void print() {
		System.out.println(name+"(가격:"+price+"원)이 "+ countStock+"개 입고 되었습니다.");
	}
	
	
}
