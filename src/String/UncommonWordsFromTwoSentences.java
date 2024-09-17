//Question:884
//A sentence is a string of single-space separated words where each word consists only of lowercase letters.
//
//A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//
//Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
//
// 
//
//Example 1:
//
//Input: s1 = "this apple is sweet", s2 = "this apple is sour"
//
//Output: ["sweet","sour"]
//
//Explanation:
//
//The word "sweet" appears only in s1, while the word "sour" appears only in s2.
//
//Example 2:
//
//Input: s1 = "apple apple", s2 = "banana"
//
//Output: ["banana"]

package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String str : s1.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : s2.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
