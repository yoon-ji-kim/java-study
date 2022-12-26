package prob5;

import java.util.Arrays;

//제너릭 클래스
public class MyStack03<T> {
	private T[] buffer; //사용자가 외부에서 결정해준 T로 들어옴
	private int idx;
	
	public MyStack03(int size) {
//		buffer = new T[size];  XX
//		방법1. T로 캐스팅해주기
		buffer = (T[])new Object[size];
		idx =-1;
	}
	public void push(T t) {
		idx++;
		if(idx == buffer.length-1) {
			createBuffer(buffer.length);
		}
		buffer[idx] = t;
	}
	private void createBuffer(int length) {
		T[] result = Arrays.copyOf(buffer, length*2);
		buffer = result;
	}
	public boolean isEmpty() {
		if(idx <0) return true;
		else return false;
	}
	public T pop() throws MyStackException {
		if(idx<0) {
			throw new MyStackException();
		}
		T result = buffer[idx];
		idx--;
		return result;
	}
	
}