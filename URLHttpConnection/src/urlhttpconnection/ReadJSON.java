/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlhttpconnection;

/**
 *
 * @author sirri
 */
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJSON
{
    @SuppressWarnings("unchecked")
    public void reader(String pokemonJSON)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (StringReader reader = new StringReader(pokemonJSON))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray pokemonList = new JSONArray();
            pokemonList.add(obj);
            System.out.println(pokemonList);
             
            //Iterate over employee array
            pokemonList.forEach( poke -> parsePokemonObject( (JSONObject) poke ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private void parsePokemonObject(JSONObject pokemon)
    {
        //Get employee object within list
        JSONObject pokemonObject = new JSONObject();
        pokemonObject.get(pokemon.get("pokemon"));
         
        //Get employee first name
        String num = (String) pokemonObject.get("num");   
        System.out.println(num);
         
        //Get employee last name
        String name = (String) pokemonObject.get("name"); 
        System.out.println(name);
         
        //Get employee website name
        String height = (String) pokemonObject.get("height");   
        System.out.println(height);
        
//Get employee website name
        String weight = (String) pokemonObject.get("weight");   
        System.out.println(weight);
    }
}