package kr.hs.dgsw.java.dept1.d0504;

public class WriterTest {

	protected final Writer writer;
	
	public WriterTest() {
		this.writer = new FileWriter("C:\\add.txt");
	}
	
	public void add(int value1, int value2) {
		int result = value1 + value2;
		
		String output = String.format("%d + %d = %d", value1, value2, result);
		
		writer.write(output);
	}
	
	public static void main(String[] args) {
//		
//		String value =  "예외가 없는 법칙은 없다 ㅋㅋ";
//		
//		Writer simpleWriter = new SimpleWriter();
//		simpleWriter.write(value);
//	
//		Writer fileWriter = new FileWriter("C:\\may.txt");
//		fileWriter.write(value);
		
		WriterTest tester = new WriterTest();
		tester.add(4, 8);
		
	}
	
}
