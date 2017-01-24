package com.naren.practice.threads;


public class ThreadVolatileExample {

	protected volatile static  int value = 0;

	public static void main(String... strings) {

		ListenerThread listenerThread = new ListenerThread();
		listenerThread.start();

		ControllerThread controllerThread = new ControllerThread();
		controllerThread.start();

	}
}

class ListenerThread extends Thread {
	public void run() {
		int local = ThreadVolatileExample.value;
		
		while (local < 20) {
			
			if(local != ThreadVolatileExample.value) {
				System.out.println(" Reading value: " + ThreadVolatileExample.value + "\n");
			}
			local = ThreadVolatileExample.value;
		}
	}
}

class ControllerThread extends Thread {
	public void run() {
		
		int local = ThreadVolatileExample.value;
		while (ThreadVolatileExample.value < 20) {
			System.out.println(" Incrementing value: " + (local+1));
			ThreadVolatileExample.value = ++local;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}