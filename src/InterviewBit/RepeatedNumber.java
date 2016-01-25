package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedNumber {

	public static void main(String[] aa){
		List<Integer> inputList = new ArrayList<Integer>();
		int[] a = {3, 4, 1, 4, 1};
		for(int i = 0; i<a.length ;i++){
			inputList.add(a[i]);
		}
		int repeatedNum = new RepeatedNumber().repeatedNumber(inputList);
		System.out.println(repeatedNum);
	}

	private Integer repeatedNumber(List<Integer> inputList) {
		HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();
		for(int i = 0; i<inputList.size(); i++){
			int key = inputList.get(i);
			if(temp.containsKey(key)){
				temp.put(key, temp.get(key)+1);
			}else{
				temp.put(key, 1);
			}
			
			if(temp.get(key)>1){
				return key;
			}
		}
		return 0;
		
	}	
}
