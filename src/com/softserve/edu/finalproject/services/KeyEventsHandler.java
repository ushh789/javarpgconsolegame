package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.character.*;
import com.softserve.edu.finalproject.constants.*;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static com.softserve.edu.finalproject.DungeonRunner.enemy;
import static com.softserve.edu.finalproject.DungeonRunner.player;
import static com.softserve.edu.finalproject.constants.GameWindows.characterPreviewWindow;

public class KeyEventsHandler implements Runnable {
    private Windows currentWindow = Windows.MAIN;
    private String tempName = null;
    private String currentPath = null;
    private FightEvents fe;
    private SaveEvents se;
    private File chosenSave;

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
            }
        } else if (currentWindow == Windows.LOAD) {
            se = new SaveEvents();
            File[] saves = se.loadOptions();
            try {
                GameWindows.loadWindow();
                chosenSave = saves[Integer.parseInt(key)];
                if (Integer.parseInt(key) >= 0 && Integer.parseInt(key) < saves.length) {
                    player = se.loadPlayer(chosenSave);
                    characterPreviewWindow();
                    enemy = se.loadEnemy(chosenSave);
                    currentWindow = se.loadCurrentWindow(chosenSave);
                }

//                if (enemy != null && currentWindow == Windows.CONTINUE) {
//                    currentWindow = Windows.CONTINUE_FIGHT;
//                    //GameWindows.startFightStageWindow();
//                    GameWindows.continueFightStageWindow(fe);
//                } else {
//                    GameWindows.continueWindow();
//                    currentWindow = Windows.CONTINUE;
//                }

                if (currentWindow == Windows.CONTINUE) {
                    GameWindows.continueWindow();
                } else if (currentWindow == Windows.FIGHT) {
                    System.out.println(GameConstants.TEXT_COLOR_RED + GameConstants.FIGHT + GameConstants.RESET);
                    fe = new FightEvents(player, enemy);
                    GameWindows.startFightStageWindow();
                    fe.fightOptions();
                    GameWindows.endFightStageWindow();
                } else if (currentWindow == Windows.CONTINUE_FIGHT) {
                    System.out.println(GameConstants.TEXT_COLOR_RED + GameConstants.FIGHT + GameConstants.RESET);
                    fe = new FightEvents(player, enemy);
                    GameWindows.continueFightStageWindow(fe);
                    GameWindows.continueWindow();
                }
            } catch (NumberFormatException e) {
                System.err.println("There isn't any save with that number! Try again.");
                currentWindow = Windows.LOAD;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("There isn't any save with that number! Try again.");
                currentWindow = Windows.LOAD;
            }
        } else if (currentWindow == Windows.START) {
            switch (key) {
                case "1" -> player = new Mage(tempName, Characters.MAGE);
                case "2" -> player = new Priest(tempName, Characters.PRIEST);
                case "3" -> player = new Rogue(tempName, Characters.ROGUE);
                case "4" -> player = new Warrior(tempName, Characters.WARRIOR);
            }
            if (player != null) {
                GameEvents.clearCLI();
                GameWindows.characterPreviewWindow();
                GameWindows.continueWindow();
                currentWindow = Windows.CONTINUE;
            }
        } else if (currentWindow == Windows.CONTINUE) {
            switch (key) {
                case "1" -> {
                    Windows tempRoom = GameEvents.generate();
                    if (tempRoom == Windows.START) {
                        GameEvents.clearCLI();
                        GameWindows.continueWindow();
                    } else if (tempRoom == Windows.FIGHT) {
                        System.out.println(GameConstants.TEXT_COLOR_RED + GameConstants.FIGHT + GameConstants.RESET);
                        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.ITALIC + enemy + GameConstants.RESET);
                        currentWindow = Windows.CONTINUE_FIGHT;
                        player.setAbilityAvailable(!player.isAbilityAvailable());
                        GameWindows.continueWindow();
                    }
                }
                case "2" -> {
                    SaveEvents saveEvents = new SaveEvents();
                    if(chosenSave != null) saveEvents.delete(chosenSave.getName());
                    saveEvents.save(Optional.empty(), player, enemy, this, currentWindow);
                    GameEvents.quit();
                }
            }

        } else if (currentWindow == Windows.CONTINUE_FIGHT) {
            switch (key) {
                case "1" -> {
                    if (enemy.getHealth() <= 0) {
                        GameWindows.winFightWindow();
                        System.out.print(GameConstants.TEXT_COLOR_CYAN + "[MANA] " + player.getMana());
                        player.increaseMana(50);
                        System.out.print(" -> " + player.getMana() + GameConstants.RESET + "\n");
                        currentWindow = Windows.CONTINUE;
                        GameWindows.continueWindow();
                        break;
                    } else if (player.getHealth() <= 0) {
                        GameWindows.lostFightWindow();
                        currentWindow = Windows.CONTINUE;
                        SaveEvents saveEvents = new SaveEvents();
                        saveEvents.delete(currentPath);
                        GameEvents.quit();
                        break;
                    }

                    fe = new FightEvents(player, enemy);
                    GameWindows.startFightStageWindow();
                    fe.fightOptions();
                    GameWindows.endFightStageWindow();
                    currentWindow = Windows.FIGHT;
                }
                case "2" -> {
                    SaveEvents saveEvents = new SaveEvents();
                    if(chosenSave != null) saveEvents.delete(chosenSave.getName());
                    saveEvents.save(Optional.empty(), player, enemy, this, currentWindow);
                    GameEvents.quit();
                }
            }
        } else if (currentWindow == Windows.FIGHT) {
            switch (key) {
                case "1" -> {
                    fe.attackOption();
                    fe.botOptions();
                    GameWindows.continueFightStageWindow(fe);
                    GameWindows.continueWindow();
                    currentWindow = Windows.CONTINUE_FIGHT;
                }
                case "2" -> {
                    fe.healOption();
                    fe.botOptions();
                    GameWindows.continueFightStageWindow(fe);
                    GameWindows.continueWindow();
                    currentWindow = Windows.CONTINUE_FIGHT;
                }
                case "3" -> {
                    if (fe.abilityOption()) {
                        fe.botOptions();
                        GameWindows.continueFightStageWindow(fe);
                        GameWindows.continueWindow();
                        currentWindow = Windows.CONTINUE_FIGHT;
                    }
                }
                case "4" -> {
                    SaveEvents saveEvents = new SaveEvents();
                    if(chosenSave != null) saveEvents.delete(chosenSave.getName());
                    saveEvents.save(Optional.empty(), player, enemy, this, currentWindow);
                    GameEvents.quit();
                }
            }
        }
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }
}
