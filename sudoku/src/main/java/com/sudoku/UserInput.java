package com.sudoku;

import java.util.Scanner;

public class UserInput {

    //UserInput userInput = new UserInput();

    Scanner scanner = new Scanner(System.in);

    public int userChoice() {
        int userChoice;
        do {
            userChoice = getUserInput();
        } while (userChoice < 1 || userChoice > 9);
        System.out.println(userChoice);
        return userChoice;
    }

    private int getUserInput() {
        System.out.print("Choose number: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }



}
