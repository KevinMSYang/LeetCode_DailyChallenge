//Question:1636
//Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
//
//Return the sorted array.
//
// 
//
//Example 1:
//
//Input: nums = [1,1,2,2,2,3]
//Output: [3,1,1,2,2,2]
//Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
//Example 2:
//
//Input: nums = [2,3,1,3,2]
//Output: [1,3,3,2,2]
//Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
//Example 3:
//
//Input: nums = [-1,1,-6,4,5,-6,1,4,1]
//Output: [5,-1,4,4,-6,-6,1,1,1]

package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	Integer[] ints = new Integer[nums.length];
    	
    	for (int i = 0; i < nums.length; i++) {
    		ints[i] = nums[i];
    		map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    	}
    	
    	Arrays.sort(ints, (a, b) -> {
    		int freqA = map.get(a);
    		int freqB = map.get(b);
    		if (freqA == freqB) {
    			return b - a;
    		}
    		else {
    			return freqA - freqB;
    		}
    	});
    	
    	int[] ans = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		ans[i] = ints[i];
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
    	SortArrayByIncreasingFrequency sa = new SortArrayByIncreasingFrequency();
    	int[] arr = {1,1,2,2,2,3};
    	sa.frequencySort(arr);
    }
}
