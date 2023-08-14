package com.softserve.edu.finalproject.character;

import com.softserve.edu.finalproject.constants.GameConstants;
import com.softserve.edu.finalproject.enemy.Enemy;

public class Priest extends GameCharacter implements Ability {
    public Characters characterType = Characters.PRIEST;

    public Priest(String name, Characters characterType) {
        super(name);
        this.setDamage(10);
        this.setHealth(120);
    }

    @Override
    public void useAbility(Enemy target) {
        this.setMana(this.getMana() - 100);
        this.heal(40);
        setAbilityAvailable(!isAbilityAvailable());
    }

    @Override
    public String toString() {
        return GameConstants.CHARACTER_PRIEST
                + "\nMy name is " + getName()
                + "\n[HEALTH] " + getHealth()
                + "\n[DAMAGE] " + getDamage()
                + "\n[MANA] " + getMana();
    }
}
