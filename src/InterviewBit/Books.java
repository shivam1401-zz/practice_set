package InterviewBit;

import java.util.ArrayList;

/*
 * Probelm: 
 * N number of books are given. 
   The ith book has Pi number of pages. 
   You have to allocate books to M number of students so that maximum number of pages alloted to 
   a student is minimum. A book will be allocated to exactly one student. Each student has to be 
   allocated atleast one book.
   NOTE: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.
 */
public class Books {
	public static void main(String[] args){
		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(12);
		li.add(34);
		li.add(67);
		li.add(90);
		
		int res = new Books().books(li, 3);
		System.out.println(res);
	}

	public int books(ArrayList<Integer> a, int noOfStudents) {
		int totalPages = 0;
	    int noOfBooks = a.size();
		if(noOfBooks < noOfStudents) 
			return -1;
	 
	    for(int i = 0; i < noOfBooks; ++i)  
	    	totalPages += a.get(i);
	     
	 
	     int start = 0;
	     int end = totalPages, minNoOfPageAllocateToEachStudent;
	     int ans = Integer.MAX_VALUE; 
	    
	    while(start <= end) {
	         
	    	minNoOfPageAllocateToEachStudent = (start + end) / 2;
	         
	        if (isPossible(a, noOfBooks, noOfStudents, minNoOfPageAllocateToEachStudent)) {
	         
	            ans = Math.min(ans, minNoOfPageAllocateToEachStudent);
	            end = minNoOfPageAllocateToEachStudent - 1; // if we want to decrease mid range
	        } 
	         
	        else {
	            start = minNoOfPageAllocateToEachStudent + 1; // if we want to increase mid range
	        }
	    }
	    return ans;
	}

	// Here we are checking :
	//Is number of students required to keep max number of pages below mid < M ? => Means
	// with given number of students can we keep max number of pages below or equal to mid? => Means
	// if we allocate "mid" as max number of pages which a student can read, can we achive our goal with given 
	// number of students.
	private boolean isPossible(ArrayList<Integer> a, int n, int m, int mid) {
		int studentsRequired = 1;
	    int curSum = 0;
	    int curMin = mid;
	   
	    for (int i = 0; i < n; i++) {
	   
	        if (a.get(i) > curMin) return false;
	   
	        if (curSum + a.get(i) > curMin) {
	         
	            studentsRequired++;
	            curSum = a.get(i); 
	            if (studentsRequired > m) return false;
	        } 
	        else {
	            curSum += a.get(i);
	        }
	    }
	    return true;
	}
}
