package InterviewBit;

public class LongestPalindrome {
	public static void main(String[] aa){
		System.out.println(new LongestPalindrome().palindrome("abanatrajajartancbga"));
	}
	
	private String palindrome(String str) {
		if(str.isEmpty()){
			return null;
		}
		if(str.length()==1){
			return str;
		}
		String longest = str.substring(0,1);
		for(int i = 0; i<str.length();i++){
			String tmp  = helper(str,i,i);
			if(tmp.length() > longest.length()){
				longest = tmp;
			}
			tmp = helper(str,i,i+1);
			if(tmp.length() > longest.length()){
				longest = tmp;
			}
		}
		return longest;
	}
	// find elements by keeping i as center and check whether they are equal or not.
	private String helper(String str, int begin, int end) {
		while(begin >=0 && end <=str.length()-1 && (str.charAt(begin) == str.charAt(end))){
			begin--;
			end++;
		}
		System.out.println(str.substring(begin+1,end));
		return str.substring(begin+1,end);
	}

	

}