package com.naren.threads;

public class ThreadLocalSample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<String> threadLocal =
               new ThreadLocal<String>();

        @Override
        public void run() {
        	System.out.println(threadLocal.get());
            
        	threadLocal.set( "Thread Local: " + Math.random() );
    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

    }

}