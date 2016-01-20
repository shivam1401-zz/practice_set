package InterviewBit;
import java.util.ArrayList;
import java.util.List;


public class SpiralTraversal {

	public static void main(String[] aa){
		List<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		
		a1.add(1);a1.add(2);a1.add(3);a1.add(11);
		a2.add(4);a2.add(5);a2.add(6);a2.add(12);
		a3.add(7);a3.add(8);a3.add(9);a3.add(13);
		
		input.add(a1);input.add(a2);input.add(a3);
		System.out.println(input);

		//List<Integer> result  = printSpiralElement(input);
		List<Integer> result = printSpiral(input);
		System.out.println(result);
	}

	private static List<Integer> printSpiral(List<ArrayList<Integer>> input) {
		List<Integer> result = new ArrayList<Integer>();
		int row=0,col=0,layer = 0;
		int rows = input.size();
		int cols = input.get(0).size();
		if(rows==0){
			return result;
		}
		result.add(input.get(0).get(0));
		int dir = 0;
		for(int step = 1; step < rows*cols; step++){
			switch(dir){
			case 0:
				if(col == cols-layer-1){
					row++;
					dir = 1;
				}else{
					col++;
				}
				break;
			case 1:
				if(row == rows-layer-1){
					col--;
					dir = 2;
				}else{
					row++;
				}
				break;
			case 2:
				if(col == layer){
					row--;
					dir = 3;
				}else{
					col--;
				}
				break;
			case 3:
				if(row == layer+1){
					col++ ;
					dir = 0;
					layer++;
				}else{
					row--;
				}
				break;
			}
			System.out.println(row + "-" + col);
			result.add(input.get(row).get(col));
		}
		
		return result;
	}

	private static List<Integer> printSpiralElement(List<ArrayList<Integer>> input) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int startRowIndex = 0;
		int endRowIndex = input.size();
		int startColIndex = 0;
		int endColIndex = input.get(0).size();
		int i = 0;
		while(startRowIndex < endRowIndex && startColIndex < endColIndex){
			for(i=startColIndex;i<endColIndex;i++){
				result.add(input.get(startRowIndex).get(i));
			}
			startRowIndex++;
			for(i=startRowIndex;i<endRowIndex;i++){
				result.add(input.get(i).get(endColIndex-1));
			}
			endColIndex--;
			if(startRowIndex<endRowIndex){
				for(i = endColIndex-1 ; i >= startColIndex; i-- ){
					result.add(input.get(endRowIndex-1).get(i));
				}
				endRowIndex--;
			}
			
			if(startColIndex<endColIndex){
				for(i=endRowIndex-1;i>=startRowIndex;i--){
					result.add(input.get(i).get(startColIndex));
				}
				startColIndex++;
			}
			
		}
		return result;
	}
}
