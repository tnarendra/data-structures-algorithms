package com.naren.practice.threads;

public class ThreadLocalSample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<String> threadLocal =
               new ThreadLocal<String>();
        
        private double i;

        @Override
        public void run() {
            
        	threadLocal.set( "Thread Local: " + Math.random() );
        	i = Math.random();
    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadLocal.get() + ", variable: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
    }
}