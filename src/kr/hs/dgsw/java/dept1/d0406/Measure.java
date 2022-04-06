package kr.hs.dgsw.java.dept1.d0406;

import java.util.ArrayList;
import java.util.Comparator;

public class Measure {
	int num;
	
	ArrayList<Integer> arr = new ArrayList();
	
	public void Calculator () {
		for (int i = 1; i * i < num; i++ ) {
			if(num % i  == 0) {
				arr.add(i);
				arr.add(num/i);
			}
		}
	}
	
	public void Print() {
		arr.sort(Comparator.naturalOrder());
		System.out.printf("%d의 약수는 " , num);
		for(int i = 0; i< arr.size(); i++) {
			if(i == arr.size()-1) {
				System.out.printf("%d", arr.get(i));
			}
			else {				
			System.out.printf("%d, ", arr.get(i));
			}
		}
		System.out.printf(" 입니다.");
	}
	
}
