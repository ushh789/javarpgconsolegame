package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.character.GameCharacter;
import com.softserve.edu.finalproject.enemy.Enemy;

import java.util.Random;

public class FightEvents {
    private int playerOldHealth;
    private int enemyOldHealth;
    private int playerOldDamage;
    private int enemyOldDamage;
    private int randomAttackAction;
    private int randomHealAction;
    private Random random;
    private int randomIncreaseDamage;
    private int randomDamageStealingValue;
    private int damageStealingValue;
    private int randomHeal;
    private int randomHealthStealingValue;
    private int healthStealingValue;
    private GameCharacter player;
    private Enemy enemy;

    public FightEvents(GameCharacter player, Enemy target) {
        random = new Random();
        this.player = player;
        this.enemy = target;
        randomAttackAction = random.nextInt(3);
        randomHealAction = random.nextInt(2);
        playerOldDamage = player.getDamage();
        playerOldHealth = player.getHealth();
        enemyOldDamage = target.getDamage();
        enemyOldHealth = target.getHealth();
        randomIncreaseDamage = random.nextInt(5) + 2;
        randomDamageStealingValue = random.nextInt(15) + 10;
        randomHeal = random.nextInt(25) + 10;
        randomHealthStealingValue = random.nextInt(20) + 5;
    }

    public void fightOptions() {
        switch (randomAttackAction) {
            case 0 -> System.out.println("[1] Attack " + "-" + player.getDamage() + "HP");
            case 1 -> {
                damageStealingValue = (int) (((float) enemy.getDamage() / 100) * randomDamageStealingValue) + 1;
                System.out.println("[1] Steal " + damageStealingValue + " DMG");
            }
            case 2 -> {
                System.out.println("[1] Damage +" + randomIncreaseDamage + " DMG");
            }

        }
        switch (randomHealAction) {
            case 0 -> {
                healthStealingValue = (int) (((float) enemy.getHealth() / 100) * randomHealthStealingValue) + 1;
                System.out.println("[2] Steal " + healthStealingValue + " HP");
            }
            case 1 -> {
                System.out.println("[2] Heal +" + randomHeal + " HP");
            }
        }
    }

    public void attackOption() {
        switch (randomAttackAction) {
            case 0 -> player.attack(enemy, player.getDamage());
            case 1 -> player.stealDamage(enemy, damageStealingValue);
            case 2 -> player.increaseDamage(randomIncreaseDamage);
        }
    }

    public void healOption() {
        switch (randomHealAction) {
            case 0 -> player.stealHealth(enemy, healthStealingValue);
            case 1 -> player.heal(randomHeal);

        }
    }

    public boolean abilityOption() {
        if(player.getMana() >= 100 && player.isAbilityAvailable()) {
            player.useAbility(enemy);
            return true;
        } else return false;
    }

    public int getPlayerOldHealth() {
        return playerOldHealth;
    }

    public int getEnemyOldHealth() {
        return enemyOldHealth;
    }

    public int getPlayerOldDamage() {
        return playerOldDamage;
    }

    public int getEnemyOldDamage() {
        return enemyOldDamage;
    }
}
