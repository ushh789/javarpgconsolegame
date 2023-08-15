package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.character.GameCharacter;
import com.softserve.edu.finalproject.enemy.Enemy;

public class GameData {
    private GameCharacter player;
    private Enemy enemy;
    private KeyEventsHandler keyEventsHandler;

    public GameData(GameCharacter player, Enemy enemy, KeyEventsHandler keyEventsHandler) {
        this.player = player;
        this.enemy = enemy;
        this.keyEventsHandler = keyEventsHandler;
    }
}
