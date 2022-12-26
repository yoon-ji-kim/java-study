package com.douzone.paint.collection;

import java.util.Arrays;

public class MyStack<T> {

	private T[] buffer;
	private int idx;
	public MyStack(int size) {
		buffer = (T[])new Object[size];
		idx =-1;
	}
	public void push(T t) {
		idx++;
		if(idx == buffer.length-1) {
			buffer = createBuffer(buffer.length);
		}
		buffer[idx] = t;
	}
	private T[] createBuffer(int length) {
		T[] result = Arrays.copyOf(buffer, length*2);
		return result;
	}
	public boolean isEmpty() {
		if(idx <0) return true;
		else return false;
	}
	public T[] pop() throws MyStackException {
		if(idx<0) {
			throw new MyStackException();
		}
		T[] result = (T[]) buffer[idx];
		idx--;
		return result;
	}
	
}