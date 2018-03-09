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


/*    @Override
    public String toString() {
        for(SudokuElement x : elements)

            return elements.toString();

        "---------";

        return
*/    }
}
