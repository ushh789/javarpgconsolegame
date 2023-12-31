package com.softserve.edu.finalproject.services;

import com.softserve.edu.finalproject.character.GameCharacter;
import com.softserve.edu.finalproject.enemy.Enemy;

import java.util.Random;

public class FightEvents {
    private final int playerOldHealth;
    private final int enemyOldHealth;
    private final int playerOldDamage;
    private final int enemyOldDamage;
    private final int randomAttackAction;
    private final int randomHealAction;
    private final int randomIncreaseDamage;
    private final int randomDamageStealingValue;
    private int damageStealingValue;
    private final int randomHeal;
    private final int randomHealthStealingValue;
    private int healthStealingValue;
    private final int damageBotStealingValue;
    private final int randomBotIncreaseDamage;
    private final int healthBotStealingValue;
    private final int randomBotHeal;
    private final int botChoice;

    private final GameCharacter player;
    private final Enemy enemy;

    public FightEvents(GameCharacter player, Enemy target) {
        Random random = new Random();
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

        randomBotIncreaseDamage = random.nextInt(3) + 1;
        randomBotHeal = random.nextInt(10) + 5;
        damageBotStealingValue = (int) (((float) this.player.getDamage() / 100) * randomDamageStealingValue) + 1;
        healthBotStealingValue = (int) (((float) this.player.getHealth() / 100) * randomHealthStealingValue) + 1;
        botChoice = random.nextInt(5);
    }

    public void fightOptions() {
        switch (randomAttackAction) {
            case 0 -> System.out.println("[1] Attack " + "-" + player.getDamage() + "HP");
            case 1 -> {
                damageStealingValue = (int) (((float) enemy.getDamage() / 100) * randomDamageStealingValue) + 1;
                System.out.println("[1] Steal " + damageStealingValue + " DMG");
            }
            case 2 -> System.out.println("[1] Damage +" + randomIncreaseDamage + " DMG");
        }
        switch (randomHealAction) {
            case 0 -> {
                healthStealingValue = (int) (((float) enemy.getHealth() / 100) * randomHealthStealingValue) + 1;
                System.out.println("[2] Steal " + healthStealingValue + " HP");
            }
            case 1 -> System.out.println("[2] Heal +" + randomHeal + " HP");
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
    public void botOptions(){
        switch(botChoice){
            case 0 -> enemy.attack(player, enemy.getDamage());
            case 1 -> enemy.stealDamage(player, damageBotStealingValue);
            case 2 -> enemy.increaseDamage(randomBotIncreaseDamage);
            case 3 -> enemy.stealHealth(player, healthBotStealingValue);
            case 4 -> enemy.heal(randomBotHeal);
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
