package kr.hs.dgsw.Ex1;

public class People {
	String name;
	double height;
	double weight;
	double bmi;
	
	
	public void printBmi () {
		System.out.printf("%s의 비만도는 %.2f이고 ", name, bmi);
		
		if(bmi < 20) {
			System.out.printf("저체중입니다.");
		}
		else if(bmi >= 20 && bmi <=25) {
			System.out.println("표준체중입니다.");
		}
		else {
			System.out.println("과체중입니다.");
		}
	}
	
	public void bmiCalculator() {
		bmi = weight/ ((height * height) / 10000);
	}
}
