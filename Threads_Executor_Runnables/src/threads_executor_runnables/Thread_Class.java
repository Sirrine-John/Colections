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
public class Thread_Class extends Thread{
    public Thread_Class(String str) {
        super(str);
    }
    public void run() {
        int loopInt = (int) Math.round(Math.random() * 100);
        for (int i = 0; i < loopInt; i++) {
            //System.out.println(getName() + " loop "+ i);
//            try {
//               sleep((int)(Math.random() * 1000));
//            } catch (InterruptedException e) {}
        }
        System.out.println(loopInt + " Loops DONE! " + getName());
    }
}
    