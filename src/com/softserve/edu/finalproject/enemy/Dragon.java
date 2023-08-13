package src.com.softserve.edu.finalproject.enemy;

public class Dragon extends Enemy {
    private Enemies enemyType;

    public Dragon(String name) {
        super(name);
        this.enemyType = Enemies.DRAGON;
        this.setHealth(40);
        this.setDamage(10);
    }

    public Enemies getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(Enemies enemyType) {
        this.enemyType = enemyType;
    }
}
