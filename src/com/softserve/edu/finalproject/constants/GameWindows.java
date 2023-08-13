package com.softserve.edu.finalproject.constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import static com.softserve.edu.finalproject.DungeonRunner.player;
import static java.lang.Thread.sleep;

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

    public static String startGame() throws IOException, InterruptedException {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + GameConstants.START_TITLE + GameConstants.RESET);
        System.out.print(GameConstants.BOLD + "Enter your name: " + GameConstants.RESET + GameConstants.TEXT_COLOR_CYAN);

        // TODO: Очікувати поки введеться ім'я і тільки потім пропонувати вибрати персонажа
        Thread inputName = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            name = sc.nextLine();
        });

        inputName.start();
        inputName.join();
        sleep(1000);

        System.out.println(GameConstants.RESET + GameConstants.BOLD + "Choose your character type:" + GameConstants.RESET);
        System.out.println("[1] Mage");
        System.out.println("[2] Priest");
        System.out.println("[3] Rogue");
        System.out.println("[4] Warrior");

        return name;
    }

    public static void createdWindow() {
        System.out.println(GameConstants.TEXT_COLOR_CYAN + player + "\n" + GameConstants.RESET);

        System.out.println(GameConstants.BOLD + "Select an option:" + GameConstants.RESET);
        System.out.println("[1] Continue");
        System.out.println("[2] Save and quit");
    }

    public static void loadGame() {
        System.out.println("...load game...");
    }
}
