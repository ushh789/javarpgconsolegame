package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.character.*;
import com.softserve.edu.finalproject.constants.*;

import java.io.IOException;
import java.util.Objects;

import static com.softserve.edu.finalproject.DungeonRunner.enemy;
import static com.softserve.edu.finalproject.DungeonRunner.player;

public class KeyEventsHandler implements Runnable {
    private Windows currentWindow = Windows.MAIN;
    private String tempName = null;

    @Override
    public void run() {
        while (true) {
            try {
                String key = GameConstants.sc.nextLine();
                handleKey(key);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleKey(String key) throws IOException, InterruptedException {
        if (Objects.equals(key, "q")) GameEvents.quit();
        if (currentWindow == Windows.MAIN) {

            switch (key) {
                case "1" -> {
                    GameEvents.clearCLI();
                    currentWindow = Windows.START;
                    tempName = GameWindows.startGame();
                }
                case "2" -> {
                    GameEvents.clearCLI();
                    currentWindow = Windows.LOAD;
                    GameWindows.loadWindow();
                }
                case "3" -> GameEvents.quit();
            }
        } else if (currentWindow == Windows.LOAD) {
            switch (key) {
                case "1" -> {
                    GameEvents.clearCLI();
                    currentWindow = Windows.START;
                    tempName = GameWindows.startGame();
                }
                case "2" -> {
                    GameEvents.clearCLI();
                    currentWindow = Windows.START;
                    tempName = GameWindows.startGame();
                }
                case "3" -> GameEvents.quit();
            }
        } else if (currentWindow == Windows.START) {
            switch (key) {
                case "1" -> player = new Mage(tempName, Characters.MAGE);
                case "2" -> player = new Priest(tempName, Characters.PRIEST);
                case "3" -> player = new Rogue(tempName, Characters.ROGUE);
                case "4" -> player = new Warrior(tempName, Characters.WARRIOR);
            }
            GameEvents.clearCLI();
            GameWindows.characterPreviewWindow();
            currentWindow = Windows.CONTINUE;
        }  else if (currentWindow == Windows.CONTINUE) {
            switch (key) {
                case "1" -> {
                    Windows tempRoom = GameEvents.generate();
                    if (tempRoom == Windows.START){
                        GameEvents.clearCLI();
                        GameWindows.continueWindow();
                    } else if (tempRoom == Windows.FIGHT) {
                        System.out.println(GameConstants.TEXT_COLOR_RED + GameConstants.FIGHT + GameConstants.RESET);
                        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.ITALIC + enemy + GameConstants.RESET);
                        GameWindows.continueWindow();
                    }
                }
                case "2" -> GameEvents.quit();
            }

        }
    }
}
