package com.rps;

public enum Weapon {
    ROCK,
    PAPER,
    SCISSORS;

    public static Weapon intToEnum(int number) {
        switch (number) {
            case 1:
                return ROCK;
            case 2:
                return PAPER;
            case 3:
                return SCISSORS;
            default:
                return null;
        }
    }
}