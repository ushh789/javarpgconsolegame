package src.com.softserve.edu.finalproject.enemy;

public enum Enemies {
    GOBLIN("Goblin"),
    SKELETON("Skeleton"),
    DRAGON("Dragon"),
    HUMAN("Human"),
    ELF("Elf"),
    DWARF("Dwarf"),
    ORK("Ork"),
    UNDEAD("Undead");

    private String name;

    Enemies(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
