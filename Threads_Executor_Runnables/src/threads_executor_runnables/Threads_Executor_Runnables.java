/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads_executor_runnables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.*;
/**
 *
 * @author sirri
 */
public class Threads_Executor_Runnables {

    /**
     * @param args the command line arguments
     */
        private static AtomicInteger count = new AtomicInteger();
    public static void main(String[] args) {
        count.set(0);
        manualThread();
        executorThread();
    }
    
    private static void manualThread(){     
        Thread_Class mythread1 = new Thread_Class("Thread 1");
        Thread_Class mythread2 = new Thread_Class("Thread 2");
        Thread_Class mythread3 = new Thread_Class("Thread 3");
        Thread_Class mythread4 = new Thread_Class("Thread 4");
        Thread_Class mythread5 = new Thread_Class("Thread 5");
        mythread1.start();
        mythread2.start();
        mythread3.start();
        mythread4.start();
        mythread5.start();
    }
    
    private static Runnable threadRun = () -> {
        Thread_Class mythread = new Thread_Class("ex_Thread");
        mythread.start();
        count.getAndIncrement();
        System.out.println("Threads Launched: "+count);
    };
    
    private static void executorThread(){
        ExecutorService exeServ = Executors.newFixedThreadPool(10);
        for (int i=0;i<5;i++){
            exeServ.submit(threadRun);
        }
        try {
            //Without this line of code, the threadpool would not time out upon completion.
            exeServ.shutdown();
            //If the program hasn't finished in 15 seconds then something is wrong (since it should take 6 seconds).
            exeServ.awaitTermination(20,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
