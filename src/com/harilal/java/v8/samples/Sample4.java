package com.harilal.java.v8.samples;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.harilal.java.v8.samples.util.Helper;

public class Sample4 {

	public static void main(String[] args) {
		List<Integer> numbers = Helper.getNumberList();
		System.out.println("Predicate Testing \n -----------------");
		System.out.println("print numbers \n ");
		eval(numbers, n -> true);

		for (int i = 1; i <= 5; i++) {
			int j = i;
			System.out.println(String.format("print numbers multiples of %s ", i));
			eval(numbers, n -> (n % j) == 0);
		}
		System.out.println("Numbers > 3");
		eval(numbers, n -> (n > 3));
		System.out.println("Odd Even Students Categorisation");
		Map<Integer, String> studentMap = Helper.getStudentMap();
		eval(studentMap, (k) -> (k % 2) == 0);
	}

	private static void eval(Map<Integer, String> studentMap, Predicate<Integer> predicate) {
		studentMap.forEach((k, v) -> {
			if (predicate.test(k)) {
				System.out.println(String.format("EVEN %s | %s", k, v));
			} else {
				System.out.println(String.format("ODD  %s | %s", k, v));

			}
		});
	}

	private static void eval(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.forEach((number) -> {
			if (predicate.test(number)) {
				System.out.println(number);
			}
		});
	}

}
