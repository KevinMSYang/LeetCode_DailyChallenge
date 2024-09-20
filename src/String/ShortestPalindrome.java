//Question:214
//You are given a string s. You can convert s to a 
//palindrome
// by adding characters in front of it.
//
//Return the shortest palindrome you can find by performing this transformation.
//
// 
//
//Example 1:
//
//Input: s = "aacecaaa"
//Output: "aaacecaaa"
//Example 2:
//
//Input: s = "abcd"
//Output: "dcbabcd"

package String;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.length() < 2) return s;
        if (isPalindrome(s)) return s;
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();

        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(t.substring(i))) {
                return t.substring(0, i) + s;
            }
        }
        return t + s;
    }
    private boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.reverse().toString().equals(s)) return true;
        return false;
    }
}
