package com.sudoku;

public class SudokuRunner {
    public static void main(String[] args) {
        System.out.println(new SudokuBoard());

        UserInput userInput = new UserInput();

        userInput.userChoice();

//        boolean gameFinished = false;
//        while(!gameFinished) {
//            SudokuGame theGame = new SudokuGame();
//            gameFinished = theGame.solveSudoku();
//        }
    }
}
