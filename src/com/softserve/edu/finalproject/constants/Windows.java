package com.softserve.edu.finalproject.constants;

public enum Windows {
    MAIN("MAIN"),
    START("START"),
    LOAD("LOAD"),
    CONTINUE("CONTINUE"),
    FIGHT("FIGHT"),
    CONTINUE_FIGHT("CONTINUE_FIGHT");

    private String windowsName;

    Windows(String windowsName) {
        this.windowsName = windowsName;
    }

    public String getWindowsName() {
        return windowsName;
    }
}
