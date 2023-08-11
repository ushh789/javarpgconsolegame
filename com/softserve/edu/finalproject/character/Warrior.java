package com.softserve.edu.finalproject.character;

public class Warrior extends GameCharacter implements Ability {
    public Characters characterType = Characters.WARRIOR;

    public Warrior(String name, Characters characterType) {
        super(name);
        this.setDamage(16);
        this.setHealth(100);
    }

    @Override
    public void attack(Enemy target) {

    }

    @Override
    public void heal(int healing) {

    }

    @Override
    public void useAbility(Enemy target) {

    }
}
