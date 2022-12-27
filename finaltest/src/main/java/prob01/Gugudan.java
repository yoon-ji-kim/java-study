package prob01;

import java.util.Objects;

public class Gugudan {
	//gugudan을 set에 넣기
//	2,3 -> 3,2 도 들어가면 안됨
//	equals랑 HashCode 잘 override하는 문제
	private int lValue;
	private int rValue;
	
	public Gugudan(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lValue * rValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gugudan other = (Gugudan) obj;
//		return (lValue == other.lValue && rValue == other.rValue) || (lValue == other.rValue && rValue == other.lValue);
		return lValue * rValue == other.lValue*other.rValue;
	}
	
	public int mul() {
		return lValue * rValue;
	}
	
}
