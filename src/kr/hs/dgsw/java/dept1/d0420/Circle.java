package kr.hs.dgsw.java.dept1.d0420;

public class Circle extends Polygon {

	protected final int r;
	
	public Circle(int r) {
		this.r = r;
	}
	
	@Override
	public String getType() {
		return "원";
	}
	
	@Override
	public double getArea() {
		return this.r * this.r * 3.14;
	}
	
	public static void main(String[] args) {
		Polygon circle = new Circle(5);
		circle.print();
	}
		
	
}
