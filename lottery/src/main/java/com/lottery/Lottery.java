package com.lottery;

import java.util.*;

public class Lottery {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private String userName;
    private int numbersToCheckCount;
    private Set<Integer> randomNumbersSet;
    private Set<Integer> userNumbersSet;
    private int userNumber;

    public void runLottery() {
        setGameSettings();
        createUserNumbersSet();
        createRandomNumbersSet();
        checkMatches();
        playWithNewOrCurrentRandomNumbersSet();
    }

    private void playWithNewOrCurrentRandomNumbersSet() {
        String renewRandomNumbersSet;
        do {
            System.out.println("Do you want computer to choose numbers again? Press \"y\" for YES and \"n\" for NO.");
            renewRandomNumbersSet = scanner.next();
        } while ((!renewRandomNumbersSet.equals("y")) && (!renewRandomNumbersSet.equals("n")));

        if (renewRandomNumbersSet.equals("y")) {
            playWithNewRandomNumbersSet();
        }

        if (renewRandomNumbersSet.equals("n")) {
            playWithCurrentRandomNumbersSet();
        }
    }

    private void playWithCurrentRandomNumbersSet() {
        playWithNewOrCurrentUserNumbersSet();
    }

    private void playWithNewRandomNumbersSet() {
        System.out.println("User numbers set: " + userNumbersSet.toString());
        createRandomNumbersSet();
        checkMatches();
        playWithNewOrCurrentRandomNumbersSet();
    }

    private void playWithNewOrCurrentUserNumbersSet() {
        String renewUserNumbersSet;
        do {
            System.out.println("Do you want to to choose your numbers again? Press \"y\" for YES and \"n\" for NO.");
            renewUserNumbersSet = scanner.next();
        } while ((!renewUserNumbersSet.equals("y")) && (!renewUserNumbersSet.equals("n")));
        if (renewUserNumbersSet.equals("y")) {
            playWithNewUserNumbersSet();
        }
        if (renewUserNumbersSet.equals("n")) {
            playWithCurrentUserNumbersSet();
        }
    }

    private void playWithCurrentUserNumbersSet() {
        String quitOrPlayAgain;
        do {
            System.out.println("Do you want play again? Press \"y\" for YES and \"n\" for QUIT.");
            quitOrPlayAgain = scanner.next();
        } while ((!quitOrPlayAgain.equals("y")) && (!quitOrPlayAgain.equals("n")));
        if (quitOrPlayAgain.equals("n")) {
            System.out.println("-----\n##### Thank you " + userName + " for playing the lottery. #####");
            System.exit(0);
        }
        if (quitOrPlayAgain.equals("y")) {
            System.out.println("");
            runLottery();
        }
    }

    private void playWithNewUserNumbersSet() {
        createUserNumbersSet();
        System.out.println("Random numbers set: " + randomNumbersSet.toString());
        checkMatches();
        playWithCurrentRandomNumbersSet();
    }

    private void setGameSettings() {
        System.out.print("Type in your name: ");
        userName = scanner.next();
        do {
            System.out.print("Hello " + userName + "! Set how many (1-49) numbers you want to check: ");
            scanner.nextLine();
            if (scanner.hasNextInt())
                numbersToCheckCount = scanner.nextInt();
        } while (!(0 < numbersToCheckCount && numbersToCheckCount <= 49));

        System.out.println("OK " + userName + ", you want to check " + numbersToCheckCount + " numbers.\n");
    }

    private void createUserNumbersSet() {
        int numberOfNumber = 1;
        userNumbersSet = new HashSet<>();

        do {
            do {
                System.out.print("Type in your " + numberOfNumber + " number (1-49) and confirm it using ENTER button: ");
                scanner.nextLine();
                if (scanner.hasNextInt())
                    userNumber = scanner.nextInt();
            } while (!(0 < userNumber && userNumber <= 49));
            while (!(userNumbersSet.contains(userNumber))) {
                userNumbersSet.add(userNumber);
                numberOfNumber++;
            }
        } while (!(numbersToCheckCount == userNumbersSet.size()));

        System.out.println("\nUser numbers set: " + userNumbersSet.toString());
    }

    private void createRandomNumbersSet() {
        randomNumbersSet = new HashSet<>();
        do {
            int randomNumber = random.nextInt(50) + 1;
            randomNumbersSet.add(randomNumber);
        } while (!(numbersToCheckCount == randomNumbersSet.size()));
        System.out.println("Random numbers set: " + randomNumbersSet.toString());
    }

    private void checkMatches() {
        Set<Integer> matchesSet = new HashSet<>();
        for (int number : userNumbersSet) {
            if (randomNumbersSet.contains(number))
                matchesSet.add(number);
        }
        System.out.println("\nMatching numbers count: " + matchesSet.size());
        System.out.println("Matching numbers are: " + matchesSet.toString());
    }
}
