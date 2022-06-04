package com.example.bitcoinproject;

public enum PathNameForUnit {

    PATH_MINUTES("minutes/");

    private final String pathName;

    PathNameForUnit(String path) {
        this.pathName = path;
    }

    public String getPathName() {
        return pathName;
    }

}
