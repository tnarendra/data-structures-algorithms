package com.naren.practice.threads;

public class MyThread extends Thread {
	
	public void run() {
		System.out.println("This is Thread Implemenattion");
		for(int i = 0; i < 10; i++) {
			System.out.println("Value: " + i);
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		MyThread myThread2 = new MyThread();
		
		myThread.start();
		myThread2.start();
		
		Thread threadRunnable = new Thread(new ThreadRunnable());
		Thread threadRunnable2 = new Thread(new ThreadRunnable());
		
		threadRunnable.start();
		threadRunnable2.start();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("This is Runnable Implemenattion");
				for(int i = 0; i < 10; i++) {
					System.out.println("Value: " + i);
				}
			}
		});
		
		t1.start();

	}
}

class ThreadRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("This is Runnable Implemenattion");
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Value: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}