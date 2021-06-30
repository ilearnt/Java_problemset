
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList(new int[] {1,2,3,4,5}); //create a linkedList 1 -> 2 -> 3 -> 4 -> 5
		list.PrintList(list.head);
		System.out.print("\n");
		
		ListNode reverseList1 = list.reverseListIte(list.head); // test case 1: reverse list iterately
		list.PrintList(reverseList1);
		System.out.print("\n");
		
		ListNode reverseList2 = list.reverseListRec(reverseList1); // test case 2: reverse list recursively
		list.PrintList(reverseList2);
		System.out.print("\n");
		
		LinkedList list2 = new LinkedList(new int[] {2,2,1,4,5});// test case 3: getNthNode
		ListNode node = list2.getNthNode(list2.head, 2);
		System.out.print(node.val + "\n");
		ListNode node2 = list2.getNthNode(list2.head, 5);
		System.out.print(node2.val + "\n");
		
		LinkedList list3 = new LinkedList(new int[] {2, 3, 4, 5, 1, 5, 6, 1});// test case 4 : getNthNode from end
		ListNode node3 = list3.getNthNodeFromEnd(list3.head, 1);
		System.out.print(node3.val + "\n");
		ListNode node4 = list3.getNthNodeFromEnd(list3.head, 8);
		System.out.print(node4.val + "\n");
		ListNode node5 = list3.getNthNodeFromEnd(list3.head, 4);
		System.out.print(node5.val + "\n");
		
		list3.DeleteNode(node4);// test case 5: Delete node
		list3.PrintList(list3.head);
		System.out.print("\n");
		list3.DeleteNode(node5);
		list3.PrintList(list3.head);
		System.out.print("\n");
		
		ListNode head = new ListNode(1); // create a circle list
		LinkedList circleList = new LinkedList(head);
		ListNode node1 = new ListNode(2);
		node2 = new ListNode(3);
		node3 = new ListNode(1);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		
		System.out.print(circleList.hasCircle(head) + "\n");// test case 5: test a list has a circle
		System.out.print(list.hasCircle(list.head) + "\n");
		
	}

}
