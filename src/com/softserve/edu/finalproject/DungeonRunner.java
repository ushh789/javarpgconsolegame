package com.softserve.edu.finalproject;

import com.softserve.edu.finalproject.character.GameCharacter;
import com.softserve.edu.finalproject.constants.GameWindows;
import com.softserve.edu.finalproject.services.KeyEventsHandler;

public class DungeonRunner {
    public static GameCharacter player;

    public static void main(String[] args) {
        KeyEventsHandler keyEventsHandler = new KeyEventsHandler();
        Thread inputThread = new Thread(keyEventsHandler);
        inputThread.start();

        GameWindows.mainWindow();

        try {
            inputThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
