package com.naren.practice.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSynchronized {
	
	private static int count1 = 0;
	private static int count2 = 0;
	private static Integer count3 = 0;
	private static AtomicInteger count4 = new AtomicInteger(0);
	

	
	private synchronized void incrementCount1(){
		count1++;
	}
	
	private void incrementCount2(){
		count2++;
		count4.incrementAndGet();
	}
	
	private void incrementCount3(){
		synchronized (this) {
			count3++;
		}
	}
	
	
	public void doWork() {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++){
					incrementCount1();
					incrementCount2();
					incrementCount3();
				}
			}
		});
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++){
					incrementCount1();
					incrementCount2();
					incrementCount3();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++){
					incrementCount1();
					incrementCount2();
					incrementCount3();
				}
			}
		});
		
		t.start();
		t1.start();
		t2.start();
				
		
		try {
			t.join();
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread safe : " + count1);
		System.out.println("Not thread safe: " +count2);
		System.out.println("Thread safe : " +count3);
		System.out.println("Thread safe : " +count4.get());
		
	}

	

	public static void main(String[] args) {
		ThreadSynchronized threadSynchronized = new ThreadSynchronized();
		threadSynchronized.doWork();
		
	}

}
