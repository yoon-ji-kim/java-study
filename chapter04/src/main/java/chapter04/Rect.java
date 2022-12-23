package chapter04;

import java.util.Objects;

public class Rect {
	private int w; //너비
	private int h; //높이
	
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	//내용 출력.
	@Override
	public String toString() {
		return "Rect [w=" + w + ", h=" + h + "]";
	}
//  주석하면 equals만 비교
	@Override   //내용기반 hashCode로 바꿔서 비교
	public int hashCode() {
		return Objects.hash(h, w);
	}
	//hashcode and equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
//		return h == other.h && w == other.w;
//		동질의 조건을 넓이로 변경
		return h*w == other.h * other.w;
		
	}
	
	
}
