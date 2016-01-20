package InterviewBit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class StringToNumber {

	public static void main(String[] aa){
		String test = "One million two hundred thousand fifty seven";
		Map<String,Integer> unitMap = new HashMap<String, Integer>();
		unitMap.put("One", 1);
		unitMap.put("Two", 2);
		unitMap.put("Three", 3);
		unitMap.put("Four", 4);
		unitMap.put("Five", 5);
		unitMap.put("Six", 6);
		unitMap.put("Seven", 7);
		unitMap.put("Eight", 8);
		unitMap.put("Nine", 9);
		
		Map<String,Integer> EleventthMap = new HashMap<String, Integer>();
		EleventthMap.put("Eleven", 11);
		EleventthMap.put("Twelve", 12);
		EleventthMap.put("Thirteen", 13);
		EleventthMap.put("Fourteen", 14);
		EleventthMap.put("Fifteen", 15);
		EleventthMap.put("Sixteen", 16);
		EleventthMap.put("Seventeen", 17);
		EleventthMap.put("Eighteen", 18);
		EleventthMap.put("Nineteen", 19);
		
		Map<String,Integer> twentiesMap = new HashMap<String, Integer>();
		twentiesMap.put("Ten", 10);
		twentiesMap.put("Ten", 20);
		twentiesMap.put("Thirty", 30);
		twentiesMap.put("Fourty", 40);
		twentiesMap.put("Fifty", 50);
		twentiesMap.put("Sixty", 60);
		twentiesMap.put("Seventy", 70);
		twentiesMap.put("Eighty", 80);
		twentiesMap.put("Ninety", 90);
		
		Map<String,Integer> HundreadsMap = new HashMap<String, Integer>();
		HundreadsMap.put("Hundread", 100);
		HundreadsMap.put("Thousands", 1000);
		
//		ArrayList<Integer> temp = new ArrayList<Integer>();
//		for(String a : test.split(" ")){
//			temp.add(Integer.parseInt(a));
//		}
		//System.out.println(temp);
		//Map<String,Integer> twentiesMap = new HashMap<String, Integer>();
		
		// From: (123, 78) To: (56, 124) 
		// From: (11, 45) To: (115, 98)
		// ( 11
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(6);
		a1.add(17);
		a1.add(13);
		a1.add(15);
		a1.add(4);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(1);
		a2.add(-5);
		//a2.add(7);
		//a2.add(8);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(9);
		a3.add(10);
		a3.add(11);
		a3.add(12);
		A.add(a1);
		A.add(a2);
		A.add(a3);
	//int t = coverPoints(a1,a2);
	ArrayList<Integer> t = wave(a1);

	System.out.println(t);
//	 ArrayList<ArrayList<Integer>> B = performOps(A);
//		for (int i = 0; i < B.size(); i++) {
//		    for (int j = 0; j < B.get(i).size(); j++) {
//		            System.out.print(B.get(i).get(j) + " ");
//		    }
//		}

	}
	static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
        
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
	}
	public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int i = 1;
        int total_steps = 0;
        while(i < X.size()){
            int x_steps = Math.abs(X.get(i) - X.get(i-1));
            int y_steps = Math.abs(Y.get(i) - Y.get(i-1));
            i++;
            total_steps = Math.max(x_steps, y_steps);
        }
        return total_steps;
	}
	
	public static ArrayList<Integer> wave(ArrayList<Integer> a) {
	    
        Collections.sort(a);
        for(int i = 2; i<= a.size(); i=i+2){
    	   swap(a,i-2,i-1);
       }
       return a;
	}
	private static void swap(ArrayList<Integer> a, int i, int j) {
		int temp = a.get(i);
		a.set(i,a.get(j));
		a.set(j,temp);
	}
	
}
