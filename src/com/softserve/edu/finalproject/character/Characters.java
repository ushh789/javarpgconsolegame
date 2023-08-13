package com.softserve.edu.finalproject.character;

public enum Characters {

    WARRIOR("Warrior"),
    MAGE("Mage"),
    ROGUE("Rogue"),
    PRIEST("Priest");
    private final String characterType;

    Characters(String characterType) {
        this.characterType = characterType;
    }

    public String getCharacterType() {
        return characterType;
    }
}
