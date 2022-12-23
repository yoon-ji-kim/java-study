package prob5;

import java.util.Arrays;

public class MyStack {

	private String[] buffer;
	private int idx;
	public MyStack(int size) {
		buffer = new String[size];
		idx =-1;
	}
	public void push(String string) {
		idx++;
		if(idx == buffer.length-1) {
			buffer = createBuffer(buffer.length);
		}
		buffer[idx] = string;
	}
	private String[] createBuffer(int length) {
		String[] result = Arrays.copyOf(buffer, length*2);
		return result;
	}
	public boolean isEmpty() {
		if(idx <0) return true;
		else return false;
	}
	public String pop() throws MyStackException {
		if(idx<0) {
			throw new MyStackException();
		}
		String result = buffer[idx];
		idx--;
		return result;
	}
	
}