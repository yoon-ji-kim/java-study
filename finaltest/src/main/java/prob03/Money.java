package prob03;

import java.util.Objects;

public class Money {
	private int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public Object add(Money m) {
		return new Money(this.amount+ m.amount);
	}

	public Object minus(Money m) {
		return new Money(this.amount- m.amount);
	}

	public Object multiply(Money m) {
		return new Money(this.amount * m.amount);
	}

	public Object devide(Money m) {
		return new Money(this.amount/ m.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
//		obj객체가 Money 타입인지 확인, 금액이 동일한지 확인
		if (obj instanceof Money && this.amount == ((Money) obj).amount)
			return true;
		else return false;
	}
	
}
