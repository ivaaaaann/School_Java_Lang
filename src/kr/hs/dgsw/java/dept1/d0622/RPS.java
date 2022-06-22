package kr.hs.dgsw.java.dept1.d0622;

import java.util.Random;
import java.util.Scanner;

public class RPS {

	protected final Scanner scanner;
	protected final String[] cases  = new String[] {"가위","바위","보"};
	protected int winsNumber = 0;
	protected int drawNumber = 0;
	protected int loseNumber=  0;
	
	public RPS() {
		scanner = new Scanner(System.in);
	}
	
	//-1은 패배 0은 무승부 1은 승리
	
	public String gameReader(String userCase, String computerCase) {
		if(userCase.equals("가위")) {
			if(computerCase.equals("가위")) {
				drawNumber++;
				return "비겼습니다.";
			}else if(computerCase.equals("바위")) {
				loseNumber++;
				return "당신이 졌습니다.";
			}else if(computerCase.equals("보")) {
				winsNumber++;
				return "당신이 이겼습니다.";
			}
		}else if(userCase.equals("바위")) {
			if(computerCase.equals("가위")) {
				winsNumber++;
				return "당신이 이겼습니다.";
			}else if(computerCase.equals("바위")) {
				drawNumber++;
				return "비겼습니다.";
			}else if(computerCase.equals("보")) {
				loseNumber++;
				return "당신이 졌습니다.";
			}
		} else if(userCase.equals("보")){
			if(computerCase.equals("가위")) {
				loseNumber++;
				return "당신이 졌습니다.";
			}else if(computerCase.equals("바위")) {
				winsNumber++;
				return "당신이 이겼습니다.";
			}else if(computerCase.equals("보")) {
				drawNumber++;
				return "비겼습니다.";
			}	
		} 
		return "당신이 졌습니다.";
	
	}
	
	public void execute() {
		
		
		while(true) {
			System.out.println("가위바위보 가운데 하나를 입력하세요.");
			String res = scanner.nextLine();
			
			if(res.equals("quit")) {
				System.out.printf("총 전적 : %d승 %d무 %d패 ", winsNumber, drawNumber, loseNumber);
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(res.equals("가위")||res.equals("바위")||res.equals("보")) {
				Random random = new Random();
				String computerCase = cases[random.nextInt(cases.length)];
				System.out.printf("%s vs %s ", res, computerCase);
				System.out.println(gameReader(res, computerCase));
			}else {
				System.out.println("다시 입력해주세요.");
			}
			
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		RPS rps = new RPS();
		rps.execute();
	}
	
}
