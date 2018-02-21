package com.rps;

import java.util.Random;
import java.util.Scanner;

import static com.rps.Weapon.*;

public class WeaponChoice {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Weapon userChoice() {
        int userChoice;
        do {
            System.out.print("Choose your weapon: ");
            scanner.nextLine();
        } while (!scanner.hasNextInt());
        do {
            userChoice = scanner.nextInt();
        } while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4 && userChoice != 5);
        return Weapon.intToEnum(userChoice);
    }

    public Weapon fairComputerChoice() {
        int computerChoice = random.nextInt(5) + 1;
        return Weapon.intToEnum(computerChoice);
    }

    private Weapon computerLoseWeapon(Weapon weapon) {
        switch (weapon) {
            case ROCK:
                return SCISSORS;
            case PAPER:
                return ROCK;
            case SCISSORS:
                return PAPER;
            case LIZARD:
                return ROCK;
            case SPOCK:
                return LIZARD;
            default:
                return null;
        }
    }

    private Weapon computerWinWeapon(Weapon weapon) {
        switch (weapon) {
            case ROCK:
                return PAPER;
            case PAPER:
                return SCISSORS;
            case SCISSORS:
                return ROCK;
            case LIZARD:
                return ROCK;
            case SPOCK:
                return PAPER;
            default:
                return null;
        }
    }

    public Weapon unfairComputerChoice(Weapon userWeapon) {
        int randomNumber = (random.nextInt(100) + 1);
        if ((1 <= randomNumber) && (randomNumber <= 25)) {
            return computerLoseWeapon(userWeapon);
        }
        if ((26 <= randomNumber) && (randomNumber <= 50)) {
            return userWeapon;
        }
        return computerWinWeapon(userWeapon);
    }
}
