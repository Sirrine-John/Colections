/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colections;
import java.util.TreeMap;

public class Trees {
    TreeMap<String,String> internalTree = new TreeMap<>();
    public void add(String key,String value){
        internalTree.put(key,value);
    }
    public TreeMap print(){
        return internalTree;
    }
}