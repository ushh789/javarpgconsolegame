package com.softserve.edu.finalproject.character;

import com.softserve.edu.finalproject.constants.GameConstants;
import com.softserve.edu.finalproject.enemy.Enemy;

public class Rogue extends GameCharacter implements Ability {
    public Characters characterType = Characters.ROGUE;

    public Rogue(String name, Characters characterType) {
        super(name);
        this.setDamage(10);
        this.setHealth(120);
    }

    public void useAbility(Enemy target) {
        this.setMana(this.getMana() - 100);
        int damageStealing = (int) (target.getDamage() * 0.35);
        this.stealDamage(target, damageStealing);
        setAbilityAvailable(!isAbilityAvailable());
    }

    @Override
    public String toString() {
        return GameConstants.CHARACTER_ROGUE
                + "\nMy name is " + getName()
                + "\n[HEALTH] " + getHealth()
                + "\n[DAMAGE] " + getDamage()
                + "\n[MANA] " + getMana();
    }
}
