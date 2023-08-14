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
    public boolean useAbility(Enemy target) {
        this.attack(target, 40);
        return true;
    }

    @Override
    public String toString() {
        return GameConstants.CHARACTER_WARRIOR
                + "\nMy name is " + getName()
                + "\n[HEALTH] " + getHealth()
                + "\n[DAMAGE] " + getDamage()
                + "\n[MANA] " + getMana();
    }
}
