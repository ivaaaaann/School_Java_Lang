package kr.hs.dgsw.java.dept1.d0420;

public class Square extends Rectangle {
	
	Square(int width) {
		super(width, width);
	}
	
	@Override
	public String getType() {
		return "정사각형";
	}


	public static void main(String[] args) {
		Polygon square = new Square(5);
		square.print();
	}
	
}
