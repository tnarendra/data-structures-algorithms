package com.naren.practice.linkedlist;

public class LinkedListPalindrome {

	public static boolean isPalindrome(LinkedListNode n) {

		LinkedListNode reverse = reverse(n);
		System.out.println(reverse.print());
		System.out.println(n.print());

		while (n != null) {
			if (n.data != reverse.data)
				return false;
			n = n.next;
			reverse = reverse.next;
		}
		return true;
	}

	public static LinkedListNode reverse(LinkedListNode l) {

		LinkedListNode head = null;

		while (l != null) {
			LinkedListNode tmp = new LinkedListNode(l.data);
			tmp.next = head;
			head = tmp;
			l = l.next;
		}
		return head;
	}

	public static void main(String[] args) {

		LinkedListNode ll = new LinkedListNode(0, null, null);
		LinkedListNode head = ll;

		int j = 10;
		for (int i = 1; i <= j; i++) {
			LinkedListNode second = new LinkedListNode(i < j / 2 ? i : j - i);
			ll.setNext(second);
			second.setPrev(ll);
			ll = second;
		}

		System.out.println(head.print());
		System.out.println(head.print());

		System.out.println(isPalindrome(head));
	}

}
