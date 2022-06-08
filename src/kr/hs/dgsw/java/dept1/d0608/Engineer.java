package kr.hs.dgsw.java.dept1.d0608;

import java.util.Random;

public class Engineer implements Runnable {

	public final Counter counter;
	
	public Engineer(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		while(true) {
			String work = counter.getProblem();
			
			if(work != null) {
				System.out.println("스마트폰 수리를 시작합니다. - " + work);
				
				try {
					Thread.sleep(new Random().nextInt(10000) + 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("스마트폰 수리가 끝났습니다 - " + work);
			}else {
				synchronized (counter) {
					try {
						counter.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}
	}
}
