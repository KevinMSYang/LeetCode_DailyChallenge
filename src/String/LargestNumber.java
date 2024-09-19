//Question:179
//Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
//
//Since the result may be very large, so you need to return a string instead of an integer.
//
// 
//
//Example 1:
//
//Input: nums = [10,2]
//Output: "210"
//Example 2:
//
//Input: nums = [3,30,34,5,9]
//Output: "9534330"

package String;

import java.util.Arrays;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		String[] strArr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strArr[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
		if (strArr[0].equals("0")) return "0";
		
		String ans = "";
		for (String str : strArr) {
			ans += str;
		}
		return ans;
	}
}
