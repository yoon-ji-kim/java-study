package prob05;

public class Prob05 {

	public static void main(String[] args) {
		//MyBase가 Base의 자식 ,Base 수정 ㄴㄴ
		Base base = new MyBase();

		base.service("낮");
		base.service("밤");
		base.service("오후"); 
	}
}
