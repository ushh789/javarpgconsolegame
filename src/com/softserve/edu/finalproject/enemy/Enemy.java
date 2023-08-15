package com.softserve.edu.finalproject.enemy;

import com.softserve.edu.finalproject.character.GameCharacter;

import java.io.Serializable;
import java.util.Objects;

public class Enemy implements Serializable {
    private String name;
    private int health;
    private int damage;


    public Enemy(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(GameCharacter target, int attack) {
        target.setHealth(target.getHealth() - attack);
    }

    public void heal(int health) {
        this.health += health;
    }

    public void stealDamage(GameCharacter target, int value) {
        target.setDamage(target.getDamage() - value);
        damage += value;
    }

    public void stealHealth(GameCharacter target, int value) {
        target.setHealth(target.getHealth() - value);
        health += value;
    }

    public void increaseDamage(int value) {
        damage += value;
    }

    @Override
    public String toString() {
        return "You are fighting against: ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enemy enemy)) return false;
        return health == enemy.health && damage == enemy.damage && Objects.equals(name, enemy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, damage);
    }
}
