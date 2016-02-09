package InterviewBit;

public class Palindrome {
	public static void main(String[] args){
		System.out.println(new Palindrome().isPalindrome("1a2"));
	}

	public int isPalindrome(String a) {
		String d = a.replaceAll("[^a-zA-Z0-9]", "");
		StringBuilder sb = new StringBuilder(d);
		if(d.equalsIgnoreCase(sb.reverse().toString())){
			return 1;
		}
		return 0;

	}
}
