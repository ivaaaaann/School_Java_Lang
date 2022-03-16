package kr.hs.dgsw.java.dept21;

public class Dog {
	
	String color;
	
	double weight;
	
	String name;
	
	public void makeSound() {
		System.out.println("닝닝");
	}
	
	public void eat(String food) {
//		System.out.println(name + "이(가)" + food + "을 먹는다." );
	
		System.out.printf("%s 이(가) %s을(를) 먹는다\n",name, food);
	}

	public void printInfo() {
//		System.out.println("이름 : "+name+" 몸무게 : "+ weight+" 색깔 : "+color);
		System.out.printf("이름 %s\n",name);
		System.out.printf("몸무게 %f\n",weight);
		System.out.printf("색깔 %s\n", color);

	}
	
}
