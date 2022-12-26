package collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		//예전 Vector
		//내부적으로 동기화가 되어 있어 synchronized할 필요 없음
//		synchronized (v) {
			v.addElement("둘리");
			v.addElement("마이콜");
			v.addElement("도우너");			
//		}
			
//		순회1.
		for(int i=0; i< v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
//		삭제 (값을 비교해서 삭제함)
		v.removeElement("둘리");
//		순회2.
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			//순서대로 가져옴
			String s = e.nextElement();
			System.out.println(s);
		}
	} 

}
