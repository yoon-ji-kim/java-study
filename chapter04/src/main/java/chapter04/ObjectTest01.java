package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
//		Class klass = point.getClass(); //reflection
		//println에서 불러서 객체의 toString 호출
		System.out.println(point);
		System.out.println(point.toString()); //getClass() + "@"+ hashCode() 
		System.out.println(point.getClass());
		System.out.println(point.hashCode()); // address 기반의 해싱값
		//address 기반의 해싱
		
	}

}
