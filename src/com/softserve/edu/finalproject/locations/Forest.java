package com.softserve.edu.finalproject.locations;

import java.util.Random;
import static com.softserve.edu.finalproject.constants.NamesAndTitles.forestNames;

public class Forest extends Area{
    public Forest(){
        Random random = new Random();
        int chosenName = random.nextInt(10);
        this.setLocationName(forestNames[chosenName]);
    }
    @Override
    public void explore(Character character) {

    }
    @Override
    public String toString() {
        return "You are in the Forest " + super.toString();
    }
}
