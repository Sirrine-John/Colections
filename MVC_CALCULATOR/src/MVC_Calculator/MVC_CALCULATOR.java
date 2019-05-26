/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_Calculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author sirri
 */
public class MVC_CALCULATOR {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       View.goMath();
    }
    public static Model myModel = new Model();
    public static String formatOutput(String operator, Double input1, Double input2, Double output){
        return input1.toString() 
               + " " 
               + operator 
               + " " 
               + input2.toString()
               + " = "
               + output.toString();
    }
    
    public static String makeCalculation(String operator,Double input1,Double input2){
        RequestHandler calculate = new RequestHandler();
        String output = "";
            output =  formatOutput(operator,input1,input2,calculate.handleOperator(operator,input1,input2));
            myModel.history.add(output);
        return output;
    }
    public static Boolean checkOperator(String operator){
        if (Arrays.asList("+","-","*","/","%","^").contains(operator)){
            return true;
        }else{return false;}
        
    }
    public static ArrayList showHistory(){
        return myModel.history;
    }
    
}
