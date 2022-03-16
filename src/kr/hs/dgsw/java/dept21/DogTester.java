package kr.hs.dgsw.java.dept21;

public class DogTester {
	public static void main(String[] args) {
		Dog welshCorgi = new Dog();
		welshCorgi.name="웰시코기";
		welshCorgi.weight=8.5;
		welshCorgi.color="베이지색";
		
		welshCorgi.eat("사료");
		welshCorgi.makeSound();
		welshCorgi.printInfo();
	}
}
