package com.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        rows.addAll(Arrays.asList(
                new SudokuRow(),
                new SudokuRow(),
                new SudokuRow(),
                new SudokuRow(),
                new SudokuRow(),
                new SudokuRow(),
                new SudokuRow(),
                new SudokuRow(),
                new SudokuRow()));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(" ___________________________________ \n");
        sb.append("|           |           |           |\n");

        int rowNumber = 1;
        for (SudokuRow row : rows) {
            sb.append(row);
            if (rowNumber++ % 3 == 0 && rowNumber < 8) {
                sb.append("|___________|___________|___________|\n");
                sb.append("|           |           |           |\n");
            }
        }

        sb.append("|___________|___________|___________|\n");

        return sb.toString();
    }
}
