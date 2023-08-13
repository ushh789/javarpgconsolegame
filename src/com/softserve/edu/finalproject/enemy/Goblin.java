package com.softserve.edu.finalproject.enemy;

public class Goblin extends Enemy {
    private Enemies enemyType;

    public Goblin(String name) {
        super(name);
        this.enemyType = Enemies.GOBLIN;
        this.setHealth(50);
        this.setDamage(8);
    }

    public Enemies getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(Enemies enemyType) {
        this.enemyType = enemyType;
    }
    @Override
    public String toString() {
        return super.toString()+ "\n" +
                enemyType + " - " + this.getName() +
                "\n[HEALTH] " + this.getHealth() +
                "\n[DAMAGE] " + this.getDamage();
    }
}
