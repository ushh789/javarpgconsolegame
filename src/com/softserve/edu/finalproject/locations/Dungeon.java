package com.softserve.edu.finalproject.locations;

import java.util.Random;
import static com.softserve.edu.finalproject.constants.NamesAndTitles.dungeonNames;

public class Dungeon extends Area{
    public Dungeon(){
        Random random = new Random();
        int chosenName = random.nextInt(10);
        this.setLocationName(dungeonNames[chosenName]);
    }

    @Override
    public String toString() {
        return "You are in the Dungeon " + super.toString();
    }
}
