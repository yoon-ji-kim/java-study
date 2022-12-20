package chapter03;

public class Goods {
	private String name;
	private int price;
	private int cntStock;
	private int cntSold;
	
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
