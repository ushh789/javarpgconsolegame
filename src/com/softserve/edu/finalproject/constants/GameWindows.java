package com.softserve.edu.finalproject.constants;


import com.softserve.edu.finalproject.character.Characters;

import static com.softserve.edu.finalproject.DungeonRunner.enemy;
import static com.softserve.edu.finalproject.DungeonRunner.player;

public class GameWindows {
    public static String name;

    public static void mainWindow() {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.GAME_TITLE + GameConstants.RESET);
        System.out.println(GameConstants.BOLD + "Select an option:" + GameConstants.RESET);
        System.out.println("[1] New game");
        System.out.println("[2] Load game");
        System.out.println("[3] Save and quit...\n");
        System.out.println(GameConstants.ITALIC + "Enter \"q\" in any moment to quit from game without saving progress." + GameConstants.RESET);
    }

    public static void loadWindow() {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.LOAD_TITLE + GameConstants.RESET);
        System.out.println(GameConstants.BOLD + "Select an option:" + GameConstants.RESET);
        System.out.println("[1] Load game #1");
        System.out.println("[2] Load game #2");
        System.out.println("[3] Save and quit...\n");
    }

    public static String startGame() {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.START_TITLE + GameConstants.RESET);
        System.out.print(GameConstants.BOLD + "Enter your name: " + GameConstants.RESET + GameConstants.TEXT_COLOR_CYAN);
        name = GameConstants.sc.nextLine();
        System.out.println(GameConstants.RESET + GameConstants.BOLD + "Choose your character type:" + GameConstants.RESET);
        System.out.println("[1] Mage");
        System.out.println("[2] Priest");
        System.out.println("[3] Rogue");
        System.out.println("[4] Warrior");

        return name;
    }

    public static void continueWindow() {
        System.out.println(GameConstants.BOLD + "\nSelect an option:" + GameConstants.RESET);
        System.out.println("[1] Continue");
        System.out.println("[2] Save and quit");
    }

    public static void characterPreviewWindow() {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + player + "\n" + GameConstants.RESET);

        System.out.println(GameConstants.BOLD + "Select an option:" + GameConstants.RESET);
        System.out.println("[1] Continue");
        System.out.println("[2] Save and quit");
    }

    public static void fightWindow(){
        System.out.println(GameConstants.TEXT_COLOR_RED + player + "\n" + GameConstants.RESET); // player stats

        System.out.println(GameConstants.TEXT_COLOR_RED + enemy + "\n" + GameConstants.RESET); //enemy stats
        System.out.println("[1] Attack");
        System.out.println("[2] Heal");
        System.out.println("[3] Use Ability");
        System.out.println("[4] Exit");

    }

    public static void loadGame() {
        System.out.println("...load game...");
    }
}
