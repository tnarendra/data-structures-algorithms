package com.harika.finlxam;

/**
 * This program: 
 * - Reads data records from finaldata.cvs file into BinaryTree in ascending order, 
 * and displays CPU time used by BinaryTree to search the records.
 * 
 * - Reads data records from finaldata.cvs file into Hash Map.
 * Displays CPU time used by Hash Map to search the records.
 *
 * @author Harika Kakkera
 * 
 * DAA, Final Exam.
 **/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KakkeraFinal {

	public static void main(String[] args) throws IOException {

		BinaryTree tree = new BinaryTree();
		HashMap<Integer, FinalData> hashMap = new HashMap<Integer, FinalData>();

		long hashMapCPUSearchTime = 0;
		long binaryTreeCPUSearchTime = 0;

		List<Integer> searchIDs = getSearchIDs();

		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
			inputStream = new FileInputStream("/finaldata.csv");
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line != null && !line.isEmpty()) {
					FinalData data = new FinalData(line);
					hashMap.put(data.getID(), data);
					tree.add(data);
				}
			}

		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}

		long startTime = System.currentTimeMillis();

		for (int searchId : searchIDs) {

			if (hashMap.containsKey(searchId)) {
				//uncomment below line two print searched data
				//System.out.println("HashMap: ID '" + searchId + "' found.");
			}
		}
		
		hashMapCPUSearchTime = System.currentTimeMillis() - startTime;
		startTime = System.currentTimeMillis();
		
		for (int searchId : searchIDs) {
			tree.search(searchId);
		}

		binaryTreeCPUSearchTime = System.currentTimeMillis() - startTime;

		System.out.println("CPU time used by BinaryTree to search the records: " + binaryTreeCPUSearchTime + " ms.");
		System.out.println("CPU time used by HashMap to search the records: " + hashMapCPUSearchTime + " ms.");
		
		if(binaryTreeCPUSearchTime < hashMapCPUSearchTime) {
			System.out.println("\n BinaryTree search is faster than HashMap search");
		} else{
			System.out.println(" \n HashMap search is faster than BinaryTree search");
		}

	} // main

	public static List<Integer> getSearchIDs() {

		List<Integer> list = new ArrayList<Integer>();
		try {
			Scanner scan = new Scanner(new FileReader("/lookup.txt"));

			while (scan.hasNext()) {
				list.add(scan.nextInt());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}

// A binary tree node which is independent of the data class
class BinaryTree {
	FinalData data;
	BinaryTree left, right;
	BinaryTree root;

	public BinaryTree() {
		data = null;
		root = left = right = null;
	};

	public BinaryTree(FinalData d) {
		data = d;
		left = right = null;
	}

	public FinalData getData() {
		return data;
	}

	public void search(Integer id) {
		search(root, id);
	}

	private void search(BinaryTree r, int id) {

		if (r != null) {
			if (r.data.getID() == id) {
				//uncomment below line two print searched data
				//System.out.println("BinaryTree: ID '" + id + "' found");
			}
			if (r.left != null) {
				search(r.left, id);
			}
			if (r.right != null) {
				search(r.right, id);
			}
		}
		return;
	}

	public void setData(FinalData d) {
		data = d;
	}

	public void add(FinalData newnode) {
		if (root == null) {
			data = newnode;
			root = this;
			return;
		}
		BinaryTree temp = new BinaryTree(newnode);
		if (newnode.getID().compareTo(root.data.getID()) > 0)
			root.right = add(root.right, temp);
		else
			root.left = add(root.left, temp);
	} // add

	public BinaryTree add(BinaryTree rt, BinaryTree n) {
		if (rt == null)
			return n;
		if (n.getData().getID().compareTo(rt.getData().getID()) > 0)
			rt.right = rt.add(rt.right, n);
		else
			rt.left = rt.add(rt.left, n);
		return rt;
	}

	public void printTree() {
		if (root != null) {
			show(root.left);
			System.out.println(root.data);
			show(root.right);
		}
	}

	public void show(BinaryTree r) {
		if (r != null) {
			show(r.left);
			System.out.println(r.data);
			show(r.right);
		}
	} // show
} // BinaryTree

// Data class
class FinalData implements Comparable<FinalData> {
	Integer ID;
	String str, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12;

	public FinalData(String s) {
		StringTokenizer st = new StringTokenizer(s, ",");

		ID = Integer.parseInt(st.nextToken(","));
		str = st.nextToken(",");
		str1 = st.nextToken(",");
		str2 = st.nextToken(",");
		str3 = st.nextToken(",");
		str4 = st.nextToken(",");
		str5 = st.nextToken(",");
		str6 = st.nextToken(",");
		str7 = st.nextToken(",");
		str8 = st.nextToken(",");
		str9 = st.nextToken(",");
		str10 = st.nextToken(",");
		str11 = st.nextToken(",");
		str12 = st.nextToken(",");
	}

	public Integer getID() {
		return ID;
	}

	public int compareTo(FinalData data) {
		// sort the data based on ID in ascending order
		// returns a negative integer, zero, or a positive integer as this id
		// is less than, equal to, or greater than the specified object.
		return (this.ID - data.ID);
	}
}// FinalData
