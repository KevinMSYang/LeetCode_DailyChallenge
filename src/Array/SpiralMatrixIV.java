//Question:2326
//You are given two integers m and n, which represent the dimensions of a matrix.
//
//You are also given the head of a linked list of integers.
//
//Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.
//
//Return the generated matrix.
//
// 
//
//Example 1:
//
//
//Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
//Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
//Explanation: The diagram above shows how the values are printed in the matrix.
//Note that the remaining spaces in the matrix are filled with -1.
//Example 2:
//
//
//Input: m = 1, n = 4, head = [0,1,2]
//Output: [[0,1,2,-1]]
//Explanation: The diagram above shows how the values are printed from left to right in the matrix.
//The last space in the matrix is set to -1.	

package Array;

import java.util.Arrays;

public class SpiralMatrixIV {
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	  public int[][] spiralMatrix(int m, int n, ListNode head) {
		  int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		  int[][] ans = new int[m][n];
		  
		  Arrays.stream(ans).forEach(A -> Arrays.fill(A, -1));
		  
		  int x = 0;
		  int y = 0;
		  int d = 0;
		  
		  for (ListNode cur = head; cur != null; cur = cur.next) {
			  ans[x][y] = cur.val;
			  if (x + dirs[d][0] < 0 || x + dirs[d][0] == m || y + dirs[d][1] < 0 || y + dirs[d][1] == n 
				  || ans[x + dirs[d][0]][y + dirs[d][1]] != -1) {
				  d = (d + 1) % 4;
			  }
			  x += dirs[d][0];
			  y += dirs[d][1];
		  }
		  return ans;
	  }
}
