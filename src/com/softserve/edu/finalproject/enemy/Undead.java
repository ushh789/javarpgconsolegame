package com.softserve.edu.finalproject.enemy;

public class Undead extends Enemy {
    private Enemies enemyType;

    public Undead(String name) {
        super(name);
        this.enemyType = Enemies.UNDEAD;
        this.setHealth(60);
        this.setDamage(5);
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
