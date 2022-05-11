package kr.hs.dgsw.java.dept1.d0511;

import java.io.File;
import java.util.Scanner;

public class FileMaker {

	protected final Scanner scanner;
	protected String name = "";
	
	
	public FileMaker() {
		this.scanner = new Scanner(System.in);
	}
	
	public void inputName() { 
		System.out.println("만드실 파일 이름을 입력해주세요.");
		this.name = this.scanner.next();
	}
	
	public void makeFile (String name) throws Exception {
		File file = new File("C:/Users/DGSW/eclipse-workspace/school_Java_Lang/" + name+ ".txt");
		file.createNewFile();
	}
	
	public void execute() throws Exception {
		this.inputName();
		this.makeFile(this.name);
	}
	
	
	public static void main(String[] args) throws Exception {
		FileMaker fileMaker = new FileMaker();
		fileMaker.execute();
	}
	
}
