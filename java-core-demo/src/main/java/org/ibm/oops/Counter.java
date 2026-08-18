package org.ibm.oops;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count = 0;

    //private Object lock = new Object();
    private final Lock lock = new ReentrantLock();

    public  void increment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       lock.lock();
       try {
         count++;
       } finally{
        lock.unlock();
        // TODO: handle exception
       }
           
        }
         // Not atomic! This is read-modify-write.
    }

    public int getCount() {
        return count;
    }

}
