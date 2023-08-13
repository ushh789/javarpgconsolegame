package com.softserve.edu.finalproject.character;

import com.softserve.edu.finalproject.enemy.Enemy;

public abstract class GameCharacter {
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public abstract void attack(Enemy target);

    public abstract void heal(int healing);
}
