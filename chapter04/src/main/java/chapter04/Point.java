package chapter04;

import java.util.Objects;

public class Point{
	private int x;
	private int y;
	//기본 생성자 없음
	public Point() {
		
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void draw() {
		show();
	}
	public void show() {
		System.out.println("점(x=" +x+", y="+y+")을 그렸습니다.");
	}
	
	public void show(boolean visible) {
		if(visible) {
//			System.out.println("점(x=" +x+", y="+y+")을 그렸습니다.");			
			show();
		}else {
			System.out.println("점(x=" +x+", y="+y+")을 지웠습니다.");			
		}
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
//  직접 작성 xxx source generate 이용	
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj) {
//			return true;
//		}
//		if(obj == null) {
//			return false;
//		}
//		//obj가 null도 아니고 동일하지 않음 -> 타입 검사
//		if(obj.getClass() != this.getClass()) {
//			return false;
//		}
//		Point other = (Point)obj; //명시적 캐스팅
//		
//		return x == other.x && y == other.y;
//	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
		//31씩 곱해짐 
		//** 내용을 가지고 해싱함 -> 내용이 같으면 해시코드가 같을 수! 있음 
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}
