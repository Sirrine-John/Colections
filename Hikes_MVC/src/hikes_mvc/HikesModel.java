/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hikes_mvc;


import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author sirri
 */
public class HikesModel {
    ArrayList hikeDetails = new ArrayList();
    HikesModel(){};    
    HikesModel(String name,String distance, String difficulty, String description, String directions){
    hikeDetails.add(name);
    hikeDetails.add(distance);
    hikeDetails.add(difficulty);
    hikeDetails.add(description);
    hikeDetails.add(directions);
    insertHike(hikeDetails);
};
   
    private HashMap<String,ArrayList> Hikes = new HashMap<>();


    
    public void acceptHike(String name, String distance, String difficulty,String description, String directions){
        ArrayList newHike = new ArrayList();
        newHike.add(name);
        newHike.add(distance);
        newHike.add(difficulty);
        newHike.add(description);
        newHike.add(directions);
        insertHike(newHike);
    };
    
    private void insertHike (ArrayList currentHike){
        this.Hikes.put(currentHike.get(0).toString(), currentHike);
    };
    
    public ArrayList getHike (String key){
        return this.Hikes.get(key);
    };
    public ArrayList getHikeAll(){
        ArrayList results = new ArrayList();
        for (String key : this.Hikes.keySet()){
            results.add(this.Hikes.get(key));
        }
        return results;
    }
    public ArrayList getHikeSimple(){
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        ArrayList<String> resultsSimple = new ArrayList<>();
        for (String key : this.Hikes.keySet()){
            results.add(this.Hikes.get(key));
        }
        for (int i =0; i < results.size(); i++){
            resultsSimple.add(results.get(i).get(0));
        }
        return resultsSimple;
    }
    public void deleteHike(String key){
        this.Hikes.remove(key);
    }
    
    
}
