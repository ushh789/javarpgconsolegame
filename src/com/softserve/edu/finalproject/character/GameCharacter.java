package com.softserve.edu.finalproject.character;

import com.softserve.edu.finalproject.constants.GameConstants;
import com.softserve.edu.finalproject.constants.Windows;
import com.softserve.edu.finalproject.enemy.Enemy;
import com.softserve.edu.finalproject.services.KeyEventsHandler;

public abstract class GameCharacter implements Ability {
    private String name;
    private int level;
    private int damage;
    private int health;
    private int mana;

    public GameCharacter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void stealDamage(Enemy target, int value){
        target.setDamage(target.getDamage() - value);
        damage+= value;
    }

    public void stealHealth(Enemy target, int value){
        target.setHealth(target.getHealth() - value);
        health+= value;
    }
    public void increaseDamage(int value) {
        damage += value;
    }

    public void increaseLevel() {
        level += 1;
    }

    public void increaseMana(int value) {
        mana += value;
    }

    public void attack(Enemy target, int damage) {
        target.setHealth(target.getHealth() - damage);
    }

    public void heal(int value) {

        health += value;

    }
}