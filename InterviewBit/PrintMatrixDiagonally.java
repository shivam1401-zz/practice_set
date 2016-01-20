package InterviewBit;
import java.util.ArrayList;

public class PrintMatrixDiagonally {

	public static void main(String[] aa) {
		PrintMatrixDiagonally a = new PrintMatrixDiagonally();
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i< arr.length; i++){
			ArrayList<Integer> digElem = new ArrayList<Integer>();
			for(int j = 0; j<arr[i].length; j++){
				digElem.add(arr[i][j]);
			}
			temp.add(digElem);
			
		}
		System.out.println(temp);
		result = a.diagonal(temp);
		System.out.println(result);

	}

	public ArrayList<ArrayList<Integer>> diagonal(
			ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i<= 2*(a.size()-1);i++){
			for(int j = 0; j<=i; j++){
				if(j<a.size() && i-j<a.size())
					temp.add(a.get(j).get(i-j));
			}
			result.add(temp);
			temp = new ArrayList<Integer>();
		}
		
		return result;
	}
}
