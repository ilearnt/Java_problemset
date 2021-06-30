public class LinkedList {
	ListNode head;
	public LinkedList(ListNode head) {
		this.head = head;
	}
	public LinkedList(int[] nums) {
		// TODO Auto-generated constructor stub
		if(nums.length >= 1) {
			head = new ListNode(nums[0]);
		}
		ListNode dummy = head;
		for(int i = 1; i < nums.length; i++) {
			ListNode cur = new ListNode(nums[i]);
			dummy.next = cur;
			dummy = dummy.next;
		}
	}
	
	public ListNode reverseListIte(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
	
	public ListNode reverseListRec(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
  
        // send back new head node in every recursion
        return newHead;
    }
	
	public void DeleteNode(ListNode node) {
		if(node.next == null) 
			node = null;
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public ListNode getNthNode(ListNode head, int n) {
		ListNode dummy = head;
		for(int i = 1; i <= n - 1; i++) {
			dummy = dummy.next;
		}
		return dummy;
	}
	
	public ListNode getNthNodeFromEnd(ListNode head, int n) {
		ListNode dummy = head;
		int len = 0;
		while(dummy != null) {
			len ++;
			dummy = dummy.next;
		}
		dummy = head;
		for(int i = 0; i < len - n; i++) {
			dummy = dummy.next;
		}
		return dummy;
	}
	
	public boolean hasCircle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != slow) {
			if(fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
	
	public void PrintList(ListNode head) {
		ListNode dummy = head;
		while(dummy != null) {
			System.out.print(dummy.val + " ");
			dummy = dummy.next;
		}
	}

}
