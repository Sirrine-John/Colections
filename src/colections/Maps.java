/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colections;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author sirri
 */
public class Maps {
    Map<String,String> runnerMap = new HashMap<>();
    
    public void addRunnerToMap(String Name,String ID)
    {
        runnerMap.put(Name, ID);
    }
    public void getRunnerName(String Name)
    {
        if (runnerMap.containsKey(Name))
        {
            System.out.println("The ID of the runner you requested is "+
                    runnerMap.get(Name));
        }
        else
        {
            System.out.println("A runner ID was not found for "+ Name);
        }
    }
}
