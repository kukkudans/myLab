package com.harilal.java.v8.samples;

public class Sample2 {

	public static void main(String[] args) {
		Operation add = (a, b) -> a + b;
		Operation subtract = (a, b) -> a - b;
		Operation multiply = (a, b) -> a * b;
		Operation devide = (a, b) -> a / b;

		Sample2 obj = new Sample2();

		System.out.println("Testing the java8 Implemenations of interface Operation\n");
		System.out.println("testint ADD with 10,5 -> " + obj.execute(10, 5, add));
		System.out.println("testint SUBTRACT with 10,5 -> " + obj.execute(10, 5, subtract));
		System.out.println("testint MULTIPLY with 10,5 -> " + obj.execute(10, 5, multiply));
		System.out.println("testint DEVIDE with 10,5 -> " + obj.execute(10, 5, devide));

		System.out.println("\nTesting the java8 Implemenations of interface HelloWishHelper \n");
		HelloWishHelper wisher = a -> String.format(HelloWishHelper.HELLO_TEMPLATE, a);
		System.out.println(wisher.greet("Harilal"));

	}

	private int execute(int a, int b, Operation operation) {
		return operation.execute(a, b);
	}

	interface Operation {
		public int execute(int a, int b);
	}

	interface HelloWishHelper {
		public static final String HELLO_TEMPLATE = " Hello %s !";

		public String greet(String name);
	}
}
