package org.ibm.oops;

public class TestThread {

    public static void main(String[] args) {
        
        Runnable taskA = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Inside Task A");
        };

        Runnable taskB = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            System.out.println("Inside Task B");
        };

        Thread worker1 = new Thread(taskB);
        Thread worker2 = new Thread(taskA);

        worker1.start();
        worker2.start();
        System.out.println("Main Thread");
    }

}
