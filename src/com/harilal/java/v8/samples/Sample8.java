package com.harilal.java.v8.samples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.harilal.java.v8.samples.util.Helper;

public class Sample8 {

	public static void main(String[] args) {
		List<String> nameList = Helper.getNameList();
		String NAME_TO_SEARCH = "Naresh";

		System.out.println("Is Name Present : Naresh "
				+ nameList.stream().anyMatch(name -> name.equals(NAME_TO_SEARCH)));

		List<Boolean> matchingList = nameList.stream().map(name -> name.equals(NAME_TO_SEARCH))
				.collect(Collectors.toList());
		System.out.println(matchingList);

		Stream<String> filteredStream = nameList.stream().filter(name -> name.equals(NAME_TO_SEARCH));
		System.out.println(String.format("Found %s matche for %s", filteredStream.count(), NAME_TO_SEARCH));

		List<String> filteredNameList = filteredStream.collect(Collectors.toList());
		System.out.println(filteredNameList);
	}

}
