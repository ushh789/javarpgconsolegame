package com.softserve.edu.finalproject.character;

public class Mage extends GameCharacter implements Ability {
    public Characters characterType = Characters.MAGE;

    public Mage(String name, Characters characterType) {
        super(name);
        this.setDamage(10);
        this.setHealth(120);
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