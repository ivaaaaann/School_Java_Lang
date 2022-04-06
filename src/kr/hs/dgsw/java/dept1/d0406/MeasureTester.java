package kr.hs.dgsw.java.dept1.d0406;

import java.util.Scanner;

public class MeasureTester {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Measure measure = new Measure();
		
		int num1= scanner.nextInt();
		scanner.close();
		
		measure.num = num1;
		measure.Calculator();
		measure.Print();
		
	}
	
}
