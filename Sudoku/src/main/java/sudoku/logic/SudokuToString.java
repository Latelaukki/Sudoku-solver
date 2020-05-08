
package sudoku.logic;

import java.util.ArrayList;

import sudoku.domain.Point;

public class SudokuToString {
    
    ArrayList<Point> points = new ArrayList<>();
    
    public SudokuToString(ArrayList<Point> points) {
        this.points = points;
    }
    
    public String getString() {
        String sudoku = "";
        for (int i = 0; i < 9; i++) {
            sudoku = sudoku + checkIfHorizontalLine(i);
            for (int j = 0; j < 9; j++) {
                sudoku = sudoku + checkIfVerticalLine(j);
                if (checkIfZero(i, j)) {
                    sudoku = sudoku + " x ";
                } else {
                    if (checkIfConstant(i, j)) {
                        sudoku = sudoku + "*" + points.get(i * 9 + j).getValue() + "*";
                    } else {
                        sudoku = sudoku + " " + points.get(i * 9 + j).getValue() + " ";
                    }
                }
            }
            sudoku = sudoku + "|\n";
        }
        sudoku = sudoku + " ----------------------------- ";
        return sudoku;
    }
    
    public String checkIfHorizontalLine(int i) {
        if (i % 3 == 0) {
            return " ----------------------------- \n";
        }
        return "";
    }
    
    public String checkIfVerticalLine(int j) {
        if (j % 3 == 0) {
            return "|";
        }
        return "";
    }
    
    public boolean checkIfZero(int i, int j) {
        return points.get(i * 9 + j).getValue() == 0;
    }
    
    public boolean checkIfConstant(int i, int j) {
        return points.get(i * 9 + j).isConstant();
    }
}
