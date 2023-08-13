package src.com.softserve.edu.finalproject.enemy;

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
}
