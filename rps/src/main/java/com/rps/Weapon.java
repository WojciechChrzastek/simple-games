package com.rps;

public enum Weapon {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    public static Weapon intToEnum(int number) {
        switch (number) {
            case 1:
                return ROCK;
            case 2:
                return PAPER;
            case 3:
                return SCISSORS;
            case 4:
                return LIZARD;
            case 5:
                return SPOCK;
            default:
                return null;
        }
    }
}