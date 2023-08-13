package com.softserve.edu.finalproject;

import com.softserve.edu.finalproject.character.GameCharacter;
import com.softserve.edu.finalproject.constants.GameWindows;
import com.softserve.edu.finalproject.enemy.Enemy;
import com.softserve.edu.finalproject.locations.Area;
import com.softserve.edu.finalproject.services.KeyEventsHandler;

public class DungeonRunner {
    public static GameCharacter player;
    public static Area location;
    public static Enemy enemy;

    public static void main(String[] args) {
        KeyEventsHandler keyEventsHandler = new KeyEventsHandler();
        Thread inputThread = new Thread(keyEventsHandler);
        inputThread.start();
        System.out.println("\033[107m\033[30m"); // BACKGORUND CHANGE CODE
        GameWindows.mainWindow();
        try {
            inputThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
