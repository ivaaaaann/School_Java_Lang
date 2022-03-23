package kr.hs.dgsw.java.dept1.d0323;

public class DataTypeStudy {

	public void studyIntegerType() {
		int intValue = 2000000000;
		byte byteValue = -128;
		short shortValue = 32767;
		long longValue = 3000000000111L;
		
		Integer integer  = 1;
		
	}
	
	public void studyRealNumberType() {
		float piFloat = 3.1416926123456789F;
		double piDouble = 3.1416926123456789012345678;
		
		System.out.println(piFloat);
		System.out.println(piDouble);
	}
	
	public void studyBoolean () {
		
		System.out.println((4 > 2));
		
		boolean flag  = true;
		boolean win = false;
		
		if (4 > 2) {
			
		}
	}
	
	public void studyChar() {
		char ch1 = 'A';
		String str = "";
		int ch2 = 65;
		
		System.out.println((int)ch1);
		System.out.println((char)ch2);
		
		char h1 = '가';
		char h2 = '힣';
		System.out.println((int)h1);
		System.out.println((char)44033);
		
		System.out.println(h2- h1 + 1);
		
//		for(int i =30000; i<=40000;i ++) {
//			char ch = (char)i;
//			System.out.printf("%03d %02x - %c\n",i, i, ch );
//		}
	}
	
	public static void main(String[] args) {
		DataTypeStudy study = new DataTypeStudy();
		study.studyChar();
	}

}
