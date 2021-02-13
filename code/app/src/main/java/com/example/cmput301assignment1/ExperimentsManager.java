package com.example.cmput301assignment1;
// Class ExperimentManager
// Purpose: It makes the array list of experiments
// Design Rationale: This is a singleton so that any class can access it and modify it
/* CITATION
Abram Hindle, "Course Discussion"
 2021-01-18, Public Domain, https://eclass.srv.ualberta.ca/mod/forum/discuss.php?d=1611626#p4237308
 */

import java.util.ArrayList;

public class ExperimentsManager extends ArrayList<Experiments> {
    //Singleton ArrayList
    private ArrayList<Experiments> experimentsDataList;
    private ExperimentsManager(){
        experimentsDataList = new ArrayList<>();
    }
    public ArrayList<Experiments> getExperimentsDataList(){
        return experimentsDataList;
    }
    private static ExperimentsManager singleton;
    public static ExperimentsManager getInstance(){
        if(singleton ==null){
            singleton = new ExperimentsManager();
        }
        return singleton;
    }

}


