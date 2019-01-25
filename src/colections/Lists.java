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
public class Lists {
        
        public void printParticipants(ArrayList<Runner> runList)
        {
         for (int i=0;i<runList.size();i++)
            {
                Runner Participant = runList.get(i);
                System.out.println("Participant: " +
                        Participant.getFirstName()+
                        " " +
                        Participant.getLastName() +
                        " is in starting Postition " +
                        Participant.getPosition().toString());
            }
        }
}
