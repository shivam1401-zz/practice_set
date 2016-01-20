package InterviewBit;
import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingPositveNumberInArray {

	public static void main(String[] aa) {
		 //int A[] ={ 417, 929, 845, 462, 675, 175, 73, 867, 14};
		 int B[] = {1,2,3,4,5,6};
		
		 ArrayList<Integer> a = new ArrayList<Integer>();
		
		 for (int i = 0; i < B.length; i++) {
			a.add(B[i]);
		 }
		 
		 int result = new FirstMissingPositveNumberInArray().firstMissingPositive2(a);
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
	
	public int firstMissingPositive2(ArrayList<Integer> A) {
		int n = A.size() + 1;
	    int count;
	    int idx = 0;
	    int size = A.size();
	    count = size - 1;
	    
	    for (idx = size - 1; idx >= 0; idx--) {
	        
	        int num = A.get(idx);
	        
	        if (num < 0) {
	            int val = A.get(count);
	            A.set(idx, val);
	            A.set(count, num);
	            count--;
	        }
	        
	    }
	    System.out.println(A);
	    
	    for (idx = 0; idx <= count; idx++) {
	        
	    	int num = A.get(idx);
	        
            num = Math.abs(num);
	        
	        if (num > 0 && num < n) {
	            
	            int index = num - 1;
	            int val = A.get(index);
	            A.set(index, -val);
	            
	        }
	        
	    }
	    System.out.println(A);
	    for (idx = 0; idx <= count; idx++) {
	        
	        int num = A.get(idx);
	        
	        if (num > 0) {
	            return idx + 1;
	        }
	        
	    }
	    
	    return idx + 1;
	    
	}
}
