/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_Calculator;

/**
 *
 * @author sirri
 */
public class Modulo implements doMath {
    public Double execute(Double input1, Double input2){
        Double moduloOutput = input1 % input2;
        return moduloOutput;
    }
}
