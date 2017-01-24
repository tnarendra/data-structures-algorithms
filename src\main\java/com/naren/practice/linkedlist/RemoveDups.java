package com.naren.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

	public static void removeDups(LinkedListNode ll) {
		Set<Integer> set = new HashSet<>();
		LinkedListNode prev = null;

		while (ll != null) {
			if (set.contains(ll.data)) {
				prev.next = ll.next;

			} else {
				set.add(ll.data);
				prev = ll;
			}
			ll = ll.next;
		}
	}

	public static void main(String[] args) {

		LinkedListNode ll = new LinkedListNode(0, null, null);
		LinkedListNode head = ll;
		for (int i = 1; i < 10; i++) {
			LinkedListNode second = new LinkedListNode(i % 3);
			ll.setNext(second);
			second.setPrev(ll);
			ll = second;
		}

		System.out.println(head.print());
		removeDups(head);
		System.out.println(head.print());
	}

}
