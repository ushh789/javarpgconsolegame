package com.softserve.edu.finalproject.locations;

import java.util.Random;
import static com.softserve.edu.finalproject.constants.NamesAndTitles.townNames;

public class Town extends Area{
    public Town(){
        Random random = new Random();
        int chosenName = random.nextInt(10);
        this.setLocationName(townNames[chosenName]);
    }
    @Override
    public void explore(Character character) {

    }
    @Override
    public String toString() {
        return "You are in the Town " + super.toString();
    }
}
