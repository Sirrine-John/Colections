/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads_executor_runnables;

/**
 *
 * @author sirri
 */
public class Threads_Executor_Runnables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    
    
    
}
