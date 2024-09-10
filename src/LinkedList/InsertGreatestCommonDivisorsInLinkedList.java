package LinkedList;

public class InsertGreatestCommonDivisorsInLinkedList {
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	  public ListNode insertGreatestCommonDivisors(ListNode head) {
		  ListNode dummy = new ListNode(0, head);
		  ListNode pre = head;
		  ListNode cur = head.next;
		  
		  while (cur != null) {
			  if (pre != null && cur != null) {
				  ListNode node = new ListNode(findGCD(pre.val, cur.val));
				  pre.next = node;
				  node.next = cur;
			  }
			  pre = cur;
			  cur = cur.next;
		  }
		  return dummy.next;
	  }
	  private int findGCD(int a, int b) {
		  if (b == 0) return a;
		  return findGCD(b, a % b);
	  }
}
