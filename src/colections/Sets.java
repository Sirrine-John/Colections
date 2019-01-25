/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colections;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sirri
 */
public class Sets {
    Set<String> runID;
    
    Sets()
        {
            runID = new HashSet<>(); 
        }
    
    public void registerRunners(String[] id)
        {
            for(int i=0;i<id.length-1;i++)
            {
                runID.add(id[i]);
            }
        }
    public void runnerCheckIn(Runner run)
        {
            if (runID.contains(run.getRunnerID()))
            {
                System.out.println(run.getFirstName()+ " " + run.getLastName()+
                        " is now checked in.");
            }
            else
            {
                System.out.println(run.getFirstName()+ " " + run.getLastName()+
                        " is NOT registered!");
            }
        }
}
