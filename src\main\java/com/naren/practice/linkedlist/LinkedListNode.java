package com.naren.practice.linkedlist;

public class LinkedListNode {

	 LinkedListNode next;
	 LinkedListNode prev;
	 LinkedListNode last;
	int data;

	public LinkedListNode() {
		// TODO Auto-generated constructor stub
	}
	
	public LinkedListNode(int d) {
		this.data = d;
	}

	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {

	}

	public void setNext(LinkedListNode n) {
		next = n;
		if (this == last)
			last = n;
		if (n != null && n.prev != this)
			n.setPrev(this);
	}

	public void setPrev(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this)
			p.setNext(this);
	}
	
	public String print(){
		if(next != null)
			return data  + " --> "+ next.print();
		else
			return ((Integer)data).toString();
	}
}
