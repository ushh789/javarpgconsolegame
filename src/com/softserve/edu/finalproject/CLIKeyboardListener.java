package com.softserve.edu.finalproject;

import java.io.IOException;

public class CLIKeyboardListener {
    public static void main(String[] args) throws IOException {
        Thread inputThread = new Thread(() -> {
            try {
                while (true) {
                    int key = System.in.read(); // Read a single character from the console

                    // Exit the loop if the 'q' key is pressed
                    if (key == 'q') {
                        break;
                    }

                    System.out.println("You pressed: " + (char) key);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Press keys. Press 'q' to quit.");

        inputThread.start();

        try {
            inputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Exiting...");
    }
}
