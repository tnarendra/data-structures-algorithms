package com.naren.practice.list;

import java.util.Arrays;

public class ListExample {

	public static void main(String args[]) {

		ListImpl<String> list = new ListImpl<String>();

		list.add("Dog");
		list.add("Cat");
		list.add("Bull");
		list.add("Rat");
		list.add("Tiger");

	}
}

class ListImpl<E> {

	private E e;
	private int size = 0;
	
	private static final int DEFAULT_CAPACITY = 10;

	Object[] array = new Object[DEFAULT_CAPACITY];

	public void add(E e) {
		ensureCapasity();
		array[size] = e;
		size++;
	}

	private void ensureCapasity() {
		//if(size<)
		
	}

	public int size() {
		return size;
	}

	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (array[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(array[i]))
					return i;
		}
		return -1;
	}

	public E get(int index) {
		if (index > size)
			return null;
		return (E) array[index];
	}

}
