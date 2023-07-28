package com.wtech.core.parts;

public class Engine {

    private final String type;
    private final int volume;

    public Engine(String type, int volume) {
        this.type = type;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("Eng %s vol %d", type, volume);
    }
}
