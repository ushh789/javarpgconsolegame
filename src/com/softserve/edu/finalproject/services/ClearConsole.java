package src.com.softserve.edu.finalproject.services;

public class ClearConsole {
    public static void main(String[] args) {
        System.out.println("hidffdihiufhd\nerjuiuer\nhuerire");
        clearConsole();
        System.out.println("Console cleared!");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[J");
    }
}
