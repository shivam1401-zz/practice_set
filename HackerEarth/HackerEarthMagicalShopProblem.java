package HackerEarth;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HackerEarthMagicalShopProblem {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String str = "";
		long noOfpotionsAtFirstDay = 0;
		long B = 0;
		while ((line = br.readLine()) != null && line.length() != 0) {
			String[] input = line.split("\\s+");
			if (input.length == 2) {
				noOfpotionsAtFirstDay = Integer.parseInt(line.split("\\s+")[0]);
				B = Integer.parseInt(line.split("\\s+")[1]);
			} else if (input.length == 1) {
				str = line;
			}
		}
		long potionUsedSoFar = 0;
		long totalNoOfPotions = noOfpotionsAtFirstDay;
		for (int i = 0; i < str.length(); i++) {
			if (i > 0) {
				totalNoOfPotions = (totalNoOfPotions * totalNoOfPotions) % B;
			}
			if (str.charAt(i) == '1') {
				potionUsedSoFar = (potionUsedSoFar + totalNoOfPotions) % B;
			}

		}
		System.out.println(potionUsedSoFar);
	}
}
