/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokeApp;


//import com.mysql.jdbc.Blob;
import java.sql.Blob;
import javax.persistence.*;
@Entity
@Table(name="pokemon")
public class PokemonModel {
	@Id
	@Column(name="poke_id")
	private int poke_id;
	@Column(name="name")
	private String name;
	@Column(name="height")
	private int height;
	@Column(name="weight")
	private int weight;
	@Column(name="base_experience")
	private int base_experience;
	@Column(name="type_1")
	private String type_1;
	@Column(name="type_2")
	private String type_2;
	@Column(name="species")
	private String species;
	@Column(name="sprite")
	private Blob sprite;
	@Column(name="sprite_api_location")
	private String sprite_api_location;
	
	PokemonModel(){}
	
	PokemonModel(int poke_id, String name, int height, int weight, int base_experience,
				String type_1, String type_2, String species, Blob sprite, String sprite_api_location){
		this.poke_id = poke_id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.base_experience = base_experience;
		this.type_1 = type_1;
		this.type_2 = type_2;
		this.species = species;
		this.sprite = sprite;
		this.sprite_api_location = sprite_api_location;
	}
	
	public int getPoke_Id(){return this.poke_id;};
	public String getName(){return this.name;};
	public int getHeight(){return this.height;};
	public int getWeight(){return this.weight;};
	public int getBaseExperience(){return this.base_experience;};
	public String getType1(){return this.type_1;};
	public String getType2(){return this.type_2;};
	public String getSpecies(){return this.species;};
	public Blob getSprite(){return this.sprite;};
	public String getSpriteApiLocation(){return this.sprite_api_location;};
	
		
	public void setPoke_Id(int poke_id){this.poke_id = poke_id;};
	public void setName(String name){this.name = name;};
	public void setHeight(int height){this.height = height;};
	public void setWeight(int weight){this.weight = weight;};
	public void setBaseExperience(int base_experience){this.base_experience = base_experience;};
	public void setType1(String type_1){this.type_1 = type_1;};
	public void setType2(String type_2){this.type_2 = type_2;};
	public void setSpecies(String species){this.species = species;};
	public void setSprite(Blob sprite){this.sprite = sprite;};
	public void setSpriteApiLocation(String sprite_api_location){this.sprite_api_location = sprite_api_location;};
	
}
