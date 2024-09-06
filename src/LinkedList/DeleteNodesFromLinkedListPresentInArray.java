//Question:3217
//You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3], head = [1,2,3,4,5]
//
//Output: [4,5]
//
//Explanation:
//
//
//
//Remove the nodes with values 1, 2, and 3.
//
//Example 2:
//
//Input: nums = [1], head = [1,2,1,2,1,2]
//
//Output: [2,2,2]
//
//Explanation:
//
//
//
//Remove the nodes with value 1.
//
//Example 3:
//
//Input: nums = [5], head = [1,2,3,4]
//
//Output: [1,2,3,4]
//
//Explanation:
//
//
//
//No node has value 5.

package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	  public ListNode modifiedList(int[] nums, ListNode head) {
		  ListNode dummy = new ListNode(0, head);
		  Set<Integer> set = new HashSet<>();
		  
		  for (ListNode cur = dummy; cur.next != null ; ) {
			  if (set.contains(cur.next.val)) {
				  cur.next = cur.next.next;
			  }
			  else {
				  cur = cur.next;
			  }
		  }
		  return dummy.next;
	  }
}
