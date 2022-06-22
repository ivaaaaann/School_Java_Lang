package kr.hs.dgsw.java.dept1.d0622;

public class BinarySearch implements Searcher {

	@Override
	public int search(int[] sortedValues, int value) {
		
		int mid;
		int high = sortedValues.length;
		int low = 0;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(value == sortedValues[mid]) {
				return mid;
			}else if(value < sortedValues[mid]) {
				high = mid -1;
			}else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
}
