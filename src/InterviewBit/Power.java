package InterviewBit;

public class Power {
	public static void main(String[] args) {
		System.out.println(new Power().pow(79161127, 99046373, 57263970));
	}

	// Remember => x^n = (x*x)^n/2
	public int pow(int x, int n, int d) {
		long ans = 1L;
		long number = x;
		while (n > 0) {
			if (n % 2 == 1) {
				ans = ans * number;
				ans = ans % d;
			}
			number = (number * number) % d;
			n = n / 2;
			
		}
		return (int) ((ans + d) % d); // this will handle remainder cases for
										// both positive and negative number
	}
}


						  
