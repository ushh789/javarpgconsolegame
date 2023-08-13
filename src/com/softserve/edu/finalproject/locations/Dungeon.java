package src.com.softserve.edu.finalproject.locations;

import java.util.Random;
import static src.com.softserve.edu.finalproject.constants.NamesAndTitles.dungeonNames;

public class Dungeon extends Area{
    Dungeon(){
        Random random = new Random();
        int chosenName = random.nextInt(10);
        this.setLocationName(dungeonNames[chosenName]);
    }
    @Override
    public void explore(Character character) {

    }
}
