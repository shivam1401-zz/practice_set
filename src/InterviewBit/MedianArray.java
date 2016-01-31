package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MedianArray {
	public static void main(String[] args){
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(8);
		a.add(9);
		
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(3);
		b.add(4);
		b.add(6);
		b.add(8);
		b.add(9);
		
		//1 2 3 4 8 8 9 9
		double res = new MedianArray().findMedianSortedArrays1(a, b);
		System.out.println(res);
	}
	
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		List<Integer> fin = new ArrayList<Integer>();
		for(int i = 0; i<a.size();i++){
			fin.add(a.get(i));
		}
		for(int i = 0; i<b.size();i++){
			fin.add(b.get(i));
		}
		Collections.sort(fin);
		int n = fin.size();
		int k = n/2;
		int l = (n/2) + 1;
		double r = 0.0;
		if(n%2 == 0){
			r = (fin.get(k-1) + fin.get(l-1))/2.0;
		}else{
			r = (fin.get(k));
		}
		return r;
	}
	
	public double test(final List<Integer> a, final List<Integer> b){
		Stack<Integer> t = new Stack<Integer>();
		int i = 0;
		int j = 0;
		while(i < a.size() && j<b.size()){
			  if(a.get(i)<b.get(j))
			  {
			    t.push(a.get(i));
			    i++;
			  }else if(a.get(i)>b.get(j)){
			    t.push(b.get(j));
			    j++;
			  }else{
				t.push(a.get(i));
				i++;
				t.push(b.get(j));
				j++;
			 }
			  
		}
		int n = t.size();
		List<Integer> fin = new ArrayList<Integer>();
		for(int k = 0 ; k<t.size(); k--){
			fin.add(t.get(k));
		}
		return 0.0;

	}
	
	public double findMedianSortedArrays1(final List<Integer> A, final List<Integer> B) {
		
		   int len = A.size() + B.size();
		    if(len % 2 == 1) return findKth(A, 0, B, 0, len / 2 + 1);
		    else return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
		}
		
		public int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
		    if(A_start >= A.size()) return B.get(B_start + k - 1);
		    if(B_start >= B.size()) return A.get(A_start + k - 1);
		    if(k == 1) return Math.min(A.get(A_start), B.get(B_start));
		    
		    int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
		    int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;
		    
		    if(A_key < B_key){
		        return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		    }
		    else
		       return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
}
