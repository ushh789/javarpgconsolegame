package com.softserve.edu.finalproject.services;

import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.softserve.edu.finalproject.character.*;
import com.softserve.edu.finalproject.enemy.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.*;



public class SaveEvents {
    private Gson gson;

    public SaveEvents() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public boolean save(Optional<String> path, GameCharacter player, Enemy enemy, KeyEventsHandler keyEventsHandler) {

        try {
            String filePath = path.orElseGet(() -> {
                String playerName;
                if (player == null) playerName = "autosave";
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
                if (player != null) gson.toJson(player, bw);
                if (enemy != null) {
                    bw.write(',');
                    gson.toJson(enemy, bw);
                }

                if (player != null) {
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

    public File[] loadOptions() {
        String path = "src/com/softserve/edu/finalproject/saves/";
        File directory = new File(path);
        File[] files = new File[0];
        if (directory.isDirectory()) {
            files = directory.listFiles();
            if (files == null) System.out.println("No files found in the directory.");
        } else {
            System.out.println(path + " is not a directory.");
        }
        return files;
    }

    public void printSaves(File[] files) {
    String path = "src/com/softserve/edu/finalproject/saves/";
        Pattern p = Pattern.compile("([\\d\\w]+_[\\d]{2}[\\d]{2}[\\d]{4})");
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isFile()) {
                String fileInfo = file.getName();
                Matcher m = p.matcher(fileInfo);
                if (m.find()) {
                    String modifiedDate = fileInfo.substring(m.start(), m.end());
                    modifiedDate = modifiedDate.replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1.$2.$3");
                    modifiedDate = modifiedDate.replace("_", " - ");
                    System.out.println("[" + i + "] - " + modifiedDate);
                }
            }
        }
    }

    public GameCharacter loadPlayer(File file) {
        try (FileReader reader = new FileReader(file)) {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(reader).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                if (element.isJsonObject()) {
                    JsonObject jsonObject = element.getAsJsonObject();
                    if (jsonObject.has("characterType") && jsonObject.get("characterType").getAsString().equals("MAGE")) {
                        GameCharacter player = new Gson().fromJson(jsonObject, Mage.class);
                        return player;
                    } else if (jsonObject.has("characterType") && jsonObject.get("characterType").getAsString().equals("WARRIOR")) {
                        GameCharacter player = new Gson().fromJson(jsonObject, Warrior.class);
                        return player;
                    } else if (jsonObject.has("characterType") && jsonObject.get("characterType").getAsString().equals("ROGUE")) {
                        GameCharacter player = new Gson().fromJson(jsonObject, Rogue.class);
                        return player;
                    } else if (jsonObject.has("characterType") && jsonObject.get("characterType").getAsString().equals("PRIEST")) {
                        GameCharacter player = new Gson().fromJson(jsonObject, Priest.class);
                        return player;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Enemy loadEnemy(File file) {
        try (FileReader reader = new FileReader(file)) {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(reader).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                if (element.isJsonObject()) {
                    JsonObject jsonObject = element.getAsJsonObject();
                    if (jsonObject.has("enemyType") && jsonObject.get("enemyType").getAsString().equals("GOBLIN")) {
                        Enemy enemy = new Gson().fromJson(jsonObject, Goblin.class);
                        System.out.println(enemy);
                        return enemy;
                    } else if (jsonObject.has("enemyType") && jsonObject.get("enemyType").getAsString().equals("SKELETON")) {
                        Enemy enemy = new Gson().fromJson(jsonObject, Skeleton.class);
                        System.out.println(enemy);
                        return enemy;
                    } else if (jsonObject.has("enemyType") && jsonObject.get("enemyType").getAsString().equals("DRAGON")) {
                        Enemy enemy = new Gson().fromJson(jsonObject, Dragon.class);
                        System.out.println(enemy);
                        return enemy;
                    } else if (jsonObject.has("enemyType") && jsonObject.get("enemyType").getAsString().equals("HUMAN")) {
                        Enemy enemy = new Gson().fromJson(jsonObject, Human.class);
                        System.out.println(enemy);
                        return enemy;
                    } else if (jsonObject.has("enemyType") && jsonObject.get("enemyType").getAsString().equals("ELF")) {
                        Enemy enemy = new Gson().fromJson(jsonObject, Elf.class);
                        System.out.println(enemy);
                        return enemy;
                    } else if (jsonObject.has("enemyType") && jsonObject.get("enemyType").getAsString().equals("DWARF")) {
                        Enemy enemy = new Gson().fromJson(jsonObject, Dwarf.class);
                        System.out.println(enemy);
                        return enemy;
                    } else if (jsonObject.has("enemyType") && jsonObject.get("enemyType").getAsString().equals("ORK")) {
                        Enemy enemy = new Gson().fromJson(jsonObject, Ork.class);
                        System.out.println(enemy);
                        return enemy;
                    } else if (jsonObject.has("enemyType") && jsonObject.get("enemyType").getAsString().equals("UNDEAD")) {
                        Enemy enemy = new Gson().fromJson(jsonObject, Undead.class);
                        System.out.println(enemy);
                        return enemy;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
