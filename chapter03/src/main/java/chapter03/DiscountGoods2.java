package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	//값을 표현하는 것: 표현식
	//방법: 리터럴(문자그대로), 변수, 연산식
//	int i = 10;
//	String s = "dqwdqwdqw";
//	private double discountrate = 0.5;
//	private Long i = 1122L;
	private float discountrate = 0.5f;
	
	public float getDiscountPrice() {
		//protected는 자식에서 접근 가능
		return discountrate*price;
		//변수 price는 Goods2의 변수 
	}
}
