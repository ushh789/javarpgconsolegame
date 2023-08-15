package com.softserve.edu.finalproject.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softserve.edu.finalproject.character.GameCharacter;
import com.softserve.edu.finalproject.enemy.Enemy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class SaveEvents {
    private Gson gson;

    public SaveEvents() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public boolean save(Optional<String> path, GameCharacter player, Enemy enemy, KeyEventsHandler keyEventsHandler) {

        try {
            String filePath = path.orElseGet(() -> {
                String playerName;
                if(player == null) playerName = "autosave";
                else playerName = player.getName();

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

                String relativePath = "src/com/softserve/edu/finalproject/saves/";
                String fileName = playerName + "_" + currentDateTime.format(format) + ".json";
                Path fullPath = Paths.get(relativePath, fileName);

                keyEventsHandler.setCurrentPath(fullPath.toString());
                return fullPath.toString();
            });

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write('[');
                if(player != null) gson.toJson(player, bw);
                if(enemy != null) {
                    bw.write(',');
                    gson.toJson(enemy, bw);
                }

                if(player != null) {
                    bw.write(',');
                    gson.toJson(keyEventsHandler.getCurrentWindow(), bw);
                } else gson.toJson(keyEventsHandler.getCurrentWindow(), bw);
                bw.write(']');

                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean load(Optional<String> path, GameCharacter player, Enemy enemy, KeyEventsHandler keyEventsHandler) {

        return false; // erase
    }

    public boolean delete(String path) {
        String relativePath = "src/com/softserve/edu/finalproject/saves/";
        Path fullPath = Paths.get(relativePath, path);

        try {
            Files.delete(fullPath);
            return true;
        } catch (IOException e) {
            System.err.println("File wasn't deleted! Try again.");
            return false;
        }
    }
}
