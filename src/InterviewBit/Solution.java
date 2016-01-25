package InterviewBit;

import java.util.List;

public class Solution {

	public static void main(String[] aa) {
		
	}
	
	public int maxSubArray(final List<Integer> a) {
	    int max_at_point = 0;
	    int max = 0;
	    int count= 0;
	    for(int i = 0; i< a.size() ; i++){
	    	if(a.get(i) <  0){
	    		count++;
	    	}
	    	max_at_point = max_at_point  + a.get(i);
	    	if(max_at_point < 0 ){
	    		max_at_point = 0;
	    	}
	    	if(max < max_at_point){
	    		max = max_at_point;
	    	}
	    }
	    if(count == a.size()){
	    	int smallest_neg = a.get(0);
	    	for(int i = 1 ; i < a.size(); i++){
	    		smallest_neg = Math.max(smallest_neg, a.get(i));
	    	}
	    	return smallest_neg;
	    }else{
	    	return max;	
	    }
		
	}
}

