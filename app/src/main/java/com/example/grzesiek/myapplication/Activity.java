package com.example.grzesiek.myapplication;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by grzesiek on 19.02.16.
 */
public class Activity {
    Category category;
    Date beginning;
    Date ending;
    String tags;
    //ArrayList <String> tags;

    Activity(Category category, Date beginning, Date ending, String tags){
        this.category = category;
        this.beginning = beginning;
        this.ending = ending;
        this.tags = tags;
    }
}