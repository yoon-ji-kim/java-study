package prob5;

import java.util.Arrays;

public class MyStack {

	private String[] buffer;
	private int idx;
	public MyStack(int size) {
		buffer = new String[size];
		idx =0;
	}
	public void push(String string) {
		if(idx == buffer.length-1) {
			buffer = createBuffer(buffer.length);
		}
		buffer[idx++] = string;
	}
	private String[] createBuffer(int length) {
		String[] result = Arrays.copyOf(buffer, length*2);
		return result;
	}
	public boolean isEmpty() {
		if(idx <0) return true;
		else return false;
	}
	public String pop() {
		String result = buffer[idx--];
		return result;
	}
	
//	 인덱스 하나 올리고 넣고/ 넣고 올리던지
//	크기 넘어가면 배열 크기 두배정도로 늘리기
//	새 배열 만들어서 buffer가 새 배열로 가게 (method로 만들기)
	
}