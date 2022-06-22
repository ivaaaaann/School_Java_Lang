package kr.hs.dgsw.java.dept1.d0615;

public class Generic<T1, T2> {
	
	private T1 value;
	
	private T2 id;
	
	public T1 getValue() {
		return value;
	}
	
	public void setValue(T1 value) {
		this.value = value;
	}
		
	public T2 getId() {
		return id;
	}
	
	public void setId(T2 id) {
		this.id = id;
	}
	
	public static void main(String[] args) {
		
		Generic<String, Integer> generic = new Generic<String, Integer>();
		generic.setValue("korea");
		
		Generic<Integer, String> generic1 = new Generic<Integer, String>();
		generic1.setValue(123);		
		
	}

	
}
