package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10,10);
		//마우스 클릭 지점
//		point.setX(10);
//		point.setY(10);
//		point.show();
//		drawPoint(point1);
		draw(point1);
		point1.show(false);
//		point1.show(true);
//		point.disapear();

//		ColorPoint point2 = new ColorPoint();
//		point2.setX(20);
//		point2.setY(20);
//		point2.setColor("red");
//		drawColorPoint(point2);
		
//		ColorPoint colorPoint = new ColorPoint();
//		Point point2 = colorPoint;  //upcasting이 일어남
//		ColorPoint colorPoint2 = (ColorPoint)point2; //부모 -> 자식으로 변환은 명시적으로 해야함)
		Point point2 = new ColorPoint(20, 20, "red"); 
//		point2.setX(20);
//		point2.setY(20);
//		((ColorPoint)point2).setColor("red");
//		drawPoint(point2);
		draw(point2);
		Rect rect = new Rect();
//		drawRect(rect);
//		drawShape(rect);  //암시적 캐스팅 일어남
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawTriangle(triangle);
//		drawShape(triangle); 
		draw(triangle);
		
		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("Hello World!"));
		
		//instanceof 연산자 Test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
//		compile 안되는 것 주의!
//		오류: 연산자 우측이 클래스인 경우, reference하고 있는 class타입의 hierarchy 상의 자식과 부모만 instanceof 연산자를 사용할 수 있다.
//		System.out.println(circle instanceof String);
//		System.out.println(circle instanceof Rect);
		Object o = circle;
		System.out.println(o instanceof String);
//		연산자의 우측한이 인터페이스인 경우, 계층 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
//	public static void drawPoint(Point point) {
//		point.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
////		colorPoint.show(true); //show()가 override되어있어서 가능
//		colorPoint.show();
//	}
	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	public static void drawCircle(Circle circle) {
//		circle.draw();
//	}

}
