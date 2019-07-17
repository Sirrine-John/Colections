/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokeApp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Map;

public class testerMain {

	public static void main(String[] args) throws IOException {
		PokeAPI_JSON returnPokemon = new PokeAPI_JSON();
		JsonObject pokeShortList = new JsonObject();
		pokeShortList = returnPokemon.getPokeJSON();
		PokeHibernate addPoke = new PokeHibernate();
		for(Map.Entry<String,JsonElement> poke : pokeShortList.entrySet()){
			JsonArray singlePoke = (JsonArray)poke.getValue();
			int id = singlePoke.get(0).getAsInt();
			String name = singlePoke.get(1).getAsString();
			int height = singlePoke.get(2).getAsInt();
			int weight = singlePoke.get(3).getAsInt();
			int base_experience = singlePoke.get(4).getAsInt();
			String type_1 = singlePoke.get(5).getAsString();
			String type_2 = singlePoke.get(6).getAsString();
			String sprite_location = singlePoke.get(7).getAsString();
			addPoke.addPokemon(id, name, height, weight, base_experience, type_1, type_2, type_2, sprite_location);
			
		System.out.println();
		}
		addPoke.addPokemon("Close");
		System.out.println();
	}
	
}
