/
package json_files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author sirri
 */
public class JSON_files {
	
    @SuppressWarnings("unchecked")
	private static JSONArray familyMembers = new JSONArray();
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(".\\src\\json_files\\JSON_text.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray familyList = (JSONArray) obj;
            System.out.println(familyList);
             
            //Iterate over array
            familyList.forEach( fam -> parseJSONObject( (JSONObject) fam ) );
			
			//Write JSON Object to file
//			try (FileWriter file = new FileWriter(".\\src\\json_files\\family.json")) {
			try (FileWriter file = new FileWriter(".\\src\\json_files\\JSON_text.json")) {
				System.out.println(familyMembers.toJSONString());
				file.write(familyMembers.toJSONString());
				file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseJSONObject(JSONObject object)
    {
        JSONObject jsonObject = (JSONObject) object.get("familyMember");
        String firstName = (String) jsonObject.get("firstName");  
        String lastName = (String) jsonObject.get("lastName"); 
        String relationship = (String) jsonObject.get("relationship");  
        String age = (String) jsonObject.get("age");  
		
		writeToNewObject(firstName,lastName,relationship,age);
        System.out.println(firstName+" "+lastName+": "+relationship+": AGE: "+age);
    }
	
	private static void writeToNewObject(String first, String last, String rel, String age){
		JSONObject member = new JSONObject();
		member.put("firstName",first);
		member.put("lastName",last);
		member.put("relationship",rel);
		member.put("age",age);
        JSONObject familyObject = new JSONObject();
        familyObject.put("familyMember", member);
		familyMembers.add(familyObject);
	}
}