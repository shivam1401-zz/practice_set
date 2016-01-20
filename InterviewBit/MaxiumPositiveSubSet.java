package InterviewBit;
import java.util.ArrayList;


public class MaxiumPositiveSubSet {

	public static void main(String[] aa){
		int A[] = {0, 0, -1, 0};
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 0 ; i<A.length; i++){
			a.add(A[i]);
		}
		ArrayList<Integer> result = new MaxiumPositiveSubSet().maxSet(a);
		System.out.println(result);
	}
	
	public ArrayList<Integer> maxSet(ArrayList<Integer> a){
		
		long sum = 0;
		long max_sum = 0;
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		
		for(Integer i : a){
			if(i >= 0){
				sum += i;
				newArray.add(i);
			}else{
				sum = 0;
				newArray = new ArrayList<Integer>();
			}
			if((max_sum < sum) || (max_sum == sum) && (maxArray.size() < newArray.size())){
				max_sum = sum;
				maxArray = newArray;
			}
		}
		return maxArray;
		
	}

}

