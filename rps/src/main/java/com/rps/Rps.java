package com.rps;

import java.util.Random;
import java.util.Scanner;

public class Rps {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private String userName;
    private int roundsToWin;
    private int roundCount;
    private int computerChoice;
    private int userChoice;
    private int userScore;
    private int computerScore;
    private int unfairComputerChoice1;
    private int unfairComputerChoice2;
    private int unfairComputerChoice3;
    private int unfair;

    public void playGame() {
        roundCount = 0;
        userScore = 0;
        computerScore = 0;
        System.out.println("##### Welcome to Rock-Paper-Scissors game #####\n");
        setGameDetails();
        startGame();
        while ((userScore != roundsToWin) && (computerScore != roundsToWin)) {
            roundCount++;
            System.out.println("### Round number " + roundCount + " ###");
            userChoice();
            if (unfair == 0) {
                computerChoice();
            }
            if (unfair == 1) {
                unfairComputerChoice();;
            }
            playRound();
        }
        gameResult();
    }

    private void setGameDetails() {
        System.out.print("Type in your name: ");
        userName = scanner.next();
        System.out.print("Hello " + userName + "! Set the number of won rounds needed to win the game: ");
        roundsToWin = scanner.nextInt();
        System.out.print("Set fairness. Press \"f\" to play a fair game or press \"u\" to play unfair game.");
        userName = scanner.next();
        if (scanner.next().equals("f")) {
            unfair = 0;
        }
        if (scanner.next().equals("u")) {
            unfair = 1;
        }
    }

    private void startGame() {
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

    private void userChoice() {
        System.out.print("Choose your weapon: ");
        userChoice = scanner.nextInt();
    }

    private void computerChoice() {
        computerChoice = random.nextInt(3) + 1;
    }

    private void unfairComputerChoice() {
        unfairComputerChoice1 = userChoice;

        if (userChoice == 1) {
            unfairComputerChoice2 = 3;
        }
        if (userChoice == 2) {
            unfairComputerChoice2 = 1;
        }
        if (userChoice == 3) {
            unfairComputerChoice2 = 2;
        }

        if (userChoice == 1) {
            unfairComputerChoice3 = 2;
        }
        if (userChoice == 2) {
            unfairComputerChoice3 = 3;
        }
        if (userChoice == 3) {
            unfairComputerChoice3 = 1;
        }

        computerChoice = (random.nextInt(100) + 1);
        if ((1 <= computerChoice) && (computerChoice <= 25)) {
            computerChoice = unfairComputerChoice1;
        }
        if ((26 <= computerChoice) && (computerChoice <= 50)) {
            computerChoice = unfairComputerChoice2;
        }
        if ((51 <= computerChoice) && (computerChoice <= 100)) {
            computerChoice = unfairComputerChoice3;
        }
    }

    private void playRound() {
        System.out.println("Computer has chosen: " + computerChoice);
        System.out.println("You have chosen: " + userChoice);
        if (userChoice == computerChoice) {
            System.out.println("It is a tie!");
        } else {
            if ((userChoice == 1) && (computerChoice == 2)) {
                System.out.println("Paper covers rock. You lose!");
                computerScore++;
            }
            if ((userChoice == 1) && (computerChoice == 3)) {
                System.out.println("Rock crushes scissors. You win!");
                userScore++;
            }
            if ((userChoice == 2) && (computerChoice == 1)) {
                System.out.println("Paper covers rock. You win!");
                userScore++;
            }
            if ((userChoice == 2) && (computerChoice == 3)) {
                System.out.println("Scissors cuts paper. You lose!");
                computerScore++;
            }
            if ((userChoice == 3) && (computerChoice == 1)) {
                System.out.println("Rock crushes scissors. You lose!");
                computerScore++;
            }
            if ((userChoice == 3) && (computerChoice == 2)) {
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
        System.out.println(
                "### GAME RESULT ###\n" +
                        "Total rounds played: " + roundCount + "\n" +
                        "Your final score is: " + userScore + "\n" +
                        "Computer final score is: " + computerScore);

        if (userScore > computerScore) {
            System.out.println("Congratulations " + userName.toUpperCase() + ", you have won the game!");
        }
        if (userScore < computerScore) {
            System.out.println("Sorry " + userName.toUpperCase() + ", you have lost the game!");
        }
        if (userScore == computerScore) {
            System.out.println("It has been a tie in the game!");
        }
        System.out.println("Press \"x\" to quit or press \"n\" to play again.");
        if (scanner.next().equals("x")) {
            System.exit(0);
        }
        if (scanner.next().equals("n")) {
            playGame();
        }
    }
}