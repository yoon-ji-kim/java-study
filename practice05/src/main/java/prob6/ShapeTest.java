package prob6;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		//Shape를 상속받은 Rect, RecTri
//    abstract 클래스 만들기
		Shape[] list = new Shape[2];
		list[0] =  new Rectangle(5, 6);
		list[1] = new RectTriangle( 6, 2);
		
		for( Shape shape : list ) {
			System.out.println( "area:" + shape.getArea() );
//			                                    둘레
			System.out.println( "perimeter:" + shape.getPerimeter() );
			
			if( shape instanceof Resizable ) {
				Resizable resizable = (Resizable) shape;
				resizable.resize( 0.5 );
				System.out.println( "new area:" + shape.getArea() );
				System.out.println( "new perimeter:" + shape.getPerimeter() );
			}
		}
	}
}