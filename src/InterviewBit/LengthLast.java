package InterviewBit;

public class LengthLast {
	public static void main(String[] aa){
		System.out.println(new LengthLast().lengthOfLastWord("Hello world  "));
	}
	public int lengthOfLastWord(final String a) {
		String b = !a.isEmpty() ? a.trim() : ""; 
		if(b.length()==0 || b.length()==1){
			return b.length();
		}
		String[] c = b.split(" ");
		return (c[c.length-1]).length();
	}
	
	public int lengthOfLastWord2(final String a) {
		int lastIndex = a.length()-1;
		int endIndex = a.length()-1;
		if(a.length() == 0){
			return 0;
		}
		int i = a.length()-1;
		
		while(i >= 0 && a.charAt(i) == ' '){
			i--;
		}
		endIndex = i;
		for(;i>=0;i--){
			if(a.charAt(i) == ' '){
				break;
			}
		}
		lastIndex = i;
		return endIndex-lastIndex +1;		
	}
	

}
