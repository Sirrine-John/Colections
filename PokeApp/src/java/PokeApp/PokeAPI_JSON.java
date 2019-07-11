package PokeApp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

public class PokeAPI_JSON {
	
	public static JSONObject pokeCollection = new JSONObject();
	private JSONObject trimmedPokeCollection = new JSONObject();
	@SuppressWarnings("unchecked")
	
	public void getPokeJSON(){
		int totalPokeCount;
		String nextPage;
		double totalPages;
		try{
			PokeAPI_Connection connection = new PokeAPI_Connection("https://pokeapi.co/api/v2/pokemon-species/","GET");
			JSONObject initialFetch = new JSONObject();
			connection.run();
			initialFetch = connection.getResults();
			totalPokeCount = Integer.parseInt(initialFetch.get("count").toString());
//			nextPage = initialFetch.get("next").toString();
//			totalPages = Math.ceil(totalPokeCount/20.0);
//			System.out.println("Starting loop for "+totalPages+" pages.");
//			for(int i=0;i<totalPokeCount;i++){
			for(int i=0;i<99;i++){
				int currentPokeNum = i+1;
				PokeAPI_Connection individualConnection = new PokeAPI_Connection("https://pokeapi.co/api/v2/pokemon/"+currentPokeNum+"/", "GET");
//				JSONObject pokeFetch = new JSONObject();
				Thread retrevalThread = new Thread(individualConnection);
				retrevalThread.start();
				//pokeFetch = individualConnection.getResults();
				//pokeCollection.put(currentPokeNum,pokeFetch);
				if((currentPokeNum % 100) == 0){
					System.out.println("Waiting for 1 minute to continue fetching data.");
					TimeUnit.MINUTES.sleep(1);
					
					System.out.println();
				}
			};
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public JSONObject trimPokeCollection(){
		getPokeJSON();
		JSONObject newPokeCollection = new JSONObject();
		for(int i =0;i<pokeCollection.size();i++){
			JSONObject singlePokemon = new JSONObject();
			singlePokemon.putAll((Map)pokeCollection.get(i+1));
			JSONArray pokeInfo = new JSONArray();
			pokeInfo.add(singlePokemon.get("id"));
			pokeInfo.add(singlePokemon.get("name"));
			pokeInfo.add(singlePokemon.get("height"));
			pokeInfo.add(singlePokemon.get("weight"));
			pokeInfo.add(singlePokemon.get("base_experience"));
			pokeInfo.add(singlePokemon.get("types"));
			pokeInfo.add(singlePokemon.get("sprites"));
			newPokeCollection.put(i, pokeInfo);
		}
		return newPokeCollection;
		
	}
	
}
