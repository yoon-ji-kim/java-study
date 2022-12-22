package prob6;

public class RectTriangle extends Shape {
	private double w, h;

	public RectTriangle(double w, double h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double getArea() {
		return (w*h)/2;
	}

	@Override
	public double getPerimeter() {
		return w + h +Math.sqrt((Math.pow(w, 2)+ Math.pow(h, 2)));
	}

}
