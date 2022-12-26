package com.douzone.paint.collection.test;

import java.util.ArrayList;
import java.util.List;

import com.douzone.paint.collection.MyStack;
import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;

public class GenericTest {
	public static void main(String[] args) {
		drawShape(new Rect());
//		The method drawShape(T) in the type GenericTest is not applicable for the arguments
//		drawShape(new Point());
		
		MyStack<? extends Shape> s1 = null;
		MyStack<? super Shape> s2 = null;
		
		List<Rect> list1 = new ArrayList<>();
		List<Shape> list2 = new ArrayList<>();
		
		MyStack<Drawable> s = new MyStack<>(20);
		drawShapeLayer(list1, null);
		drawShapeLayer(list2, s);
	}
	
	/*
	 * Generic Parameter 타입 제한하기 01. extends
	 * 	1) hierachy max
	 *  2) 자신과 자식들만 제너릭 타입을 쓸 수 있음
	 */
	public static <T extends Shape> void drawShape(T t) {
//		t.draw(); --> XX shape의 자식 넣기 extends Shape
		t.draw();
	}
	/*
	 * Generic Parameter 타입 제한하기 02. super
	 *  1) hierachy min
	 *  2) 자신과 부모들만 제너릭 타입을 쓸 수 있음
	 *  3) <T super Type> : 오류 
	 *  	-> 함수(클래스) 구현 블록 안에서 T타입이 모호하기 때문에 구현이 불가능
	 *      -> 문법적으로 Type Erasing의 결과 Object이기 때문에 문법적인 의미가 없음
	 *  -> <T super Type>은 존재하지 않는다.
	 *  <? super Type>으로 특수한 경우 사용함 ->메소드와 클래스에는 사용 못함
	 */
//	public static <T super Shape> void drawShape(T t) {
//				 -> Object라 문법적으로 XX
//	public static <? super Shape> void drawShape(T t) {
//		t.draw();
//	}
	/*
	 * ? : Generic Parameter Wildcard
	 *  1) 제네릭 타입의 클래스를 사용할 때, 
	 *  	제한(extends, super와 함께)적으로 제너릭 타입을 결정해야 할 때 사용
	 *  2) 사용할 수 없는 예
	 *  	- 클래스를 제네릭 타입으로 정의할 것인가? MyStack<T>, MyStack<T extends TYPE>으로 해야함
	 *  		- MyStack<?> x
	 *  	- 클래스를 Shape 자식의 제네릭 타입으로 정의할까? -> <T extends Shape>으로 작성해야함
	 *  		- MyStack<? extends Shape> X
	 *  	- 메소드의 ex)첫 번째 파라미터를 제너릭 타입으로 할 것인가? -> <?> void m(? t)라고 작성할 수 없음
	 *  	- 메소드의 첫 번째 파라미터를 Shape 자식의 제너릭 타입으로 할까?
	 *  		- <? extends Shape m(? t) X
	 *  3) 사용할 수 있는 예
	 *  	- 사용할 제네릭 클래스의 제네릭 파라미터를 Shape의 자식으로만 하자
	 *  	- 		MyStack     <T>
	 *  	- ex MyStack<? extends Shape> s = null;
	 *  	- 사용할 제네릭 클래스의 제네릭 파라미터를 Shape의 부모로만 하자
	 *  	- MyStack<? super Shape>
 	 */
	
//	public static void drawShapeLayer(List<> in, MyStack out) {
//		잘못된 사용
//		MyStack<? extends Shape > s1 = new MyStack<>(10);
//		s1.push(new Rect());
	public static void drawShapeLayer(
			List<? extends Shape> in,  			//Producer 만드는거 Lower Bounded Shape에서 확장될 수 있는것
			MyStack<? super Drawable> out) {	//Consumer 쓰는거  Upper Bounded Drawable에 있는 것만 사용할 수 있는것
		
		for(Shape s:in) {
			out.push(s);
		}
	}
}
