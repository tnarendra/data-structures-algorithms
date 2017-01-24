package com.naren.practice.booking;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Booking {

	private static int search(String subStr, String str) {
		int index = str.indexOf(subStr);
		int count = 0;
		while (index != -1) {
			count++;
			str = str.substring(index + 1);
			index = str.indexOf(subStr);
		}
		return count;
	}

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		String[] words = in.nextLine().split(" ");

		int size = Integer.valueOf(in.nextLine().trim());

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < size; i++) {
			int hotelID = Integer.valueOf(in.nextLine().trim());
			String review = in.nextLine();
			int count = 0;

			for (String str : words) {
				count += search(str, review);
			}

			if (map.containsKey(hotelID)) {
				map.put(hotelID, (map.get(hotelID) + count));
			} else {
				map.put(hotelID, count);
			}
		}
		
		/*List<Entry<Integer, Integer>> ls = new LinkedList<Entry<Integer,Integer>>(map.entrySet());
		
		Collections.sort(ls, new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		
		Map<Integer, Integer> sMap = new LinkedHashMap<Integer, Integer>();
		
		for(Entry<Integer, Integer> mp: ls){
			sMap.put(mp.getKey(), mp.getValue());
		}*/
		
		//Java 8 Sorting
		
		/*Map<Integer, Integer> sortMap = new LinkedHashMap<>();
		
		map.entrySet().stream()
		.sorted(Map.Entry.<Integer, Integer>comparingByValue())
		.forEachOrdered(x -> sortMap.put(x.getKey() , x.getValue()));*/
		
		//System.out.println(sortMap);
	}
	
	
	 
/*    int prev = 0;
    int counter = 0;
    if(in.hasNext())
 	   prev = in.nextInt();
 	   
    while(in.hasNext()){
 	   int tmp = in.nextInt();
 	   if(sum == prev+tmp)
 		   counter++;
 	   prev = tmp;
    }
    System.out.println(counter);

    
    
    int prev = in.nextInt();
    System.out.print(prev+" ");
    
    while(in.hasNext()){
 	   int num = in.nextInt();
 	   int diff = num - prev;
 	   prev = num;
 	   
 	   if(diff >= 127 || diff <= -127)
 		   System.out.print( -128 +" ");
 	   System.out.print(diff+" ");
    }
    

int sum = in.nextInt();
		int size = in.nextInt();
		int counter = 0;
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}

		for (int j = 0; j < size - 1; j++) {
			for (int k = j + 1; k < size; k++) {

				if (sum == arr[j] + arr[k]) {
					System.out.println(arr[j] + " " + arr[k]);
					counter++;
				}
			}
		}

    
    
    
    
    
   // System.out.println(words);
    
    int size = in.nextInt();
    
    for(int i = 0; i < size; i++){
 	   
 	   int hotelID = in.nextInt();
 	   String review = in.nextLine();
 	   
 	   
    }*/
}