package com.harilal;

public class RomanConverter {
	private static int[] NUMBERS = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static String[] LETTERS = { "m", "cm", "d", "cd", "c", "xc", "l", "xl", "x", "ix", "v", "iv", "i" };

	protected static String toRoman(int value) {
		StringBuilder roman = new StringBuilder();
		int remainder = value;
		for (int i = 0; i < NUMBERS.length; i++) {
			int number = NUMBERS[i];
			while (remainder >= number) {
				roman.append(LETTERS[i]);
				remainder -= number;
			}
		}
		return roman.toString();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " " + toRoman(i));

		}
	}
}
