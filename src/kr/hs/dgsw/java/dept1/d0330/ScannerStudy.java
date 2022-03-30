package kr.hs.dgsw.java.dept1.d0330;

import java.util.Scanner;

public class ScannerStudy {
	private final Scanner scanner;
	
	public ScannerStudy() {
		this.scanner = new Scanner(System.in);
	}
	
	public void execute() {
		
		String input = null;
		int value = 0;
		
//		while(true) 
		

		{
			System.out.println("단어를 입력하세요.");
			input = this.scanner.next();
			
			System.out.printf("당신은 %s를 입력하였습니다 \n", input);
		
			System.out.println("정수를 입력하세요.");
			value = this.scanner.nextInt();
			System.out.printf("%d 제곱은 %d입니다 \n", value, (value * value));

			
		}
		
		this.scanner.close();
	}
	
	public static void main(String[] args) {
		ScannerStudy scannerStudy = new ScannerStudy();
		scannerStudy.execute();
	}
	
}
