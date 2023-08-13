package src.com.softserve.edu.finalproject.locations;

import java.util.Random;
import static src.com.softserve.edu.finalproject.constants.NamesAndTitles.caveNames;


public class Cave extends Area{
    Cave(){
        Random random = new Random();
        int chosenName = random.nextInt(10);
        this.setLocationName(caveNames[chosenName]);
    }

    @Override
    public void explore(Character character) {

    }
}
