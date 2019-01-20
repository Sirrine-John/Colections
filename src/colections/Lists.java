/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colections;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sirri
 */
public class Lists {
         Runner run1 = new Runner("Sirrine","John S",1,"2019-01-11 17:03:00","R15889");
         Runner run2 = new Runner("Sirrine","Stephanie",4,"2019-01-11 17:05:02","R15889");
         Runner run3 = new Runner("Sirrine","John K",8,"2019-01-11 18:24:00","R15889");
         Runner run4 = new Runner("Fannin","Ryan",6,"2019-01-11 17:06:18","R15889");
         Runner run5 = new Runner("Fannin","Emily",5,"2019-01-11 17:06:17","R15889");
         Runner run6 = new Runner("Oleson","Jamieson",2,"2019-01-11 17:03:15","R15889");
         Runner run7 = new Runner("Oleson","Courtney",7,"2019-01-11 17:55:30","R15889");
         Runner run8 = new Runner("Sirrine","Loann",10,"2019-01-11 18:25:06","R15889");
         Runner run9 = new Runner("Kealer","Keith",3,"2019-01-11 17:03:25","R15889");
         Runner run10 = new Runner("Kealer","Emilee",9,"2019-01-11 18:24:10","R15889");
        List<Runner> runList;
         
         public Lists()
         {
             runList = new ArrayList<>();
         }
        
        public void runRace()
        {
         runList.add(run1);
         runList.add(run6);
         runList.add(run9);
         runList.add(run2);
         runList.add(run5);
         runList.add(run4);
         runList.add(run7);
         runList.add(run3);
         runList.add(run10);
         runList.add(run8);
        }
        
        public void printWinners()
        {
         for (int i=0;i<runList.size();i++)
            {
                Runner Participant = runList.get(i);
                System.out.println("In place number " +
                        Participant.getPosition().toString() +
                        " we have " +
                        Participant.getFirstName()+
                        " " +
                        Participant.getLastName());
            }
        }
}
