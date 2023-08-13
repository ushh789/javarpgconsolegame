package com.softserve.edu.finalproject.locations;

public abstract class Area {
    private String locationName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public abstract void explore(Character character);

    @Override
    public String toString() {
        return locationName;
    }
}
