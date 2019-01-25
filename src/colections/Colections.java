/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colections;

import java.util.ArrayList;

/**
 *
 * @author sirri
 */
public class Colections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        //initialize dataset
        String[][] runnerArray = {
                {"Sirrine","John S","1","2019-01-11 17:03:00","R15889"},
                {"Sirrine","Stephanie","4","2019-01-11 17:05:02","R15890"},
                {"Sirrine","John K","8","2019-01-11 18:24:00","R15891"},   
                {"Fannin","Ryan","6","2019-01-11 17:06:18","R15892"},  
                {"Fannin","Emily","5","2019-01-11 17:06:17","R15893"},  
                {"Oleson","Jamieson","2","2019-01-11 17:03:15","R15894"},  
                {"Oleson","Courtney","7","2019-01-11 17:55:30","R15895"},  
                {"Sirrine","Loann","10","2019-01-11 18:25:06","R15896"},  
                {"Kealer","Keith","3","2019-01-11 17:03:25","R15897"},  
                {"Kealer","Emilee","9","2019-01-11 18:24:10","R15898"} 
        };
        ArrayList<Runner> runnerList = new ArrayList<>();
        for(int i = 0;i<10;i++)
        {
            Runner temp = new Runner(runnerArray[i][0],runnerArray[i][1],runnerArray[i][2],runnerArray[i][3],runnerArray[i][4]);
            runnerList.add(temp);
            temp = null;
        }
        
        //Lists
        Lists raceList = new Lists();
        raceList.printParticipants(runnerList);
        
        //Sets 
        Sets registerAndCheckin = new Sets();
        String[] registrants = {"R15889","R15892","R15897","R15893","R15895"};
        registerAndCheckin.registerRunners(registrants);
        for (int i=0;i<runnerList.size()-1;i++)
        {
            registerAndCheckin.runnerCheckIn(runnerList.get(i));
        }
        
        //Maps
        Maps map = new Maps();
        for (int i=0;i<runnerList.size()-1;i++)
        {
            map.addRunnerToMap(runnerArray[i][1], runnerArray[i][4]);
        }
        map.getRunnerName("John");
        map.getRunnerName("John S");
        map.getRunnerName("Stephanie");
        map.getRunnerName("Keith");
        map.getRunnerName("Alfred");
        map.getRunnerName("Ryan");
        map.getRunnerName("Bob");
        
        //Queues
        Queues queue = new Queues();
        
        //Trees
        Trees tree = new Trees();
        
    }
}