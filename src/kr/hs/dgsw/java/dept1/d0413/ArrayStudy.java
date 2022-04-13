package kr.hs.dgsw.java.dept1.d0413;

public class ArrayStudy {
	public void studyArray() {
		{
			//선언
			int[] array1;
			int array2[];
		}
		
		{
			//정의
			int[] array1= new int[5];
			array1[0] = 3;
			array1[1] = 5;
			
//			array1[100] = 20;
		}
	
		{
			//초기화
			int[] intArray = new int[1];
			double[] doubleArray = new double[1];
			boolean[] booleanArray = new boolean[1];
			String[] StringArray = new String[1];
			
			System.out.println("intArray : " + intArray[0]);
			System.out.println("doubleArray : " + doubleArray[0]);
			System.out.println("booleanArray : " + booleanArray[0]);
			System.out.println("StringArray : " + StringArray[0]);
		}
		
		
		//정의 , 초기화
		String[] colors = {"red" , "green", "blue", "black", "magenta"};
		System.out.println("colors의 크기 : " + colors.length);
	
		//trace
		for(int i = 0; i< colors.length; i++) {
			System.out.printf("%d - %s\n", i , colors[i]);	
		}
		
		for(String  color: colors) {
			System.out.println(color);
		}
		
		{
			//평균값 구하기
			int[] ages = {18, 20, 30, 12, 5, 3, 7, 26, 15};
			
			double total = 0;
			double average = 0;
			
			for(int age : ages) {
				total += age;
			}
			
			average = total / ages.length;
			
			System.out.printf("평균 나이 : %.2f\n", average);
		}
		
		{
			int value1= 5;
			int value2 = value1;
			value2 = 10;
			
			System.out.println("int : " + value1 + " " + value2);
			
			int[] array1 = {1,2,3};
			int[] array2 = array1;
			int[] array3 = copy(array1);
			array2[1] = 100;
			
			System.out.println("array : " + array1[1] + " " + array2[1] + " " + array3[1]);
		
			
		}
			
		
	}
	
	public int[] copy(int[] array) {
		int [] newArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++) { 
			newArray[i] = array[i];
		}
		
		return newArray;		
	}
	
	
	

	
	
	public static void main(String[] args) {
		ArrayStudy study = new ArrayStudy();
		study.studyArray();
	}
		
	
}
