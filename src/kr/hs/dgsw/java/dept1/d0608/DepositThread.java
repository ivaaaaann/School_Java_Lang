package kr.hs.dgsw.java.dept1.d0608;

public class DepositThread implements Runnable {

	private final String name;
	private final Bank bank;
	private final int ammount;
	
	public DepositThread (String name, Bank bank, int ammount) {
		this.name = name;
		this.bank = bank;
		this.ammount = ammount;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		bank.deposit(name, ammount);
	}
	
}
