package InterviewBit;

import java.util.ArrayList;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("aaaaaaaaaaaaaaaaaaaaaaa");
		a.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		a.add("aaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(a));

	}

	public String longestCommonPrefix(ArrayList<String> a) {
		String res = "";
		if(a.size() == 0){
			return "";
		}
		int min = Integer.MAX_VALUE;
		for(int k = 0; k< a.size();k++){
			min = Math.min(min,a.get(k).length());
		}
		for(int i = 0; i<min;i++){
			char c = a.get(0).charAt(i);
			for(int j = 1; j<a.size();j++){
				if(c != a.get(j).charAt(i)){
					return res;
				}
			}
			res = res+c;
		}
		return res;
	}
}
