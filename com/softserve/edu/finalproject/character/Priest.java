package com.softserve.edu.finalproject.character;

public class Priest extends GameCharacter implements Ability {
    public Characters characterType = Characters.PRIEST;

    public Priest(String name, Characters characterType) {
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
