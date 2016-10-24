package com.darren.test;

public class CustomThread extends Thread {

	private Test test;
	private int[][] array;
	private int from;
	private int to;
	private int deep;

	public CustomThread(Test test, int[][] array, int from, int to, int deep) {
		this.test = test;
		this.array = array;
		this.from = from;
		this.to = to;
		this.deep = deep;
	}

	public void run() {
		for (int i = from; i < to; i++) {
			for (int j = 0; j < deep; j++) {
				array[i][j] = (i + j) * i * j / 2;
			}
		}

		test.nodify();
	}

}
