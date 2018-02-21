package com.rps;

import java.util.Scanner;

public class Rps {
    private Scanner scanner = new Scanner(System.in);
    private WeaponChoice weaponChoice = new WeaponChoice();
    private String userName;
    private String fairness;
    private int roundsToWin;
    private int roundCount;
    private int userScore;
    private int computerScore;

    private static RpsGameEngine rpsGameEngine = new RpsGameEngine();

    public void playGame() {
        roundCount = 0;
        userScore = 0;
        computerScore = 0;
        System.out.println("##### Welcome to the Rock-Paper-Scissors (+Lizzard-Spock) game #####\n-----");
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
            fairness = scanner.next();
        } while ((!fairness.equals("f")) && (!fairness.equals("u")));
    }

    private void startGame() {
        System.out.println("----------");
        System.out.println(
                "Game controls and rules:\n" +
                        "Press \"1\" to choose -> rock // Rock crushes scissors and lizard.\n" +
                        "Press \"2\" to choose -> paper // Paper covers rock and disproves spock.\n" +
                        "Press \"3\" to choose -> scissors // Scissors cuts paper and decapitates lizard.\n" +
                        "Press \"4\" to choose -> lizard // Lizard eats paper and poisons spock.\n" +
                        "Press \"5\" to choose -> spock // Spock vaporizes rock and smashes scissors.\n");
        System.out.println("Press \"ENTER\" to start the game!");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    private void playRound() {
        Weapon userWeapon = weaponChoice.userChoice();
        Weapon computerWeapon = null;
        if (fairness.equals("f")) {
            computerWeapon = weaponChoice.fairComputerChoice();
        }
        if (fairness.equals("u")) {
            computerWeapon = weaponChoice.unfairComputerChoice(userWeapon);
        }

        System.out.println("You have chosen: " + userWeapon);
        System.out.println("Computer has chosen: " + computerWeapon);

        Winner winner = rpsGameEngine.whoWin(userWeapon, computerWeapon);

        if (winner == Winner.TIE) {
            System.out.println("It is a tie!");
        } else {
            if (winner == Winner.USER) {
                System.out.println(userWeapon + " wins with " + computerWeapon + ". You win this round!");
                userScore++;
            }
            if (winner == Winner.COMPUTER) {
                System.out.println(userWeapon + " loses with " + computerWeapon + ". You lose this round!");
                computerScore++;
            }
        }

        System.out.println(
                "Rounds played so far: " + roundCount + "\n" +
                        "Your current score is: " + userScore + "\n" +
                        "Computer current score is: " + computerScore + "\n" +
                        "Score needed to win the game: " + roundsToWin + "\n");
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
            System.out.println("-----\n##### Thank you for playing the Rock-Paper-Scissors (+Lizzard-Spock) game #####");
            System.exit(0);
        }
        if (quitOrPlayAgain.equals("n")) {
            System.out.println("");
            playGame();
        }
    }
}
