/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_controller_pattern_calculator;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sirri
 */
public class Application_Controller_Pattern_CALCULATOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        goMath();
    }
    private static void goMath(){
        String again = "y";
        while (again.equals("y")){
        try{
            Scanner getInput = new Scanner(System.in);
            RequestHandler calculate = new RequestHandler();
            Double input1;
            Double input2;
            String operator;
            
            System.out.println("Enter first number for Calculator: ");
            input1 = Double.parseDouble(getInput.nextLine());
            System.out.println("Enter operator: '(+,-,*,/,%,^)'");
            operator = getInput.nextLine();
            if (checkOperator(operator) == false){
                System.out.println("INVALID OPERATOR, TRY AGAIN");
                continue;
            }
            System.out.println("Enter second number for Calculator: ");
            input2 = Double.parseDouble(getInput.nextLine());
            System.out.println(System.lineSeparator()
                              + input1.toString() 
                              + " " 
                              + operator 
                              + " " 
                              + input2.toString()
                              + " = "
                              + calculate.handleOperator(operator,input1,input2).toString());
            System.out.println("More Math?  Y/N");
            again = getInput.nextLine();
        }
        catch(NumberFormatException e){
            Scanner getInput = new Scanner(System.in);
            System.out.println("Error Entering data.");
            System.out.println("More Math?  Y/N");
            again = getInput.nextLine();
        }    
    }
    }
    
    private static Boolean checkOperator(String operator){
        if (Arrays.asList("+","-","*","/","%","^").contains(operator)){
            return true;
        }else{return false;}
        
    }
    
}
