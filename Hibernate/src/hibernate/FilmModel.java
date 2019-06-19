/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.time.Year;
import java.time.LocalDate;
import org.hibernate.*;
import javax.persistence.*;

/**
 *
 * @author sirri
 */
@Entity
@Table(name="newfilm")
public class FilmModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="film_id")
	private int film_id = 0;
    @Column(name="title")
    private String title = null;
    @Column(name="description")
    private String description = null;
    @Column(name="release_year")
    private int release_year = 0;
    @Column(name="rental_rate")
    private double rental_rate = 0.00;
    @Column(name="length")
    private int length = 0;
    @Column(name="replacement_cost")
    private double replacement_cost = 0.00;
	
	FilmModel() {}
	
	FilmModel(String title,String description,int release_year,double rental_rate,int length,double replacement_cost){
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
	}

	
	public int getFilm_Id() {return film_id;}
	public void setFilm_Id(int film_id) {this.film_id = film_id;}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	public int getRelease_Year() {return release_year;}
	public void setRelease_Year(int release_year) {this.release_year = release_year;}
	
	public double getRental_Rate() {return rental_rate;}
	public void setRental_Rate(double rental_rate) {this.rental_rate = rental_rate;}
	
	public double getReplacement_Cost() {return replacement_cost;}
	public void setReplacement_Cost(double replacement_cost) {this.replacement_cost = replacement_cost;}
	
	public String toString(){
		return (getFilm_Id()+" : "+getTitle()+" : "+getDescription()+" : "+
				getRelease_Year()+" : "+getRental_Rate()+" : "+getReplacement_Cost());
	}
    
}
