//Question:49
//Given an array of strings strs, group the 
//anagrams
// together. You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//Explanation:
//
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
//Example 2:
//
//Input: strs = [""]
//
//Output: [[""]]
//
//Example 3:
//
//Input: strs = ["a"]
//
//Output: [["a"]]

package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String tempStr = String.valueOf(c);
			
			if (!map.containsKey(tempStr)) {
				map.put(tempStr, new ArrayList<>());
			}
			map.get(tempStr).add(str);
		}
		
		return new ArrayList<>(map.values());
	}
}
