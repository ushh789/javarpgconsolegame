package com.softserve.edu.finalproject.constants;

public class GameWindows {

    public static void startWindows() {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.GAME_TITLE + GameConstants.RESET);
        System.out.println(GameConstants.BOLD + "Select an option:" + GameConstants.RESET);
        System.out.println("[1] New game");
        System.out.println("[2] Load game");
        System.out.println("[3] Save and quit...");
    }
}
