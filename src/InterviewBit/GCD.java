package InterviewBit;

public class GCD {

	public static void main(String[] aa){
		int result = new GCD().gcd(6, 9);
		System.out.println(result);
	}
	
	public int gcd(int a, int b) {
		if(a<b){
			int temp = a;
			a = b;
			b = temp;
		}
		if(a == 0){
			return b; 
		}else if(b == 0){
			return a;
		}else{
		
			return gcd(b,a%b);
		}
	}
}
