package com.naren.practice.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String... strings) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(40);

		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}
}

class Waiter implements Runnable {

	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			System.out.println("Waiter thread is waiting.. ");
			latch.await();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");
	}
}

class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		try {
			for (int i = 0; i < 40; i++) {
				Thread.sleep(10);
				this.latch.countDown();
				System.out.println(latch.getCount());
			}

			System.out.println("Waiter will execute now");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
