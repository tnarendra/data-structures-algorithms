package com.naren.practice.threads;

import java.util.LinkedList;

public class ProducerConsumerSync {

	private LinkedList<Integer> list = new LinkedList<>();
	private static final int LIMIT = 10;

	private Object lock = new Object();

	public void produce() throws InterruptedException {

		int value = 0;

		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println("; value is: " + value);
				lock.notify();
			}

			Thread.sleep(100);
		}
	}

	public static void main(String... strings) throws InterruptedException {

		final ProducerConsumerSync consumerSync = new ProducerConsumerSync();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consumerSync.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consumerSync.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
