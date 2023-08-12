package com.softserve.edu.finalproject.character;

import com.softserve.edu.finalproject.enemy.Enemy;

public class Mage extends GameCharacter implements Ability {
    public Characters characterType = Characters.MAGE;

    public Mage(String name, Characters characterType) {
        super(name);
        this.setDamage(10);
        this.setHealth(120);
    }

    public void attack(Enemy target) {

    }

    public void heal(int healing) {

    }

    @Override
    public void useAbility(Enemy target) {

    }
}