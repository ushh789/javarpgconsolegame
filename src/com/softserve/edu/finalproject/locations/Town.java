package src.com.softserve.edu.finalproject.locations;

import java.util.Random;
import static src.com.softserve.edu.finalproject.constants.NamesAndTitles.townNames;

public class Town extends Area{
    Town(){
        Random random = new Random();
        int chosenName = random.nextInt(10);
        this.setLocationName(townNames[chosenName]);
    }
    @Override
    public void explore(Character character) {

    }
}
