package kr.hs.dgsw.java.dept1.d0525;

public class Docter implements Doer {

	@Override
	public void work() {
		System.out.println("의사 선생님이 수슬을 합니다.");
	}

	@Override
	public void play() {
		System.out.println("의사 선생님이 돈 받고 놉니다.");
	}
	
}
