/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hikes_mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author sirri
 */
public class HikesView {
    HikesView(){
        selection = "~";
        options = new String[]{"H","I","A","D","S","E"};
        optionsSet = new HashSet<>(Arrays.asList(options));
        System.out.println("Welcome to the Hike information program!");
    }
    String selection;
    String[] options;
    Set<String> optionsSet;
    Scanner getInput = new Scanner(System.in);

    public String showMenu(){
        while(!this.optionsSet.contains((this.selection).toUpperCase()))
        {
        System.out.println();
        System.out.println("Please enter one of the following options:");
        System.out.println("H: Hike list");
        System.out.println("I: Get information on a single hike");
        System.out.println("A: Add new hike");
        System.out.println("D: Delete hike");
        System.out.println("S: Show details of all hikes");
        System.out.println("E: EXIT");
        this.selection = this.getInput.nextLine();
    }
        return this.selection.toUpperCase();
    }
    
    public String keyPrompt(){
        System.out.println("Please enter the name of the hike:");
        return getInput.nextLine();
    }
    public ArrayList addPrompt(){
        ArrayList<String> hike = new ArrayList<>();
        System.out.println("Please enter name of hike:");
        hike.add(this.getInput.nextLine());
        System.out.println("Please enter length of hike:");
        hike.add(this.getInput.nextLine());
        System.out.println("Please enter difficulty of hike:");
        hike.add(this.getInput.nextLine());
        System.out.println("Please enter description of hike:");
        hike.add(this.getInput.nextLine());
        System.out.println("please enter directions to get to hike:");
        hike.add(this.getInput.nextLine());
        System.out.println("The following hike will be added to the system:");
        this.printOutput(hike);
        return hike;
    }
    
    public void printOutput(ArrayList output){
        for (int i =0; i < output.size(); i++){
            System.out.println(output.get(i).toString());
        }
        System.out.println();
        selection = "~";
    }
    
    public void exit(){
        System.exit(0);
    }
}
