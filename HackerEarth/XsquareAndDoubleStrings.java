package HackerEarth;

import java.util.Scanner;

public class XsquareAndDoubleStrings {

	public static void main(String[] aa) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			String str = sc.next();
			if (isPossibleToMakeDoubleString(str)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static boolean isPossibleToMakeDoubleString(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private static void isDouble(String str) {
		if (str.length() % 2 == 0) {
			if (str.substring(0, str.length() / 2).equals(
					str.substring(str.length() / 2, str.length()))) {
				System.out.println("Yes");
			}
		}
	}

}
