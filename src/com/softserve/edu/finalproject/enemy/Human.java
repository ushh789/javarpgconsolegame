package com.softserve.edu.finalproject.enemy;

public class Human extends Enemy {
    private Enemies enemyType;

    public Human(String name) {
        super(name);
        this.enemyType = Enemies.HUMAN;
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
                enemyType.getName() + " called " + this.getName() +
                "\n[HEALTH] " + this.getHealth() +
                "\n[DAMAGE] " + this.getDamage();
    }
}
