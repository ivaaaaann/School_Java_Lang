package kr.hs.dgsw.java.dept1.d0330;

public class Cat {

	private final String name;
	private final String color;
	private Double weight;
	
	public Cat(String name, String color) {
		this(name,color, 0);
	}
	
	public Cat(String name, String color, double weight) {
		this.name = name;
		this.color= color;
		this.weight = weight;
	}
	
	public void catPrint( ) {
		System.out.printf("%s는 %s색깔이고, 몸무게는 %f 입니다.", this.name, this.color, this.weight);
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.weight;
	}

	
	public static void main(String[] args) {
		Cat persian = new Cat("페르시안", "검정");
		persian.catPrint();
	}
}
