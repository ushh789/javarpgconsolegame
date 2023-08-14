package com.softserve.edu.finalproject.character;

import com.softserve.edu.finalproject.constants.GameConstants;
import com.softserve.edu.finalproject.enemy.Enemy;

public class Mage extends GameCharacter implements Ability {
    public Characters characterType = Characters.MAGE;

    public Mage(String name, Characters characterType) {
        super(name);
        this.setDamage(10);
        this.setHealth(120);
    }

    @Override
    public boolean useAbility(Enemy target) {
        this.setMana(this.getMana() - 100);
        int healthStealing = (int) (target.getHealth() * 0.15);
        this.stealHealth(target, healthStealing);
        return true;
    }

    @Override
    public String toString() {
        return GameConstants.CHARACTER_MAGE
                + "\nMy name is " + getName()
                + "\n[HEALTH] " + getHealth()
                + "\n[DAMAGE] " + getDamage()
                + "\n[MANA] " + getMana();
    }
}