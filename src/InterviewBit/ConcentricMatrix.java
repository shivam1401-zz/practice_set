package InterviewBit;

import java.util.ArrayList;

public class ConcentricMatrix {
	public static void main(String[] aa) {
		new ConcentricMatrix().prettyPrint(4);
	}

	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>(a);
		int k = 2 * a - 1;
		int[][] spiral = new int[k][k];
		int n = a, colStart = 0, colEnd = k - 1, rowStart = 0, rowEnd = k - 1;

		// Initializing the matrix
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				spiral[i][j] = 0;
			}
		}

		while (n >= 1) {
			for (int i = colStart; i <= colEnd; i++) {
				spiral[rowStart][i] = n;
			}
			for (int j = rowStart + 1; j <= rowEnd; j++) {
				spiral[j][colEnd] = n;
			}
			for (int i = colEnd - 1; i >= colStart; i--) {
				spiral[rowEnd][i] = n;
			}
			for (int j = rowEnd - 1; j >= rowStart + 1; j--) {
				spiral[j][colStart] = n;
			}
			colStart++;
			colEnd--;
			rowStart++;
			rowEnd--;
			n--;
		}
		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral[0].length; j++) {
				System.out.print(" " + spiral[i][j]);
			}
			System.out.println("");
		}
		
		// Converting the spiral matrix into an arrayList
		for (int i = 0; i < spiral.length; i++) {
			lst.add(new ArrayList<Integer>());
			for (int j = 0; j < spiral[0].length; j++) {
				lst.get(i).add(spiral[i][j]);
			}
		}

		return lst;
	}
}
