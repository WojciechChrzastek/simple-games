package com.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuElement {
    private static int EMPTY = -1;
    private int value = EMPTY;
    private Set<Integer> possibleValues = new HashSet<>();

    public SudokuElement() {
        possibleValues.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Override
    public String toString() {
        if (value != EMPTY) {
            return String.valueOf(value);
        }
        return "-";
    }
}
