/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit_testing;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author sirri
 */
public class JUnit_Testing_Main {

	public static void main(String[] args) {
		JUnit_Do_Work worker = new JUnit_Do_Work();
		System.out.println(worker.lowMax50(50));
		System.out.println(worker.lowMax50(49));
		System.out.println(worker.evenOdd(50));
		System.out.println(worker.evenOdd(51));
		System.out.println(Arrays.toString(worker.personArray("John","Sirrine","31")));
		System.out.println(worker.createObject("N", "John", "Sirrine", "31"));
		System.out.println(worker.createObject("Y", "John", "Sirrine", "31"));
		System.out.println(worker.sameCheck("N", "1"));
		System.out.println(worker.sameCheck("Y", "1"));
	}
}
