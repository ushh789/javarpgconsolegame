package src.com.softserve.edu.finalproject.enemy;

public class Skeleton extends Enemy {
    private Enemies enemyType;

    public Skeleton(String name) {
        super(name);
        this.enemyType = Enemies.SKELETON;
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
