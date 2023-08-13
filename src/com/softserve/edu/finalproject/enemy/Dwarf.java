package src.com.softserve.edu.finalproject.enemy;

public class Dwarf extends Enemy {
    private Enemies enemyType;

    public Dwarf(String name) {
        super(name);
        this.enemyType = Enemies.GOBLIN;
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
