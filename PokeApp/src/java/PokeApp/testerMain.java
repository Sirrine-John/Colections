/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokeApp;

import org.json.simple.JSONObject;

/**
 *
 * @author sirri
 */
public class testerMain {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
//		PokeHibernate myPokeSet = new PokeHibernate();
//		myPokeSet.addPokemon(1, "Bulbasaur", 25, 30, 75, "Grass", null, "bulbasaur", null, "http://pokeapi/v2/imagelocation");
		PokeAPI_JSON returnPokemon = new PokeAPI_JSON();
		JSONObject pokeShortList = new JSONObject();
		pokeShortList = returnPokemon.trimPokeCollection();
		System.out.println();
	}
	
}
