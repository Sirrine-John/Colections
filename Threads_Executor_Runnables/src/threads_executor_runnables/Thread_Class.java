/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads_executor_runnables;

import java.lang.Thread;
/**
 *
 * @author sirri
 */
public class Thread_Class extends Thread{
    public Thread_Class(String str) {
        super(str);
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " loop "+ i);
            try {
               sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        System.out.println("DONE! " + getName());
    }
}
    