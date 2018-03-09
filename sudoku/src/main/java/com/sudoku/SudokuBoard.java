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

/*    @Override
    public String toString() {
        for(SudokuRow x : rows)

        return rows.toString();
        
        "---------\n---------\n---------\n---------\n---------\n---------\n---------\n---------\n---------";
    }
    */
    }
}
