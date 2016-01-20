package InterviewBit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubSet {

	public static void main(String[] aa) {
		
		List<Map<String,List<String>>> data = new ArrayList<Map<String,List<String>>>();
		
		Map<String, List<String>> m1 = new HashMap<String, List<String>>();
		List<String> a1 = new ArrayList<String>();
		List<String> a2 = new ArrayList<String>();
		a1.add("J1");
		m1.put("Job", a1);
		a2.add("P1");
		m1.put("Page", a2);
		
		Map<String, List<String>> m2 = new HashMap<String, List<String>>();
		List<String> a3 = new ArrayList<String>();
		List<String> a4 = new ArrayList<String>();
		a3.add("J2");
		m2.put("Job", a3);
		a4.add("P2");
		m2.put("Page", a4);
		
		Map<String, List<String>> m3 = new HashMap<String, List<String>>();
		List<String> a5 = new ArrayList<String>();
		a5.add("J3");
		m3.put("Job", a5);
		m3.put("Page", a2);
		
		
		Map<String, List<String>> m4 = new HashMap<String, List<String>>();
		List<String> a6 = new ArrayList<String>();
		List<String> a7 = new ArrayList<String>();
		a6.add("J4");
		m4.put("Job", a6);
		a7.add("P3");
		m4.put("Page", a7);
		
		
		Map<String, List<String>> m5 = new HashMap<String, List<String>>();
		List<String> a8 = new ArrayList<String>();
		List<String> a9 = new ArrayList<String>();
		a8.add("J5");
		a9.add("P2");
		m5.put("Job", a8);
		m5.put("Page", a4);
		
		
		data.add(m1);
		data.add(m2);
		data.add(m3);
		data.add(m4);
		data.add(m5);
		
		System.out.println(phi(8));
		//System.out.println(data);
		//process(data);
		
	}

	private static void process(List<Map<String, List<String>>> data) {
		
		List<Map<List<String>,List<String>>> rdata = new ArrayList<Map<List<String>,List<String>>>();
		Map<List<String>, List<String>> m1 = new HashMap<List<String>, List<String>>();
		
		
		
		for(Map<String, List<String>> m2 : data){
			if(m1.containsKey(m2.get("Page"))){
				m1.get(m2.get("Page")).addAll(m2.get("Job"));
				
			}else{
				m1.put(m2.get("Page"), m2.get("Job"));
				rdata.add(m1);
			}

		}
		System.out.println(m1);
		
	}	
	
	private static int phi(int n) {
	    int res = n;
	    for (int i = 2; i * i <= n; ++i) {
	        if (n % i == 0) {
	            while (n % i == 0) {
	                n /= i;
	            }
	            res -= res / i;
	        }
	    }
	    if (n != 1) {
	        res -= res / n;
	    }
	    return res;
	}

}
