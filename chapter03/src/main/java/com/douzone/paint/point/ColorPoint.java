package com.douzone.paint.point;

public class ColorPoint extends Point {
//부모의 기본 생성자가 없어서 오류 발생!
	private String color;
	
	public ColorPoint(int x, int y, String color) {
//		this.x = x; //부모의 x는 private이라서 사용 불가
//		setX(x);
//		setY(y);
		super(x, y);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	//오버라이드(재구현)
	@Override 				//컴파일러가 override라고 알 수 있음
	public void show() {
//		super.show(); //부모 기능 부분 재구현
//		부모 x는 private이라서 가져올 수 없음
//		System.out.println("점(x=" +x+", y="+y+")을 그렸습니다.");
		System.out.println("점(x=" +getX()+", y="+getY()+")을 color="+color+"로 그렸습니다.");
	}
	
	
}
