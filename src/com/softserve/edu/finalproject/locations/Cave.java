package com.softserve.edu.finalproject.locations;

import java.util.Random;
import static com.softserve.edu.finalproject.constants.NamesAndTitles.caveNames;


public class Cave extends Area{
    public Cave(){
        Random random = new Random();
        int chosenName = random.nextInt(10);
        this.setLocationName(caveNames[chosenName]);
    }

    @Override
    public String toString() {
        return "You are in the Cave " + super.toString();
    }
}
