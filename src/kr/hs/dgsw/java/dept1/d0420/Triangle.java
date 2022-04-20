package kr.hs.dgsw.java.dept1.d0420;

public class Triangle extends Polygon {
	protected final  double width;
	protected final double height;

	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String getType() {
		return "삼각형";
	}
	
	@Override
	public double getArea() {
		return this.width * this.height / 2;
	}
	
	public static void main(String[] args) {
		Polygon triangle = new Triangle(5, 16);
		triangle.print();
	}
}
