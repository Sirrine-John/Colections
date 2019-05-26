/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_Calculator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sirri
 */
public class View {
    public static void goMath(){
        String again = "m";
        while (again.equals("m")){
        try{
            Scanner getInput = new Scanner(System.in);
            Double input1;
            Double input2;
            String operator;
            String output;
            
            System.out.println("Enter first number for Calculator: ");
            input1 = Double.parseDouble(getInput.nextLine());
            System.out.println("Enter operator: '(+,-,*,/,%,^)'");
            operator = getInput.nextLine();
            if (MVC_CALCULATOR.checkOperator(operator) == false){
                System.out.println("INVALID OPERATOR, TRY AGAIN");
                continue;
            }
            System.out.println("Enter second number for Calculator: ");
            input2 = Double.parseDouble(getInput.nextLine());
            
            output = MVC_CALCULATOR.makeCalculation(operator,input1,input2);
            System.out.println(output);
            System.out.println(System.lineSeparator()
                                + "Enter Option:"
                                + System.lineSeparator()
                                + "m: More Math?"
                                + System.lineSeparator()
                                + "h: Show History?"
                                + System.lineSeparator()
                                + "e: Exit Program?");
            again = getInput.nextLine();
            if (again.equals("h")){showHist();};
            }
        catch(NumberFormatException e){
            Scanner getInput = new Scanner(System.in);
            System.out.println(System.lineSeparator()
                                + "Error Entering data.");
            System.out.println("Enter Option:"
                                + System.lineSeparator()
                                + "m: More Math?"
                                + System.lineSeparator()
                                + "h: Show History?"
                                + System.lineSeparator()
                                + "e: Exit Program?");
            again = getInput.nextLine();
        }
        
        }
       
    }

    public String outResult(String result){
        return result;
    }
    public static void showHist(){
        String again = "h";
        System.out.println(System.lineSeparator()
                           +"Math Transaction History");
        while (again.equals("h")){
            ArrayList<String> history = new ArrayList<>();
            history = MVC_CALCULATOR.showHistory();
            history.forEach((i) -> System.out.println(i));
            
            Scanner getInput = new Scanner(System.in);
            System.out.println(System.lineSeparator()
                                + "Enter Option:"
                                + System.lineSeparator()
                                + "m: More Math?"
                                + System.lineSeparator()
                                + "h: Show History?"
                                + System.lineSeparator()
                                + "e: Exit Program?");
            again = getInput.nextLine();
            if (again.equals("m")){goMath();};
            }
    }
}