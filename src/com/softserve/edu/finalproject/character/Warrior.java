package com.softserve.edu.finalproject.character;

import com.softserve.edu.finalproject.constants.GameConstants;
import com.softserve.edu.finalproject.enemy.Enemy;

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

    @Override
    public String toString() {
        return GameConstants.CHARACTER_WARRIOR
                + "\nMy name is " + getName()
                + "\n[HEALTH] " + getHealth() + "hp"
                + "\n[DAMAGE] " + getDamage()
                + "\n[MANA] " + getMana();
    }
}
