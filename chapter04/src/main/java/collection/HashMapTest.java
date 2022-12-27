package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		
		m.put("one", 1);	//auto boxing이 일어남
		m.put("two", 2);
		m.put("three", 3);
		
		int i = m.get("one"); //auto unboxing 일어남
		int j = m.get(new String("one"));
		System.out.println(i + ":" + j);

		//같은 키가 들어오면 현재 키 값을 바꿈
		m.put("three", 33333);
		System.out.println(m.get("three"));
		
		//Iterator가 없어 순회가 안되지만 key를 통해 순회할 수 있다.
		Set<String> s = m.keySet();
		for(String k : s) {
			System.out.println(m.get(k));
		}
		
	}

}
