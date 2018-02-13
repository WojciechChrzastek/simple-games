package com.rps;

import java.util.Random;
import java.util.Scanner;

import static com.rps.Weapon.PAPER;
import static com.rps.Weapon.ROCK;
import static com.rps.Weapon.SCISSORS;

public class Rps {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private String userName;
    private int roundsToWin;
    private int roundCount;
    private int userScore;
    private int computerScore;
    private String unfair;

    public void playGame() {
        roundCount = 0;
        userScore = 0;
        computerScore = 0;
        System.out.println("##### Welcome to Rock-Paper-Scissors game #####\n");
        setGameSettings();
        startGame();
        while ((userScore != roundsToWin) && (computerScore != roundsToWin)) {
            roundCount++;
            System.out.println("### Round number " + roundCount + " ###");
            playRound();
        }
        gameResult();
    }

    private void setGameSettings() {
        System.out.print("Type in your name: ");
        userName = scanner.next();
        do {
            System.out.print("Hello " + userName + "! Set the number of won rounds needed to win the game: ");
            scanner.nextLine();
        } while (!scanner.hasNextInt());
        roundsToWin = scanner.nextInt();
        do {
            System.out.print("Set fairness. Press \"f\" to play a fair game or press \"u\" to play unfair game: ");
            unfair = scanner.next();
        } while ((!unfair.equals("f")) && (!unfair.equals("u")));
    }

    private void startGame() {
        String dupa;
        System.out.println("----------");
        System.out.println(
                "Controls:\n" +
                        "Press \"1\" to choose -> rock\n" +
                        "Press \"2\" to choose -> paper\n" +
                        "Press \"3\" to choose -> scissors\n");
        System.out.println("Press \"ENTER\" to start the game!");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    private Weapon userChoice() {
        int userChoice;
        do {
            System.out.print("Choose your weapon: ");
            scanner.nextLine();
        } while (!scanner.hasNextInt());
        do {
            userChoice = scanner.nextInt();
        } while (userChoice != 1 && userChoice != 2 && userChoice != 3);
        return Weapon.intToEnum(userChoice);
    }

    private Weapon computerChoice() {
        int computerChoice = random.nextInt(3) + 1;
        return Weapon.intToEnum(computerChoice);
    }

    private Weapon unfairComputerChoice(Weapon userWeapon) {
        int randomNumber = (random.nextInt(100) + 1);
        if ((1 <= randomNumber) && (randomNumber <= 25)) {
            return computerLoseWeapon(userWeapon);
        }
        if ((26 <= randomNumber) && (randomNumber <= 50)) {
            return userWeapon;
        }
        return computerWinWeapon(userWeapon);
    }

    private Weapon computerLoseWeapon(Weapon weapon) {
        switch (weapon) {
            case ROCK:
                return SCISSORS;
            case PAPER:
                return ROCK;
            case SCISSORS:
                return PAPER;
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
            default:
                return null;
        }
    }

    private void playRound() {
        Weapon userWeapon = userChoice();
        Weapon computerWeapon = null;
        if (unfair.equals("f")) {
            computerWeapon = computerChoice();
        }
        if (unfair.equals("u")) {
            computerWeapon = unfairComputerChoice(userWeapon);
        }

        System.out.println("Computer has chosen: " + computerWeapon);
        System.out.println("You have chosen: " + userWeapon);
        if (userWeapon == computerWeapon) {
            System.out.println("It is a tie!");
        } else {
            if ((userWeapon == ROCK) && (computerWeapon == PAPER)) {
                System.out.println("Paper covers rock. You lose!");
                computerScore++;
            }
            if ((userWeapon == ROCK) && (computerWeapon == SCISSORS)) {
                System.out.println("Rock crushes scissors. You win!");
                userScore++;
            }
            if ((userWeapon == PAPER) && (computerWeapon == ROCK)) {
                System.out.println("Paper covers rock. You win!");
                userScore++;
            }
            if ((userWeapon == PAPER) && (computerWeapon == SCISSORS)) {
                System.out.println("Scissors cuts paper. You lose!");
                computerScore++;
            }
            if ((userWeapon == SCISSORS) && (computerWeapon == ROCK)) {
                System.out.println("Rock crushes scissors. You lose!");
                computerScore++;
            }
            if ((userWeapon == SCISSORS) && (computerWeapon == PAPER)) {
                System.out.println("Scissors cuts paper. You win!");
                userScore++;
            }
        }
        System.out.println(
                "Rounds played so far: " + roundCount + "\n" +
                        "Your current score is: " + userScore + "\n" +
                        "Computer current score is: " + computerScore + "\n");
    }

    private void gameResult() {
        String quitOrPlayAgain;
        System.out.println(
                "### GAME RESULT ###\n" +
                        "Total rounds played: " + roundCount + "\n" +
                        "Your final score is: " + userScore + "\n" +
                        "Computer final score is: " + computerScore);

        if (userScore > computerScore) {
            System.out.println("Congratulations " + userName.toUpperCase() + ", you have won the game!\n");
        }
        if (userScore < computerScore) {
            System.out.println("Sorry " + userName.toUpperCase() + ", you have lost the game!\n");
        }
        if (userScore == computerScore) {
            System.out.println("It has been a tie in the game!\n");
        }
        do {
            System.out.print("Press \"x\" to quit or press \"n\" to play again: ");
            quitOrPlayAgain = scanner.next();
        } while ((!quitOrPlayAgain.equals("x")) && (!quitOrPlayAgain.equals("n")));
        if (quitOrPlayAgain.equals("x")) {
            System.exit(0);
        }
        if (quitOrPlayAgain.equals("n")) {
            System.out.println("");
            playGame();
        }
    }
}