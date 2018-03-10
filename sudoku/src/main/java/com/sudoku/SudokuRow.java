package com.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> elements = new ArrayList<>();

    public SudokuRow() {
        elements.addAll(Arrays.asList(
                new SudokuElement(),
                new SudokuElement(),
                new SudokuElement(),
                new SudokuElement(),
                new SudokuElement(),
                new SudokuElement(),
                new SudokuElement(),
                new SudokuElement(),
                new SudokuElement()));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("|   ");

        int elementNumber = 1;
        for (SudokuElement element : elements) {
            sb.append(element).append(" ");
            if (elementNumber++ % 3 == 0 && elementNumber < 8) {
                sb.append("  |   ");
            }
        }

        sb.append("  |\n");
        return sb.toString();
    }
}
