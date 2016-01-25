package InterviewBit;
import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingPositveNumberInArray {

	public static void main(String[] aa) {
		 int B[] = {2,3,6,1,4,5};
		 ArrayList<Integer> a = new ArrayList<Integer>();
		
		 for (int i = 0; i < B.length; i++) {
			a.add(B[i]);
		 }
		 
		 int result = new FirstMissingPositveNumberInArray().firstMissingPositive_AcceptableSolution(a);
		 System.out.println(result);
	}

	public int firstMissingPositive(ArrayList<Integer> a) {
		
		Collections.sort(a);
		boolean isAllNeg = true;
		int startIndex = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) < 0) {
				continue;
			}else {
				isAllNeg = false;
				startIndex = i;
				break;
			}
		}
		if (isAllNeg) {
			return 1;
		}
		for(int i = startIndex+1 ; i <= a.size()-1; i++){
			if(a.get(i) - a.get(i-1) != 1){
				return a.get(i-1) + 1;
			}else{
				continue;
			}
		}
		return a.get(a.size()-1) + 1;
	}
	
	public int firstMissingPositive_AcceptableSolution(ArrayList<Integer> A) {
		int count = A.size()-1;
		int n = A.size() + 1;
		int index = 0;
		
		//setting all negative numbers at end in array.
		for(int i = A.size()-1; i>=0 ; i--){
			int num = A.get(i);
			if(num < 0){
				int tmp = A.get(count);
				A.set(i, tmp);
				A.set(count,num);
				count--;
			}
		}
		//Iterating through only positive number 
		//and if numbers are in range then at every value'th index making that number negative.
		for(index=0; index<=count; index++){
			int num = A.get(index);
			num = Math.abs(num);
			if(num>0 && num<n){
				int temp = num - 1;
				int value = A.get(temp);
				A.set(temp, -value);
			}
		}
		
		for(index=0;index<=count;index++){
			int temp = A.get(index);
			if(temp>0){
				return index+1;
			}
		}
		return index+1;
	}
}
