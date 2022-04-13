package kr.hs.dgsw.java.dept1.d0413;

public class Queue {

	public static final int SIZE = 10;
	
	private final String[] buffer;
	
	private int index = -1;


	
	
	
	public Queue() {	
		this.buffer = new String[SIZE];
	}
	
	public void add(String value) {
		if(index >= SIZE -1) {
			throw new RuntimeException("Full");
		}
		this.index ++;
		this.buffer[index] = value;		
	}
	
	
	public String poll() {
		String backupItem = this.buffer[0];
		
		if(index < 0 ) {
			throw new RuntimeException("Empty");
		}
		
		for(int i = 1; i<= index; i ++) {
			this.buffer[i-1] = this.buffer[i];
		}
		
		this.index--;
		return backupItem;
	}

	
	public static void main(String[] args) {
		Queue queue = new Queue();
		

		System.out.println(queue.poll());
	}
	
	
}
