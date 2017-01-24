package com.naren.practice.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorExample {
	
	public static void main(String...strings) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//Future object has methods to check the task completion
		Future future = null;
		for(int i = 0; i < 10; i++){
			future = executor.submit(new Processor(i));
			System.out.println("Future result: "+ future.get());
		}
		executor.shutdown();
		
		System.out.println("Tasks has been submitted.");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Tasks has been completed.");
	}
}

class Processor implements Runnable {
	
	private int id;
	
	public Processor(int id){
		this.id=id;
	}
	
	public void run() {
		System.out.println("Starting: " + id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed: " + id);
	}

}
