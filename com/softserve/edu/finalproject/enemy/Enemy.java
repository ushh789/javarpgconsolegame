package com.softserve.edu.finalproject.enemy;

public class Enemy {
    private Enemies name;
    private int health;
    private int damage;

    public Enemy(Enemies name) {
        if(name == Enemies.GOBLIN || name == Enemies.HUMAN || name == Enemies.ORK) {
            this.health = 50;
            this.damage = 8;
        } else if(name == Enemies.SKELETON || name == Enemies.ELF || name == Enemies.UNDEAD) {
            this.health = 60;
            this.damage = 5;
        } else if(name == Enemies.DRAGON || name == Enemies.DWARF) {
            this.health = 40;
            this.damage = 10;
        }
    }

    public void setName(Enemies name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name.getName();
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(GameCharacter target, int attack) {
        target.setDamage(target.getDamage() - attack);
    }

    public void health(int health) {
        this.health += health;
    }

    @Override
    public String toString() {
        return "Enemy { " +
                "name = " + name +
                ", health = " + health +
                ", damage = " + damage +
                " }";
    }
}
