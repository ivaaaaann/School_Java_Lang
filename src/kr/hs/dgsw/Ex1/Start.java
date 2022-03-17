package kr.hs.dgsw.Ex1;

public class Start {
	public static void main(String[] args) {
		People 김영희 = new People();
		People 김철수 = new People();
		
		김영희.height = 165;
		김영희.weight = 55;
		김영희.name = "김영희";
		김철수.height = 170;
		김철수.weight = 90;
		김철수.name = "김철수";
		
		김영희.bmiCalculator();
		김영희.printBmi();
		김철수.bmiCalculator();
		김철수.printBmi();
	}
	
}
