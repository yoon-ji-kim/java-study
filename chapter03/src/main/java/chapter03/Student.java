package chapter03;

public class Student extends Person {
	//기본 생성자
	public Student() {
//		자식 생성자에서 부모를 명시적으로 호출하지 않으면,
//		자동으로 부모의 기본 생성자를 호출하게 된다.
//		부모에 생성자가 없다면 오류 발생 확률이 있음
//		super();
//		규칙: 부모생성자를 명시할 경우 앞에다가 작성 
		System.out.println("Student() called");
	}
}
