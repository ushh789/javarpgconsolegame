package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.character.GameCharacter;
import com.softserve.edu.finalproject.enemy.Enemy;

import java.util.Random;

public class FightEvent {
    private int playerOldHealth;
    private int enemyOldHealth;
    private int playerOldDamage;
    private int enemyOldDamage;
    private int randomAttackAction;
    private int randomHealAction;
    private Random random;
    private int randomIncreaseDamage;
    private int randomDamageStealingValue;
    private int randomHeal;
    private int randomHealthStealingValue;
    private GameCharacter player;
    private Enemy enemy;

    public FightEvent(GameCharacter player, Enemy target) {
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
        randomDamageStealingValue = random.nextInt(5) + 5;
        randomHeal = random.nextInt(25) + 10;
        randomHealthStealingValue = random.nextInt(10) + 5;
    }

    public void fightOptions() {
        switch (randomAttackAction) {
            case 0 -> System.out.println("[1] Attack " + "-" + player.getDamage() + "HP");
            case 1 -> {
                randomDamageStealingValue = randomDamageStealingValue +
                        (randomDamageStealingValue * enemy.getDamage()) / 100;
                System.out.println("[1] Steal " + randomDamageStealingValue + " DMG");
            }
            case 2 -> {
                System.out.println("[1] Damage +" + randomIncreaseDamage + " DMG");
            }

        }
        switch (randomHealAction) {
            case 0 -> {
                randomHealthStealingValue = randomHealthStealingValue +
                        (randomHealthStealingValue * enemy.getHealth()) / 50;
                System.out.println("[2] Steal " + randomHealthStealingValue + " HP");
            }
            case 1 -> {
                System.out.println("[2] Heal +" + randomHeal + " HP");
            }
        }
    }

    public void attackOption() {
        switch (randomAttackAction) {
            case 0 -> player.attack(enemy, player.getDamage());
            case 1 -> player.stealDamage(enemy, randomDamageStealingValue);
            case 2 -> player.increaseDamage(randomIncreaseDamage);
        }
    }

    public void healOption() {
        switch (randomHealAction) {
            case 0 -> player.stealHealth(enemy, randomHealthStealingValue);
            case 1 -> player.heal(randomHeal);

        }
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
