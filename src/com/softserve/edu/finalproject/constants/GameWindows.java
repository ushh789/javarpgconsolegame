package com.softserve.edu.finalproject.constants;


import com.softserve.edu.finalproject.character.Characters;
import com.softserve.edu.finalproject.services.FightEvents;
import com.softserve.edu.finalproject.services.SaveEvents;

import static com.softserve.edu.finalproject.DungeonRunner.enemy;
import static com.softserve.edu.finalproject.DungeonRunner.player;

public class GameWindows {
    public static String name;
    private static SaveEvents se;

    public static void mainWindow() {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.GAME_TITLE + GameConstants.RESET);
        System.out.println(GameConstants.BOLD + "Select an option:" + GameConstants.RESET);
        System.out.println("[1] New game");
        System.out.println("[2] Load game");
        System.out.println("[3] Save and quit\n");
        System.out.println(GameConstants.ITALIC + "Enter \"q\" in any moment to quit from game without saving progress." + GameConstants.RESET);
    }

    public static void loadWindow() {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.LOAD_TITLE + GameConstants.RESET);
        System.out.println(GameConstants.BOLD + "Select save:" + GameConstants.RESET);
        se = new SaveEvents();
        se.loadOptions();
        System.out.println("[q] Quit\n");
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
//        System.out.println(GameConstants.BOLD + "Select an option:" + GameConstants.RESET);
//        System.out.println("[1] Continue");
//        System.out.println("[2] Save and quit");
    }

    public static void startFightStageWindow() {
        StringBuilder gameStats = new StringBuilder();
        gameStats.append(GameConstants.TEXT_COLOR_CYAN);
        gameStats.append(GameConstants.BOLD);

        gameStats.append(String.format("%-30s%-30s%n", "[" + player.getName() + "]", "[" + enemy.getName() + "]"));
        gameStats.append(GameConstants.RESET);
        gameStats.append(GameConstants.TEXT_COLOR_CYAN);
        gameStats.append(GameConstants.ITALIC);
        gameStats.append(String.format("%-10s%-20s%-10s%-20s%n", "[HEALTH]", player.getHealth(), "[HEALTH]", enemy.getHealth()));
        gameStats.append(String.format("%-10s%-20s%-10s%-20s%n", "[DAMAGE]", player.getDamage(), "[DAMAGE]", enemy.getDamage()));
        gameStats.append(String.format("%-10s%-10s%n", "[MANA]", player.getMana()));

        gameStats.append(GameConstants.RESET);

        System.out.println(gameStats);
    }

    public static void continueFightStageWindow(FightEvents fe) {
        StringBuilder gameStats = new StringBuilder();
        gameStats.append(GameConstants.TEXT_COLOR_CYAN);
        gameStats.append(GameConstants.BOLD);

        gameStats.append(String.format("%-30s%-30s%n", "[" + player.getName() + "]", "[" + enemy.getName() + "]"));
        gameStats.append(GameConstants.RESET);
        gameStats.append(GameConstants.TEXT_COLOR_CYAN);
        gameStats.append(GameConstants.ITALIC);
        gameStats.append(String.format("%-10s%-20s%-10s%-20s%n", "[HEALTH] ",
                fe.getPlayerOldHealth() + " -> " + player.getHealth(),
                "[HEALTH]", fe.getEnemyOldHealth() + " -> " + enemy.getHealth()));
        gameStats.append(String.format("%-10s%-20s%-10s%-20s%n", "[DAMAGE]",
                fe.getPlayerOldDamage() + " -> " + player.getDamage(),
                "[DAMAGE]", fe.getEnemyOldDamage() + " -> " + enemy.getDamage()));
        gameStats.append(String.format("%-10s%-10s%n", "[MANA]", player.getMana()));

        gameStats.append(GameConstants.RESET);

        System.out.println(gameStats);
    }

    public static void endFightStageWindow() {
        System.out.println("[3] Use ability");
        System.out.println("[4] Save and quit");
    }

    public static void lostFightWindow() {
        System.out.println(GameConstants.TEXT_COLOR_RED + GameConstants.LOST_TITLE + GameConstants.RESET);
    }

    public static void winFightWindow() {
        System.out.println(GameConstants.TEXT_COLOR_GREEN + GameConstants.WIN_TITLE + GameConstants.RESET);
//        System.out.println(GameConstants.TEXT_COLOR_CYAN + player. + GameConstants.RESET);
    }
    public static void loadGame() {
        System.out.println("...load game...");
    }
}
