package InterviewBit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LargestNumberFormedFromNumbersInArray {
	public static void main(String[] aa){
		List<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(34);
		a.add(5);
		a.add(9);
		
		
		List<String> b = new ArrayList<String>();
		StringBuffer result = new StringBuffer();
		for(Integer c : a){
			b.add(String.valueOf(c));
		}
		Collections.sort(b,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String first = o1+o2;
				String second = o2+o1;
				return second.compareTo(first);
			}
		});
		for(int i = 0; i<b.size(); i++){
			if(b.get(i).equals("0") && result.length() != 0){
				continue;
			}
			result.append(b.get(i));
			
		}
		System.out.println(result.toString());
//		String testing = "a word is not a    word but   sachin";
//		testing.split("\\s+");
	}
	
}

