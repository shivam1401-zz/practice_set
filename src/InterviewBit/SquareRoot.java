package InterviewBit;

public class SquareRoot {

	public static void main(String[] aa){
		int a = new SquareRoot().sqrt(5);
		System.out.println(a);
	}
	public int sqrt(int number) {
		int low = 1;
		int high = number;
		int mid;
		int root=0;;
		while(low<=high){
			mid = (low+high)/2;
			if(mid == number/mid && number%mid == 0){
				return mid;
			}
			if(mid <= number/mid){
				root = mid;
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return root;
	}
}
