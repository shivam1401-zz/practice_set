package InterviewBit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public static void main(String[] aa) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 6);
		// Interval i3 = new Interval(6,9);
		// Interval i4 = new Interval(8,10);
		// Interval i5 = new Interval(12,16);

		Interval newInterval = new Interval(10, 8);
		intervals.add(i1);
		intervals.add(i2);
		// intervals.add(i3);
		// intervals.add(i4);
		// intervals.add(i5);

		for (int i = 0; i < intervals.size(); i++) {
			System.out.println(intervals.get(i).start + "- "
					+ intervals.get(i).end);
		}
		System.out.println("-----------------------------");
		ArrayList<Interval> results = insert(intervals, newInterval);
		for (int i = 0; i < results.size(); i++) {
			System.out
					.println(results.get(i).start + "- " + results.get(i).end);
		}

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();

		newInterval = sort(newInterval);
		int endIndex = 0;
		int startIndex = 0;
		boolean first = true;
		for (int i = 0; i < intervals.size(); i++) {
			if (!(Math.max(intervals.get(i).start, newInterval.start) > Math
					.min(intervals.get(i).end, newInterval.end))) {
				if (first) {
					startIndex = i;
					first = false;
				}
				endIndex = i;
			}
		}
		if (first) {
			result = intervals;
			result.add(newInterval);
			result.sort(byStart());
			return result;
		} else {
			for (int j = 0; j < startIndex; j++) {
				result.add(intervals.get(j));
			}
			result.add(new Interval(Math.min(intervals.get(startIndex).start,
					newInterval.start), Math.max(intervals.get(endIndex).end,
					newInterval.end)));
			for (int j = endIndex + 1; j < intervals.size(); j++) {
				result.add(intervals.get(j));
			}
			return result;
		}
		// result.add(new Interval(Math.min(intervals.get(startIndex).start,
		// newInterval.start), Math.max(intervals.get(endIndex).end,
		// newInterval.end)));

	}

	public static Interval sort(Interval newInterval) {
		if (newInterval.start > newInterval.end) {
			int temp = newInterval.start;
			newInterval.start = newInterval.end;
			newInterval.end = temp;
		}
		return newInterval;
	}
	
	private static Comparator<Interval> byStart()
	{
	    return new Comparator<Interval>()
	    {
	        @Override
	        public int compare(Interval o1, Interval o2)
	        {
	            return o1.start - o2.start;
	        }
	    };        
	}
	
	public int maxSubArray(final List<Integer> a) {
	    int max_at_point = 0;
	    int max = 0;
	    int count= 0;
	    for(int i = 0; i< a.size() ; i++){
	    	if(a.get(i) <  0){
	    		count++;
	    	}
	    	max_at_point = max_at_point  + a.get(i);
	    	if(max_at_point < 0 ){
	    		max_at_point = 0;
	    	}
	    	if(max < max_at_point){
	    		max = max_at_point;
	    	}
	    }
	    if(count == a.size()){
	    	int smallest_neg = a.get(0);
	    	for(int i = 1 ; i < a.size(); i++){
	    		smallest_neg = Math.max(smallest_neg, a.get(i));
	    	}
	    	return smallest_neg;
	    }else{
	    	return max;	
	    }
		
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}