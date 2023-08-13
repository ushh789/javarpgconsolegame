package src.com.softserve.edu.finalproject.enemy;

public class Elf extends Enemy {
    private Enemies enemyType;

    public Elf(String name) {
        super(name);
        this.enemyType = Enemies.ELF;
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
