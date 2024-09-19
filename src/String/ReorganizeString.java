//Question:767
//Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
//
//Return any possible rearrangement of s or return "" if not possible.
//
// 
//
//Example 1:
//
//Input: s = "aab"
//Output: "aba"
//Example 2:
//
//Input: s = "aaab"
//Output: ""

package String;

public class ReorganizeString {
	 public String reorganizeString(String s) {
		 int[] charCount = new int[26];
		 for (char c : s.toCharArray()) {
			 charCount[c - 'a']++;
		 }
		 
		 int maxCount = 0;
		 int letter = 0;
		 for (int i = 0; i < charCount.length; i++) {
			 if (charCount[i] > maxCount) {
				 maxCount = charCount[i];
				 letter = i;
			 }
		 }
		 
		 if (maxCount > (s.length() + 1) / 2) return "";
		 
		 char[] ans = new char[s.length()];
		 int index = 0;
		 while (charCount[letter]-- != 0) {
			 ans[index] = (char) (letter + 'a');
			 index += 2;
		 }
		 
		 for (int i = 0; i < charCount.length; i++) {
			 while (charCount[i]-- > 0) {
				 if (index >= s.length()) {
					 index = 1;
				 }
				 ans[index] = (char) (i + 'a');
				 index += 2;
			 }
		 }
		 
		 return String.valueOf(ans);
	 }
}
