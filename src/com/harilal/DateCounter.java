package com.harilal;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class DateCounter {

	public static void main(String[] args) throws IOException {

		List<String> datelist = FileUtils.readLines(new File("c:/temp/data-bugs.txt"));
		Map<String, Integer> dateMap = new HashMap<>();
		for (String dateTxt : datelist) {
			String[] tokens = dateTxt.split(" ");
			String date = tokens[0];
			if (dateMap.containsKey(date)) {
				int counter = dateMap.get(date);
				dateMap.put(date, ++counter);
			} else {

				dateMap.put(date, Integer.valueOf(1));
			}

		}
		dateMap.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
	}

}
