package src.com.softserve.edu.finalproject.services;

public class GameEvents {

    public static void start() {

    }

    public static void clearCLI() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void quit() {
        System.exit(0);
    }
}
