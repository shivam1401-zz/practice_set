package InterviewBit;

import java.util.ArrayList;

public class SetZero {
	public static void main(String[] aa){
		int[][] input = {  {1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0},
				  {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				  {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
				  {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1},
				  {0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1},
				  {1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0},
				  {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
				  {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
				  {0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
				  {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
				  {0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				  {1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1},
				  {0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1},
				  {1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
				  {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0},
				  {0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0},
				  {1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
				  {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
				  {0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
				  {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0},
				  {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
				  {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
				  {1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1},
				  {1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0},
				  {0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1}};
										
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<input.length ; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j<input[i].length ; j++){
				temp.add(input[i][j]);
			}
			output.add(temp);
		}
		output = new SetZero().setZeroesAcceptabelSolution(output);
		System.out.println(output);
		
	}
	
	public ArrayList<ArrayList<Integer>> setZeroesAcceptabelSolution(ArrayList<ArrayList<Integer>> a) {
		
		for(int i = 0; i< a.size() ; i++){
			boolean isZeroInRow = false;
			for(int j = 0; j< a.get(i).size(); j++){
				if(a.get(i).get(j) == 0){
					isZeroInRow = true;
				}
			}
			if(isZeroInRow){
				for(int k = 0; k < a.get(0).size() ; k++){
					if(a.get(i).get(k) == 1)
						a.get(i).set(k, -1);
				}
			}
		}
		for(int i = 0; i< a.get(0).size() ; i++){
			boolean isZeroInCol = false;
			for(int j = 0; j< a.size(); j++){
				if(a.get(j).get(i) == 0){
					isZeroInCol = true;
				}
			}
			if(isZeroInCol){
				for(int k = 0; k < a.size() ; k++){
					if(a.get(k).get(i) == 1)
						a.get(k).set(i, -1);
				}
			}
		}
		
		
		for(int i = 0; i< a.size() ; i++){
			for(int j = 0; j< a.get(0).size(); j++){
				if(a.get(i).get(j) == -1){
					a.get(i).set(j,0);
				}
			}
		}
		return a;
	}
	
	public ArrayList<ArrayList<Integer>> setZeroesAnotherSolution(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> store = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> rowAndCol = null;
		for(int i = 0; i< a.size() ; i++){
			for(int j = 0; j< a.get(i).size(); j++){
				if(a.get(i).get(j) == 0){
					rowAndCol = new ArrayList<Integer>();
					rowAndCol.add(i);
					rowAndCol.add(j);
				}
				if(rowAndCol != null){
					store.add(rowAndCol);
				}
			}
		}
		
		return finalOper(a,store);
	}
	
	
	private ArrayList<ArrayList<Integer>> finalOper(ArrayList<ArrayList<Integer>> a,
			ArrayList<ArrayList<Integer>> store) {
		for(int i = 0; i<store.size() ; i++){
			int row = store.get(i).get(0);
			int col = store.get(i).get(1);
			for(int k = 0 ; k < a.size(); k++){
				a.get(k).set(col, 0);		
			}
			for(int k = 0 ; k < a.get(0).size(); k++){
				a.get(row).set(k, 0);		
			}
		}
		return a;
	}
	
}
