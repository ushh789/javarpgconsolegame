package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.character.Characters;
import com.softserve.edu.finalproject.character.Mage;
import com.softserve.edu.finalproject.character.Priest;
import com.softserve.edu.finalproject.character.Rogue;
import com.softserve.edu.finalproject.character.Warrior;
import com.softserve.edu.finalproject.constants.GameWindows;
import com.softserve.edu.finalproject.constants.Windows;

import java.io.IOException;

import static com.softserve.edu.finalproject.DungeonRunner.player;

public class KeyEventsHandler implements Runnable {
    private Windows currentWindow = Windows.MAIN;

    @Override
    public void run() {
        while (true) {
            try {
                int key = System.in.read();

                handleKey(key);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleKey(int key) throws IOException, InterruptedException {
        String tempName = null;
        if(key == 'q') GameEvents.quit();

        if(currentWindow == Windows.MAIN) {
            switch (key) {
                case '1' -> {
                    GameEvents.clearCLI();
                    currentWindow = Windows.START;
                    GameWindows.startGame();
                }
                case '2' -> {
                    GameEvents.clearCLI();
                    currentWindow = Windows.LOAD;
                    GameWindows.loadWindow();
                }
                case '3' -> GameEvents.quit();
            }
        } else if (currentWindow == Windows.LOAD) {
            switch (key) {
                case '1' -> {
                    GameEvents.clearCLI();
                    currentWindow = Windows.START;
                    tempName = GameWindows.startGame();
                }
                case '2' -> {
                    GameEvents.clearCLI();
                    currentWindow = Windows.START;
                    tempName = GameWindows.startGame();
                }
                case '3' -> GameEvents.quit();
            }
        } else if (currentWindow == Windows.START) {
            switch (key) {
                case '1' -> player = new Mage(tempName, Characters.MAGE);
                case '2' -> player = new Priest(tempName, Characters.PRIEST);
                case '3' -> player = new Rogue(tempName, Characters.ROGUE);
                case '4' -> player = new Warrior(tempName, Characters.WARRIOR);
            }
            GameEvents.clearCLI();
            GameWindows.createdWindow();
            currentWindow = Windows.CREATED;
        } else if (currentWindow == Windows.CREATED) {
            switch (key) {
                case '1' -> {
                    //continue
                }
                case '2' -> GameEvents.quit();
            }
        }
    }
}
