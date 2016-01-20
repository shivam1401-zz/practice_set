package HackerEarth;
import java.util.Scanner;

public class ChanduInternProblem {
	public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0 ; i< N ; i++){
        	int X = sc.nextInt();
        	int totalFactor = 2;
        	for(int j = 2 ; j < X; j++ ){
        		if(X%j == 0){
        			totalFactor++;
        		}
        		if(totalFactor >= 4){
        			System.out.println("YES");
        			break;
        		}
        	}
        	if(totalFactor < 4){
    			System.out.println("NO");
    		}
        }
    }
}
