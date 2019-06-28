package junit_testing;

import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

public class JUnit_Do_WorkTest {
	JUnit_Do_Work instance = new JUnit_Do_Work();

	@Test
	public void testLowMax50() {
		System.out.println("Module: lowMax50");
		int testFalse = 50;
		int testTrue = 49;
		boolean resultFalse = instance.lowMax50(testFalse);
		boolean resultTrue = instance.lowMax50(testTrue);
		System.out.println(resultFalse);
		assertFalse("This should be False", resultFalse);
		System.out.println(resultTrue);
		assertTrue("This should be True", resultTrue);
	}

	@Test
	public void testPersonArray() {
		System.out.println("Module: personArray");
		String first = "John";
		String last = "Sirrine";
		String age = "31";
		String[] expResult = {first,last,age};
		String[] result = instance.personArray(first, last, age);
		System.out.println(Arrays.toString(expResult)+" ~~ "+ Arrays.toString(result));
		assertArrayEquals(expResult, result);
	}

	@Test
	public void testEvenOdd() {
		System.out.println("Module: evenOdd");
		int inputEven = 50;
		String evenResult = "Even";
		String resultEven = instance.evenOdd(inputEven);
		System.out.println(evenResult+ " ~~ " +resultEven);
		assertThat(resultEven, is(evenResult));
		int inputOdd = 51;
		String oddResult = "Odd";
		String resultOdd = instance.evenOdd(inputOdd);
		System.out.println(oddResult+ " ~~ " +resultOdd);
		assertThat(resultOdd, is(oddResult));
	}
	
	@Test
	public void testSameCheck(){
		System.out.println("Module: sameCheck");
		String string1 = new String();
		string1 = "1";
		String string2 = new String();
		string2 = "1";
		String sameResult = instance.sameCheck("N",string1);
		String notSameResult = instance.sameCheck("Y",string2);
		System.out.println("Same: "+sameResult+" ~~ "+sameResult);
		System.out.println("Not Same: "+sameResult+" ~~ "+notSameResult);
		assertSame(sameResult,sameResult);
		assertNotSame(sameResult,notSameResult);
	}
	
	@Test
	public void testCreateObject(){
		System.out.println("Module: createObject");
		ArrayList nullResult = new ArrayList();
		ArrayList notNullResult = new ArrayList();
		nullResult = instance.createObject("N", "John", "Sirrine", "31");
		notNullResult = instance.createObject("Y", "John", "Sirrine", "31");
		System.out.println("Null Result = "+nullResult);
		System.out.println("Not Null Result = "+notNullResult);
		assertNull(nullResult);
		assertNotNull(notNullResult);
	}
	
}
