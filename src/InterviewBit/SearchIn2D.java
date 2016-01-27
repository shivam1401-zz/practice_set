package InterviewBit;

import java.util.ArrayList;

public class SearchIn2D {
	public static void main(String[] aa) {
		int[][] input = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < input.length; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < input.length; j++) {
				temp.add(input[i][j]);
			}
			result.add(temp);
		}
		int a = new SearchIn2D().searchMatrix(result, 0);
		System.out.println(a);
	}

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		int rows = a.size();
		int cols = a.get(0).size();
		for (int i = 0; i < rows; ) {
			int low = 0;
			int high = cols - 1;
			if (b > a.get(i).get(cols-1)) {
				i++;
			}else {
				while (low <= high) {
					int mid = (low + high) / 2;
					if (a.get(i).get(mid) > b) {
						high = mid - 1;
					}else if (a.get(i).get(mid) < b) {
						low = mid + 1;
					}
					if (a.get(i).get(mid) == b) {
						return 1;
					}
				}
				return 0;
			}
		}
		return 0;

	}

}
