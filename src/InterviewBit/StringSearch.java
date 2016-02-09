package InterviewBit;

public class StringSearch {
	public static void main(String[] args) {
		new StringSearch().strStr("aba", "babaaa");

	}

	public int strStr(final String haystack, final String needle) {
		boolean match;

		if (needle.isEmpty() || (haystack.isEmpty() && needle.isEmpty())
				|| needle.length() > haystack.length()) {
			return -1;
		}

		for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
			match = true;
			for (int j = 0; j < needle.length(); ++j) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					match = false;
					break;
				}
			}
			if (match)
				return i;
		}
		return -1;
	}
}
