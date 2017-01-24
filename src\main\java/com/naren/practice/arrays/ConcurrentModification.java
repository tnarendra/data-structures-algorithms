package com.naren.practice.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ConcurrentModification {

	public static void main(String... strings) {
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("itr10");
		list1.add("itr11");
		list1.add("itr12");
		list1.add("itr13");
		list1.add("itr14");
		list1.add("itr15");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("itr20");
		list2.add("itr21");
		list2.add("itr22");
		list2.add("itr23");
		list2.add("itr24");
		list2.add("itr25");
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("itr30");
		list3.add("itr31");
		list3.add("itr32");
		list3.add("itr33");
		list3.add("itr34");
		list3.add("itr35");
		
		ArrayList<Iterator<String>> ls = new ArrayList<>();
		ls.add(list1.iterator());
		ls.add(list2.iterator());
		ls.add(list3.iterator());
		
		ArrayList<ArrayList<String>> listLS = new ArrayList<>();
		listLS.add(list1);
		listLS.add(list2);
		listLS.add(list3);

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		
		for(int i = 0; i < ls.size(); i++ ) {
			
			for(int j = 0; j < ls.size(); j++ ) {
			Iterator<String> itr1 = ls.get(i);
			
			if(itr1.hasNext())
				System.out.println(itr1.next());
			}
		}
		

		Iterator<Integer> it = list.iterator();

		while (it.hasNext()) {
			int i = (int) it.next();
			System.out.println(" " + i);
			if (i == 10)
				it.remove();
			// list.add(10);
		}

		System.out.println(list.toString());

		list.add(10);
		ListIterator<Integer> lit = list.listIterator();

		while (lit.hasNext()) {
			int i = (int) lit.next();
			System.out.println(" " + i);
			if (i == 10) {
				lit.remove();
				lit.add(10);
			}
			// list.add(10);
		}

		System.out.println(list.toString());

	}
}
