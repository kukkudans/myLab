package com.harilal.best;

public class TimeElapsedHelper {

	public static void main(String[] args) throws InterruptedException {

		long startTime = System.nanoTime();
		Thread.sleep(1000);
		System.out.println((System.nanoTime() - startTime) / 1000000);
	}

}
