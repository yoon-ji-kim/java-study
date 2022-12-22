package prob6;

public class Rectangle extends Shape implements Resizable{
	private double w, h;

	public Rectangle(double w, double h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double getArea() {
		return w * h;
	}

	@Override
	public double getPerimeter() {
		return (w + h) * 2;

	}

	@Override
	public void resize(double s) {
		w = w*s;
		h = h*s;
	}

}
