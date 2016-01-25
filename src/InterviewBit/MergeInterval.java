package InterviewBit;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeInterval {
	
	public static void main(String[] aa){
		ArrayList<Interval> givenInterval = new ArrayList<Interval>();
		
		Interval i1 = new Interval(1,2);
		Interval i2 = new Interval(3,5);
		Interval i3 = new Interval(6,7);
		Interval i4 = new Interval(8,10);
		Interval i5 = new Interval(12,16);
		
		givenInterval.add(i1);
		givenInterval.add(i2);
		givenInterval.add(i3);
		givenInterval.add(i4);
		givenInterval.add(i5);
		
		Interval newInterval = new Interval(4,9);
		new MergeInterval().mergeInterval(givenInterval, newInterval);
	}

	private  ArrayList<Interval> mergeInterval(
			ArrayList<Interval> givenInterval, Interval newInterval) {
		boolean doesItOverlap = false;
		ArrayList<Interval> resultedInterval = new ArrayList<Interval>();
		for(Interval c : givenInterval){
			doesItOverlap = !(Math.max(c.start,newInterval.start) > Math.min(c.end, newInterval.end));
			if(doesItOverlap){
				newInterval.start = Math.min(c.start, newInterval.start);
				newInterval.end = Math.max(c.end, newInterval.end);
			}else{
				resultedInterval.add(c);
			}
		}
		resultedInterval.add(newInterval);
		resultedInterval.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		return resultedInterval;
	}
}

class Interval {
	int start;
	int end;
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}
