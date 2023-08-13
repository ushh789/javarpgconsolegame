package src.com.softserve.edu.finalproject.enemy;

public class Ork extends Enemy {
    private Enemies enemyType;

    public Ork(String name) {
        super(name);
        this.enemyType = Enemies.ORK;
        this.setHealth(50);
        this.setDamage(8);
    }

    public Enemies getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(Enemies enemyType) {
        this.enemyType = enemyType;
    }
}
