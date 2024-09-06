//Question:912
//Given an array of integers nums, sort the array in ascending order and return it.
//
//You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
//
// 
//
//Example 1:
//
//Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
//Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
//Example 2:
//
//Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
//Explanation: Note that the values of nums are not necessairly unique.

package Array;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        
    }
    private void merge (int[] arr, int l, int m, int r) {
    	int arrSize1 = m - l + 1;
    	int arrSize2 = r - m;
    	
    	int[] L = new int[arrSize1];
    	int[] R = new int[arrSize2];
    	
    	for (int i = 0; i < arrSize1; i++) {
    		L[i] = arr[l+i];
    	}
    	for (int i = 0; i < arrSize2; i++) {
    		R[i] = arr[m+1+i];
    	}
    	
    	int i = 0;
    	int j = 0;
    	int k = l;
    	while (i < arrSize1 && j < arrSize2) {
    		if (L[i] <= R[j]) {
    			arr[k] = L[i];
    			i++;
    		}
    		else {
    			arr[k] = R[j];
    			j++;
    		}
    		k++;
    	}
    	
    	while (i < arrSize1) {
    		arr[k] = L[i];
    		i++;
    		k++;
    	}
    	while (j < arrSize2) {
    		arr[k] = R[j];
    		j++;
    		k++;
    	}
    }
    
    private void sort (int[] arr, int l, int r) {
    	if (l < r) {
    		System.out.println("in sort: l=" +l+" r="+r);
    		int m = l + (r -l) / 2;
    		System.out.println("int sort: m="+m);
    		sort(arr, l, m);
    		System.out.println("back to sort1");
    		sort(arr, m+1, r);
    		System.out.println("back to sort2");
    		merge(arr, l, m, r);
    		System.out.println("finish merge");
    	}
    }
    
    public static void main(String[] args) {
    	SortAnArray sa = new SortAnArray();
    	int[] arr = {5, 4, 3, 1};
    	sa.sort(arr, 0, arr.length-1);
    }
}
