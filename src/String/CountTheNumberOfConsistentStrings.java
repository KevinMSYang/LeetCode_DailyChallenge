//Question:1684
//You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
//
//Return the number of consistent strings in the array words.
//
// 
//
//Example 1:
//
//Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
//Output: 2
//Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
//Example 2:
//
//Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
//Output: 7
//Explanation: All strings are consistent.
//Example 3:
//
//Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
//Output: 4
//Explanation: Strings "cc", "acd", "ac", and "d" are consistent.

package String;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int notValid = 0;
        for (String s : words) {
            char[] temp = s.toCharArray();
            for (int i = 0; i < temp.length; i++) {
                if (!set.contains(temp[i])) {
                    notValid++;
                    break;
                }
            }
        }
        return words.length - notValid;
    }
}
