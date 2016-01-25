package InterviewBit;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeInterval {
	
	public static void main(String[] aa){
		ArrayList<Interval> givenInterval = new ArrayList<Interval>();
		Interval[] a = {new Interval(47, 76), new Interval(51, 99), new Interval(28, 78), new Interval(54, 94), new Interval(12, 72), new Interval(31, 72), new Interval(12, 55), new Interval(24, 40), new Interval(59, 79), new Interval(41, 100), new Interval(46, 99), new Interval(5, 27), new Interval(13, 23), new Interval(9, 69), new Interval(39, 75), new Interval(51, 53), new Interval(81, 98), new Interval(14, 14), new Interval(27, 89), new Interval(73, 78), new Interval(28, 35), new Interval(19, 30), new Interval(39, 87), new Interval(60, 94), new Interval(71, 90), new Interval(9, 44), new Interval(56, 79), new Interval(58, 70), new Interval(25, 76), new Interval(18, 46), new Interval(14, 96), new Interval(43, 95), new Interval(70, 77), new Interval(13, 59), new Interval(52, 91), new Interval(47, 56), new Interval(63, 67), new Interval(28, 39), new Interval(51, 92), new Interval(30, 66), new Interval(4, 4), new Interval(29, 92), new Interval(58, 90), new Interval(6, 20), new Interval(31, 93), new Interval(52, 75), new Interval(41, 41), new Interval(64, 89), new Interval(64, 66), new Interval(24, 90), new Interval(25, 46), new Interval(39, 49), new Interval(15, 99), new Interval(50, 99), new Interval(9, 34), new Interval(58, 96), new Interval(85, 86), new Interval(13, 68), new Interval(45, 57), new Interval(55, 56), new Interval(60, 74), new Interval(89, 98), new Interval(23, 79), new Interval(16, 59), new Interval(56, 57), new Interval(54, 85), new Interval(16, 29), new Interval(72, 86), new Interval(10, 45), new Interval(6, 25), new Interval(19, 55), new Interval(21, 21), new Interval(17, 83), new Interval(49, 86), new Interval(67, 84), new Interval(8, 48), new Interval(63, 85), new Interval(5, 31), new Interval(43, 48), new Interval(57, 62), new Interval(22, 68), new Interval(48, 92), new Interval(36, 77), new Interval(27, 63), new Interval(39, 83), new Interval(38, 54), new Interval(31, 69), new Interval(36, 65), new Interval(52, 68)};
		//Interval[] a = {new Interval(54, 75), new Interval(56, 60), new Interval(61, 86), new Interval(22, 43), new Interval(56, 87), new Interval(32, 53), new Interval(14, 81), new Interval(64, 65), new Interval(9, 42), new Interval(12, 33), new Interval(22, 58), new Interval(84, 90), new Interval(27, 59), new Interval(41, 48), new Interval(43, 47), new Interval(22, 29), new Interval(16, 23), new Interval(41, 72), new Interval(15, 87), new Interval(20, 59), new Interval(45, 84), new Interval(14, 77), new Interval(72, 93), new Interval(20, 58), new Interval(47, 53), new Interval(25, 88), new Interval(5, 89), new Interval(34, 97), new Interval(14, 47)};
		//Interval[] a = {new Interval(92, 98), new Interval(10, 86), new Interval(61, 91), new Interval(8, 71), new Interval(53, 65), new Interval(19, 79), new Interval(20, 50)};
		for(int i = 0; i< a.length ; i++){
			givenInterval.add(a[i]);
		}
		Interval newInterval = new Interval(4,9);
		new MergeInterval().mergeInterval(givenInterval, newInterval);
		new MergeInterval().mergeAllOverlappingInterval(givenInterval);
	}

	private void mergeAllOverlappingInterval(ArrayList<Interval> givenInterval) {
		givenInterval.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		ArrayList<Interval> resultedInterval = new ArrayList<Interval>();
		Interval first = givenInterval.get(0);
		for(int j = 1; j<givenInterval.size();j++){
				boolean doesItOverlap = !(Math.max(first.start,givenInterval.get(j).start) > Math.min(first.end,givenInterval.get(j).end));
				if(doesItOverlap){
					first.start = Math.min(first.start, givenInterval.get(j).start);
					first.end = Math.max(first.end, givenInterval.get(j).end);
				}else{
					resultedInterval.add(first);
					first = givenInterval.get(j);
				}
		}
		resultedInterval.add(first);
			
		for(int i = 0; i< resultedInterval.size(); i++){
			System.out.println(resultedInterval.get(i).start + "    "+ resultedInterval.get(i).end);
		}
	}

	private  ArrayList<Interval> mergeInterval(
			ArrayList<Interval> givenInterval, Interval newInterval) {
		
		ArrayList<Interval> resultedInterval = new ArrayList<Interval>();
		for(Interval c : givenInterval){
			boolean doesItOverlap = !(Math.max(c.start,newInterval.start) > Math.min(c.end, newInterval.end));
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
