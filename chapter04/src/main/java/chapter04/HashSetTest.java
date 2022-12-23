package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Rect> set= new HashSet<>();
//		hash code 비교하고, 동질 검사함
		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		Rect r3 = new Rect(4, 50);
//		객체가 달라 주소값 다름 ->해쉬코드 다름-> set에 들어감		
		set.add(r1);
		set.add(r2);
		set.add(r3);
		//순회
		for (Rect r : set) {
			System.out.println(r);
		}
	}

}
