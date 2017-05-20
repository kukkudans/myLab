package com.harilal.java.v8.samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.harilal.java.v8.samples.util.Helper;

public class Java8Sample {

	public static void main(String args[]) {

		List<String> names1 = Helper.getNameList();

		List<String> names2 = new ArrayList<>(names1);

		Java8Sample tester = new Java8Sample();
		System.out.println("Sort using Java 7 syntax: ");

		tester.sortUsingJava7(names1);
		System.out.println(names1);
		System.out.println("ASCENDING Sort using Java 8 syntax: ");

		tester.sortUsingJava8(names2, SortType.ASCENDING);
		System.out.println(names2);
		System.out.println("DESCENDING Sort  using Java 8 syntax: ");

		tester.sortUsingJava8(names2, SortType.DESCENDING);
		System.out.println(names2);
	}

	

	// sort using java 7
	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	// sort using java 8
	private void sortUsingJava8(List<String> names, SortType sortType) {
		switch (sortType) {
		case ASCENDING:
			Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
			break;
		case DESCENDING:
			Collections.sort(names, (s1, s2) -> s2.compareTo(s1));
			break;
		default:
			Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
			break;

		}
	}

	// enum for sorting
	enum SortType {
		ASCENDING, DESCENDING
	}
}
