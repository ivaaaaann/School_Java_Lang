package kr.hs.dgsw.java.dept1.d0518;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Divider {

	private final Scanner scanner;
	
	public Divider() {
		this.scanner = new Scanner(System.in);
	}
	
	private int calculate(int value1, int value2) {
		return value1 / value2;
	}
	
	private void execute() {
		try {

			System.out.println("두 정수를 입력하세요.");
			
			int value1 = scanner.nextInt();
			int value2 = scanner.nextInt();
			
			int result = calculate(value1, value2);
			System.out.printf("%d / %d = %d\n", value1, value2, result);
		    boolean saved =	saveResult(value1, value2 , result);
			System.out.println("파일 저장 결과 : " +  saved);
			
			System.out.println("프로그램을 종료합니다.");
			
		} catch(InputMismatchException e) {
			System.out.println("올바른 정수가 아니여서 계산을 수행할 수 없습니다.");
		
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		
		} finally {
			this.scanner.close();	
		}
		
		
		//	catch (Exception e) {
//			System.out.println("예외가 발생했습니다. - " + e);
//			
//			if(e instanceof InputMismatchException) {
//				System.out.println("올바른 정수가 아니여서 계산을 수행할 수 없습니다.");
//			}else if(e instanceof ArithmeticException) {
//				System.out.println("0으로 나눌 수 없습니다.");
//			}
//			
//		}
		
	}
	
	public static final String FILE_PATH = "C:/Users/DGSW/eclipse-workspace/school_Java_Lang/hello.txt";
	
	private boolean saveResult(int value1, int value2, int result) {
		OutputStream os = null;
		try {
			File file = new File(FILE_PATH);
			os = new FileOutputStream(file);
			
			String str = String.format("%d / %d = %d\n", value1, value2, result);
			os.write(str.getBytes());
			
			return true;
		} catch (IOException e) {
			System.out.println("파일 저장에 실패하였습니다.");
	
		} finally {
			System.out.println("saveResult의 finally가 수행됨");
			
			try {
				os.close();
			} catch (IOException e1) {}
		}
		 
		
		return false;
	}
	
	public static void main(String[] args) {
		Divider divider = new Divider();
		divider.execute();
	}
}
