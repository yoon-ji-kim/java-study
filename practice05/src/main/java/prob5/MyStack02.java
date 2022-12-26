package prob5;

import java.util.Arrays;

public class MyStack02 {

//	private Integer[] buffer;
	private Object[] buffer;
	private int idx;
	public MyStack02(int size) {
		buffer = new String[size];
		idx =-1;
	}
	public void push(Object string) {
		idx++;
		if(idx == buffer.length-1) {
			createBuffer(buffer.length);
		}
		buffer[idx] = string;
	}
	private void createBuffer(int length) {
		Object[] result = Arrays.copyOf(buffer, length*2);
		buffer = result;
	}
	public boolean isEmpty() {
		if(idx <0) return true;
		else return false;
	}
	public Object pop() throws MyStackException {
		if(idx<0) {
			throw new MyStackException();
		}
		Object result = buffer[idx];
		idx--;
		return result;
	}
	
}