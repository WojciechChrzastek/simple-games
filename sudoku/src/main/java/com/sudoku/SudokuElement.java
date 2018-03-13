package com.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SudokuElement {
    private static int EMPTY = -1;
    private int value;
    private Set<Integer> possibleValues = new HashSet<>();

    public SudokuElement() {
        createRandomValue();

        //possibleValues.addAll(Arrays.asList(EMPTY, createRandomValue()));
    }

    public void createRandomValue() {
        Random random = new Random();
        int randomValue;
        randomValue = random.nextInt(10);
        if (randomValue == 0 ) {
            value = EMPTY;
        } else {
            value = randomValue;
        }
    }


    @Override
    public String toString() {
        if (value != EMPTY) {
            return String.valueOf(value);
        }
        return "-";
    }
}
