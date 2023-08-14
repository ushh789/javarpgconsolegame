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
    public void useAbility(Enemy target) {
        this.setMana(this.getMana() - 100);
        this.attack(target, 40);
        setAbilityAvailable(!isAbilityAvailable());
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
