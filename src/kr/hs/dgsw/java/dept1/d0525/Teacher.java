package kr.hs.dgsw.java.dept1.d0525;

public class Teacher implements Expert {

	 @Override
	 public void work() {
		System.out.println("선생님이 학생을 가르칩니다.");
	 }
	
	 @Override
	 public void play() {
		 System.out.println("선생님이 돈 받고 유튜브를 봅니다.");
	 }
	 
	 @Override
	 public void teach() {
		 System.out.println("선생님이 학생을 잘 가르칩니다.");
	 }
	
}
