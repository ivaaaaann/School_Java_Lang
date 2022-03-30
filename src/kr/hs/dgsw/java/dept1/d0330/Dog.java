package kr.hs.dgsw.java.dept1.d0330;

public class Dog {

	private final String name;
	private int age;
	
	public Dog(String name) {
		this(name, 0);
	}
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("생성자가 호출됨");
	}
	
	public void print() {
		System.out.printf("%s는 나이가 %d살입니다.", this.name, this.age);
	}
	
	public String getName () {
		return this.name;
	}

	public String getName(String dummy) {
		return this.age + "";
	}
	
	public static void main(String[] args) {
		
		Dog happy = new Dog("해피", 2);
		happy.print();
		
		System.out.println("Count of args : "  + args.length);
		for(int i = 0; i< args.length; i++) {
			System.out.printf("%d - %s\n", i, args[i]);
		}
		
	}
	
}
