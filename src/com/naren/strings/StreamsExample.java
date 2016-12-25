package com.naren.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

	public static void main(String[] args) {

		String[] colors = { "Red", "White", "Black", "Green", "Blue", "Pink" };
		List<String> ls = (List<String>) Arrays.asList(colors);

		Stream<String> stream = ls.stream();

		Stream<String> countries = Stream.of("USA", "India", "China", "UK");
		Stream<String> states = Stream.of("TX", "CA", "MD", "VA", "MO", "NY");

		// concat streams, for each.
		Stream.concat(countries, states)
			.forEach(string -> System.out.print(string + " "));

		System.out.println();

		// filter
		stream.filter(str -> str.startsWith("R"))
			.forEach(System.out::println);

		// count
		System.out.println(ls.stream().count() + " ");

		// map
		ls.stream()
			.map(string -> new String(string + ", "))
			.forEach(System.out::print);
		
		System.out.println();
		
		// Collect
		List<String> students = ls.stream()
		        .filter(str -> str.contains("e"))
		        .map(String::new)
				.collect(Collectors.toList());

		System.out.println(students.toString());

	}
}
