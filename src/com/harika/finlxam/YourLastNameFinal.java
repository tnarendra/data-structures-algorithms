package com.harika.finlxam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class YourLastNameFinal {

	public static void main(String[] args) {

		calculate();

		System.exit(0);

	}

	public static void calculate() {

		String csvFile = "/Users/narendraraotadapaneni/Downloads/finaldata.csv";

		BufferedReader csvReader = null;

		BufferedReader txtReader = null;

		LineNumberReader reader = null;

		String line = "";

		String newLine = "";

		String cvsSplitBy = ",";

		HashMap<Integer, List<String>> mapStructure = new HashMap<Integer, List<String>>();

		ArrayList<Integer> listStructure = new ArrayList<Integer>();

		ConcurrentHashMap<Integer, List<String>> treeMap = new ConcurrentHashMap<Integer, List<String>>();

		try {

			csvReader = new BufferedReader(new FileReader(csvFile));

			while ((line = csvReader.readLine()) != null) {

				// use comma as separator

				if (line != null && !line.equalsIgnoreCase("")) {

					String[] lineToArray = line.split(cvsSplitBy);

					List<String> lineToList = Arrays.asList(line.split(","));

					mapStructure.put(Integer.parseInt(lineToArray[0]), lineToList);

					treeMap.put(Integer.parseInt(lineToArray[0]), lineToList);

				}

			}

			String txtFile = "/Users/narendraraotadapaneni/Downloads/lookup.txt";

			txtReader = new BufferedReader(new FileReader(txtFile));

			reader = new LineNumberReader(new FileReader(txtFile));

			while ((reader.readLine()) != null)
				;

			Integer count = reader.getLineNumber();
			
			Integer[] lookups = new Integer[count];

			int index = 0;

			while ((newLine = txtReader.readLine()) != null) {

				if (null != newLine && !newLine.equalsIgnoreCase("")) {

					lookups[index] = Integer.parseInt(newLine);

					index++;
				}
			}

			long startTime = System.nanoTime();
			for (Integer id : lookups) {

				if (null != id)

					mapStructure.get(id);

			}

			long endTime = System.nanoTime();

			System.out.println(endTime - startTime);

			startTime = System.nanoTime();

			for (Integer id : lookups) {

				if (null != id)

					treeMap.get(id);

			}

			endTime = System.nanoTime();

			System.out.println(endTime - startTime);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (NullPointerException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (csvReader != null) {

				try {

					csvReader.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

			if (txtReader != null) {

				try {

					txtReader.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}

	}

}
