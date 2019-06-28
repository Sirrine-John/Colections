package junit_testing;

import java.util.ArrayList;

public class JUnit_Do_Work {
	
	public boolean lowMax50(int test){
		if (test >= 50){
			return false;
		}
		else{
			return true;
		}
	}
	public String[] personArray(String first,String last,String age){
		String[] outputArray = {first,last,age};
		return outputArray;
	}
	public String evenOdd(int input){
		if (input % 2 == 0){
			return "Even";
		}
		else{
			return "Odd";
		}
	}
	
	public String sameCheck(String intConv,String input){
		if (intConv == "Y"){
			try{
				Integer.parseInt(input);
				return "ONE";
			}
			catch(Exception e){
				return "Not int";
			}
		}
		else{
			return input;
		}
	}
	
	public ArrayList createObject(String fill, String first, String last, String age){
		ArrayList personObj = new ArrayList();
		if (fill == "Y"){
			personObj.add(first);
			personObj.add(last);
			personObj.add(age);
			return personObj;
		}
		else{
			personObj = null;
			return personObj;
		}
	}
}
