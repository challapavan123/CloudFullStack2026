package org.ibm.oops;

public class TestSynchronization {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread [] threads = new Thread[100];
        for(int i=0;i<threads.length;i++){
            
           
            threads[i] = new Thread(()->{
                for(int j=0;j<10;j++){
                    counter.increment();
                }
            });
            threads[i].start();
             //System.out.println("Threads [i]"+threads[i]);
        }
        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }

        }
        System.out.println("Thread Count"+counter.getCount());
    }

}

// Spring also provides solutions for different enterprise problems
// 1. Spring Boot
// 2. Spring Cloud
// 3. Spring Data
// 4. Spring Security
// 5. Spring Mobile

// 7676869057 
