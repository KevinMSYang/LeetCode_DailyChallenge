//Question:2191
//You are given a 0-indexed integer array mapping which represents the mapping rule of a shuffled decimal system. mapping[i] = j means digit i should be mapped to digit j in this system.
//
//The mapped value of an integer is the new integer obtained by replacing each occurrence of digit i in the integer with mapping[i] for all 0 <= i <= 9.
//
//You are also given another integer array nums. Return the array nums sorted in non-decreasing order based on the mapped values of its elements.
//
//Notes:
//
//Elements with the same mapped values should appear in the same relative order as in the input.
//The elements of nums should only be sorted based on their mapped values and not be replaced by them.
// 
//
//Example 1:
//
//Input: mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
//Output: [338,38,991]
//Explanation: 
//Map the number 991 as follows:
//1. mapping[9] = 6, so all occurrences of the digit 9 will become 6.
//2. mapping[1] = 9, so all occurrences of the digit 1 will become 9.
//Therefore, the mapped value of 991 is 669.
//338 maps to 007, or 7 after removing the leading zeros.
//38 maps to 07, which is also 7 after removing leading zeros.
//Since 338 and 38 share the same mapped value, they should remain in the same relative order, so 338 comes before 38.
//Thus, the sorted array is [338,38,991].
//Example 2:
//
//Input: mapping = [0,1,2,3,4,5,6,7,8,9], nums = [789,456,123]
//Output: [123,456,789]
//Explanation: 789 maps to 789, 456 maps to 456, and 123 maps to 123. Thus, the sorted array is [123,456,789].

package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
        	StringBuilder sb = new StringBuilder();
        	String str = String.valueOf(nums[i]);
        	char[] charArr = str.toCharArray();
        	for (char c : charArr) {  		
        		int Index = Integer.parseInt(String.valueOf(c));
        		sb.append(mapping[Index]);
        	}
        	map.put(nums[i], Integer.parseInt(sb.toString()));
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        entryList.sort(Map.Entry.comparingByValue());

        for (int i = 0; i < nums.length; i++) {
            nums[i] = entryList.get(i).getKey();
        }
        return nums;
    }
    
//    public int[] sortJumbled(int[] mapping, int[] nums) {
//        List<Integer> ans = new ArrayList<>();
//        TreeMap<Integer, List<Integer>> mappedToOriginalNums = new TreeMap<>();
//
//        for (final int num : nums) {
//          final int mapped = getMapped(num, mapping);
//          mappedToOriginalNums.putIfAbsent(mapped, new ArrayList<>());
//          mappedToOriginalNums.get(mapped).add(num);
//        }
//
//        for (List<Integer> originalNums : mappedToOriginalNums.values())
//          ans.addAll(originalNums);
//
//        return ans.stream().mapToInt(Integer::intValue).toArray();
//      }
//
//      private int getMapped(int num, int[] mapping) {
//        StringBuilder sb = new StringBuilder();
//        for (final char c : String.valueOf(num).toCharArray())
//          sb.append(mapping[c - '0']);
//        return Integer.parseInt(sb.toString());
//      }
    
    public static void main(String[] args) {
    	SortTheJumbledNumbers st = new SortTheJumbledNumbers();
    	int[] mapp = {8,9,4,0,2,1,3,5,7,6};
    	int[] nums = {991,338,38};
    	st.sortJumbled(mapp, nums);
    	
    }
}
