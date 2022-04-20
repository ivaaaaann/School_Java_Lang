package kr.hs.dgsw.java.dept1.d0420;

import java.util.Scanner;

public class Adder {

	protected final Scanner scanner;
	
	
	public Adder() {
		this.scanner = new Scanner(System.in);
	}
	
	public Values inputValues () {
		
		int input1 = 0; 
		int input2 = 0;
		Values values = new Values();
		
		System.out.println("첫번째 정수를 입력하세요 ");
		input1 = this.scanner.nextInt();
		values.setValue1(input1);
		System.out.println("두번째 정수를 입력하세요 ");
		input2 = this.scanner.nextInt();
		values.setValue2(input2);
		
		return values;
	}
	
	public int calculate(Values values) {
		return values.getValue1() + values.getValue2();
	}
	
	public void showResult (Values values, int result) {
		System.out.printf("%d %s %d = %d\n", values.getValue1(), getOperator() , values.getValue2(), result);
	}
	
	public String getOperator() {
		return "+";
	}
	
	public void execute() {
		
		Values values = this.inputValues();
		
		int result = this.calculate(values);
		
		this.showResult(values, result);
		
		this.scanner.close();
	}
	
	public class Values {
		private int value1;
		
		private int value2;

		public int getValue1() {
			return value1;
		}

		public void setValue1(int value1) {
			this.value1 = value1;
		}

		public int getValue2() {
			return value2;
		}

		public void setValue2(int value2) {
			this.value2 = value2;
		}
	
		
		
	}
	
	public static void main(String[] args) {
		Adder adder = new Adder();
		adder.execute();		
	}
	
}
