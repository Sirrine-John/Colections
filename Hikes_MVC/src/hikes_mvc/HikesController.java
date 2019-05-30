/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hikes_mvc;

import java.util.ArrayList;

/**
 *
 * @author sirri
 */
public class HikesController {
    private HikesModel hikes = new HikesModel();
    private HikesView view = new HikesView();
    HikesController(){
        this.hikes.acceptHike("Bechler Falls"
                , "3 miles"
                , "Easy"
                , "Beautiful short hike along the Bechler river to Bechler Falls"
                , "Take Highway 20 north to Ashton. Turn right into the town and continue through. Follow that road for a few miles then turn left again onto the Cave Falls road.Drive to the end of the Cave Falls road. There is a parking area at the trailhead.");
        this.hikes.acceptHike("Buck Mountain Loop"
                , "8.1 miles"
                , "Moderate"
                , "Buck Mountain Trail is a 8 mile lightly trafficked loop trail located near Silverton, Oregon that features beautiful wild flowers"
                , "From Pendleton, Oregon: Drive east for 7 miles on Interstate 84 and take Exit 216.  Go left (north) for 2 miles to the blinking 4-way stoplight.  Take a right onto Mission Road and continue onto Cayuse Road/County Road 931/Emigrant Road.  After 1.7 miles turn left onto Cayuse Road.  Travel about 16 miles to where it meets Bingham Road. Turn right onto Bingham Road/County Road 900, cross the railroad tracks, and follow Bingham Road/County Road 900 for approximately 9.5 miles.  Cross the bridge just past the Umatilla Forks Campground and take the first left onto Forest Service Road 3200-045, approximately 3/4 of a mile further.");
        this.hikes.acceptHike("Bright Angel Trail"
                , "15.6 miles"
                , "Hard"
                , "The Bright Angel Trail is the most popular trail on the South Rim of the Grand Canyon"
                , "Located on the South Rim, trail begins just west of Bright Angel Lodge. Follow path along rim, trail starts by mule corral.");
        this.hikes.acceptHike("Devils Bridge"
                , "4.2 miles"
                , "Moderate"
                , "Heavily trafficked out and back trail located near Sedona, Arizona that features beautiful wild flowers and is rated as moderate. The trail offers a number of activity options and is accessible year-round."
                , "Drive 27 miles south from Flagstaff to Sedona on US 89A. Continue through Sedona to Dry Creek Road (FR152) at the west end of town. Turn right on Dry Creek Road and drive for two miles to where FR152 forks and take the right fork (leaving the paved road). About 1.3 miles up this road, turn right to Devil\\'s Bridge Trailhead and parking lot.");
        this.hikes.acceptHike("Horseshoe Bend"
                , "1.5 miles"
                , "Easy"
                , "A very short hike off a highway takes you to the top of a cliff overlooking Horseshoe Bend and the Colorado River over 1100 feet below."
                , "Horseshoe Bend is just south of Page, Arizona. From the Glen Canyon Dam on US-89 head south for 5.1 miles. You’ll pass along the edge of Page, Arizona. At around 5 miles from the Glen Canyon Dam, you’ll see a sign for Horseshoe Bend Overlook. Turn right into parking area. If coming from the south, take US-89 north to Page, Arizona and before coming into town you’ll see a Horseshoe Bend Overlook sign. Turn left into the parking lot.");
        
//        System.out.println(this.requestHikeSingle("Devils Bridge"));
//        System.out.println(this.requestHikeListSimple());        
//        System.out.println(this.requestHikeListFull());
//        this.addNewHike("test", "far", "rediculous", "Boring and long", "Two Lefts, A Right, and a Left");
//        System.out.println(this.requestHikeSingle("test"));
//        System.out.println(this.requestHikeListSimple());
//        this.removeHike("test");
//        System.out.println(this.requestHikeListSimple());
//        System.out.println(this.requestHikeSingle("test"));
        
        this.showMenu();
        
        
    }
    private void showMenu(){
        requestHandle(this.view.showMenu());
    }
    private void requestHandle(String request){
        ArrayList<String> out = new ArrayList<>();
        switch(request){
            case "H":
                out = this.requestHikeListSimple();
                this.view.printOutput(out);
                break;
            case "I":
                this.keyHandle(request, this.view.keyPrompt());
                break;
            case "A":
                this.addHandle(this.view.addPrompt());
                break;
            case "D":
                this.keyHandle(request, this.view.keyPrompt());
                break;
            case "S":
                out = this.requestHikeListFull();
                this.view.printOutput(out);
                break;
            case "E":
                this.view.exit();
                break;
            default:
                break;
        }
        this.showMenu();
    }
    private void keyHandle(String request, String key){
        ArrayList<String> out = new ArrayList<>();
        switch(request){
            case "I":
                this.view.printOutput(this.requestHikeSingle(key));
                break;
            case "D":
                out.add("Request made to remove "+key);
                this.removeHike(key);
                this.view.printOutput(out);
                break;
            default:{
                out.add("Invalid Entry");
                this.view.printOutput(out);
                break;
            }
        }
        this.showMenu();
    }
    private void addHandle(ArrayList newHike){
        this.addNewHike(newHike.get(0).toString(), newHike.get(1).toString(), newHike.get(2).toString(), newHike.get(3).toString(), newHike.get(4).toString());
        this.showMenu();
    }
    
    public ArrayList requestHikeSingle(String key){
        ArrayList<String> out;
        out = this.hikes.getHike(key);
        if (out == null){
            ArrayList<String> err = new ArrayList<>();
            err.add("No such item");
            return err;
        }
        else{
            return out;
        }
    }
    public ArrayList requestHikeListSimple(){
        ArrayList<String> out;
        out = this.hikes.getHikeSimple();
        if (out == null){
            ArrayList<String> err = new ArrayList<>();
            err.add("No such Item");
            return err;
        }
        else{
            return out;        
        }

    }
    public ArrayList requestHikeListFull(){
        ArrayList<ArrayList<String>> out;
        out = this.hikes.getHikeAll();
        if (out == null){
            ArrayList<ArrayList<String>> sub1 = new ArrayList<>();
            ArrayList<String> sub2 = new ArrayList<>();
            sub2.add("NONE");
            sub1.add(sub2);
            return sub1;
        }
        else{
            return out;        
        }

    }
    public void addNewHike(String name,String distance, String difficulty, String description, String directions){
        this.hikes.acceptHike(name, distance, difficulty, description, directions);
    }
    public void removeHike(String name){
        this.hikes.deleteHike(name);
    }
    
    
}
