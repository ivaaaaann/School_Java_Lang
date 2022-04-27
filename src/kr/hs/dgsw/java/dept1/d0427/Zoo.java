package kr.hs.dgsw.java.dept1.d0427;

public class Zoo {

	public void breed(Animal animal) {
		animal.printSound();
	}

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		Dog dog= new Dog();
		zoo.breed(dog);
		
		Cat cat = new Cat();
		zoo.breed(cat);
		
		Horse horse = new Horse();
		zoo.breed(horse);
	}
	
}
