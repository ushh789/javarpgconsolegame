package com.softserve.edu.finalproject.character;

public class Rogue extends GameCharacter implements Ability{
    public Characters characterType = Characters.ROGUE;

    public Rogue(String name, Characters characterType) {
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
