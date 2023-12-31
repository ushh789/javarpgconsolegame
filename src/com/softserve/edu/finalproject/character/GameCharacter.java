package com.softserve.edu.finalproject.character;

import com.softserve.edu.finalproject.enemy.Enemy;

import java.io.Serializable;
import java.util.Objects;

public abstract class GameCharacter implements Ability, Serializable {
    private String name;
    private int level;
    private int damage;
    private int health;
    private int mana;
    private boolean abilityAvailable;

    public GameCharacter(String name) {
        this.name = name;
        abilityAvailable = false;

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

    public int getLevel() {
        return level;
    }

    public boolean isAbilityAvailable() {
        return abilityAvailable;
    }

    public void setAbilityAvailable(boolean abilityAvailable) {
        this.abilityAvailable = abilityAvailable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameCharacter that)) return false;
        return level == that.level && damage == that.damage && health == that.health && mana == that.mana && abilityAvailable == that.abilityAvailable && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, damage, health, mana, abilityAvailable);
    }
}