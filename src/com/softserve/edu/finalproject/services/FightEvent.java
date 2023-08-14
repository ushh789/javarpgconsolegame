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


    public FightEvent(GameCharacter player, Enemy target) {
        Random random = new Random();
        randomAttackAction = random.nextInt(3);
        randomHealAction = random.nextInt(3);
        playerOldDamage = player.getDamage();
        playerOldHealth = player.getHealth();
        enemyOldDamage = target.getDamage();
        enemyOldHealth = target.getHealth();
    }

    public int getRandomAttackAction() {
        return randomAttackAction;
    }

    public int getRandomHealAction() {
        return randomHealAction;
    }

    public void fight(GameCharacter player, Enemy target){
        Random random = new Random();
        switch (randomAttackAction){
            case 0 :
                System.out.println("[1] Attack" + "-" + player.getDamage() + "HP");
//                player.attack(target, player.getDamage());

            case 1:
                int randomStealingValue = random.nextInt(15 ) + 10;
                randomStealingValue = (randomStealingValue  * target.getDamage()) / 100;
                System.out.println("[1] Steal " + randomStealingValue + " DMG");
//                player.stealDamage(target, randomStealingValue);
            case 2:
                int randomIncreaseDamage = random.nextInt(5) + 2;
                System.out.println("[1] Damage +" + randomIncreaseDamage + " DMG");
//                player.increaseDamage(randomIncreaseDamage);
        }

        switch (randomHealAction){
            case 0:
                int randomStealingValue = random.nextInt(10 ) + 5;
                randomStealingValue = (randomStealingValue  * target.getDamage()) / 100;
                System.out.println("[1] Steal " + randomStealingValue + " HP");
//                player.stealHealth(target, randomStealingValue);
            case 1:
                int randomHeal = random.nextInt(25) + 10;
                System.out.println("[1] Heal +" + randomHeal + " HP");
//                player.heal(randomHeal);
        }


    }
}
