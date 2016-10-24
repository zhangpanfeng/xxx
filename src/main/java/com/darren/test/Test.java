package com.darren.test;

public class Test {
	private static final int DEEP = 121;
	private volatile int count;
	private static int array[][] = new int[21][DEEP];
	long start = System.currentTimeMillis();

	public static void main(String[] args) {

		Test test = new Test();

		Thread t1 = new CustomThread(test, array, 0, 7, DEEP);
		Thread t2 = new CustomThread(test, array, 7, 14, DEEP);
		Thread t3 = new CustomThread(test, array, 14, 21, DEEP);

		t1.start();
		t2.start();
		t3.start();

	}

	public synchronized void nodify() {
		count++;
		if (count == 3) {
			this.continueGo();
		}
	}

	public void continueGo() {
		long end = System.currentTimeMillis();
		System.out.println("Total : " + (end - start));
	}
}
