/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colections;

import java.util.Deque;
import java.util.LinkedList;
/**
 *
 * @author sirri
 */
public class Queues {
    Deque<String> sodaMachine = new LinkedList<>();
    
    public void loadSoda(String pop)
    {
        sodaMachine.add(pop);
    }
    public String getSoda()
    {
        return sodaMachine.removeLast();
    }
}
