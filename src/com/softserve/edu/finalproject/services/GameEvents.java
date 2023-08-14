package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.constants.GameConstants;
import com.softserve.edu.finalproject.constants.Windows;
import com.softserve.edu.finalproject.enemy.*;
import com.softserve.edu.finalproject.locations.*;

import static com.softserve.edu.finalproject.DungeonRunner.*;
import static com.softserve.edu.finalproject.constants.NamesAndTitles.*;

import java.util.Random;

public class GameEvents {

    public static void start() {

    }

    public static void clearCLI() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Windows generate() {
        Random random = new Random();

        int randomLocation = random.nextInt(4);
        switch (randomLocation) {
            case 0 -> location = new Cave();
            case 1 -> location = new Dungeon();
            case 2 -> location = new Forest();
            case 3 -> location = new Town();
            default -> throw new IllegalStateException("Unexpected value: " + randomLocation);
        }

        int randomEvent = random.nextInt(100);

        if (randomEvent >= 0 && randomEvent < 25) {
            System.out.println("\n" + GameConstants.BOLD + location + "..." + GameConstants.RESET);
            System.out.println(GameConstants.BOLD + GameConstants.TEXT_COLOR_GREEN + GameConstants.REST_ROOM + GameConstants.RESET);
            player.increaseLevel();
            player.heal(random.nextInt(11) + 10);
            player.increaseDamage(5);
            return Windows.START;
        } else if (randomEvent >= 25 && randomEvent < 50) {
            System.out.println(location);
            System.out.println(GameConstants.BOLD + GameConstants.TEXT_COLOR_YELLOW + GameConstants.CHEST_ROOM + GameConstants.RESET);
            player.increaseLevel();
            player.increaseMana(100);
            return Windows.START;
        } else if (randomEvent >= 50) {
            System.out.println(location);
            int randomEnemy = random.nextInt(8);
            int enemyName = random.nextInt(10);
            switch (randomEnemy) {
                case 0 -> enemy = new Dragon(dragonNames[enemyName]);
                case 1 -> enemy = new Dwarf(dwarfNames[enemyName]);
                case 2 -> enemy = new Elf(elfNames[enemyName]);
                case 3 -> enemy = new Goblin(goblinNames[enemyName]);
                case 4 -> enemy = new Human(humanNames[enemyName]);
                case 5 -> enemy = new Ork(orkNames[enemyName]);
                case 6 -> enemy = new Skeleton(skeletonNames[enemyName]);
                case 7 -> enemy = new Undead(undeadNames[enemyName]);
                default -> throw new IllegalStateException("Unexpected value: " + randomEnemy);
            }
            System.out.println(enemy);
            return Windows.FIGHT;
        }
        return null;
    }

    public static void quit() {
        System.exit(0);
    }
}
