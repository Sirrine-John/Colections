/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_controller_pattern_calculator;

/**
 *
 * @author sirri
 */
public class Subtraction implements doMath {
        public Double execute(Double input1, Double input2){
        Double subtraction = input1 - input2;
        return subtraction;
    }
}
