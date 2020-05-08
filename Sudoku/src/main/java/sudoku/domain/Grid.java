
package sudoku.domain;

import java.util.*;
import sudoku.logic.SudokuToString;

public class Grid {
    
    private ArrayList<Point> points;
    
    public Grid() {
        points = new ArrayList<>();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                    points.add(new Point(y, x, 0));
            }
        }
    }
    
    public void addConstant(int y, int x, int value) {
        for (Point p: points) {
            if (y == p.getY() && x == p.getX()) {
                p.setConstant(value);
            }
        }
    }
   
    public boolean checkIfConstant(int n) {
        return points.get(n).isConstant();
    }
      
    public int getValue(int n) {
        return points.get(n).getValue();
    }
    
    public int getY(int n) {
        return points.get(n).getY();
    }
    
    public int getX(int n) {
        return points.get(n).getX();
    }
    
    public void setNumber(int n, int value) {
        points.get(n).setNonConstantNumber(value);
    }
    
    public void deleteNumber(int y, int x) {
        this.setNumber(y * 9 + x, 0);
    }
    
    public ArrayList<Point> getPoints() {
        return this.points;
    }
    
    public void printSudoku() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println(" ----------------------------- ");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                if (points.get(i * 9 + j).getValue() == 0) {
                    System.out.print(" x ");
                } else {
                    if (points.get(i * 9 + j).isConstant()) {
                        System.out.println("*" + points.get(i * 9 + j).getValue() + "*");
                    } else {
                        System.out.print(" " + points.get(i * 9 + j).getValue() + " ");  
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println(" ----------------------------- ");
    }
    
    @Override
    public String toString() {
        SudokuToString toStr= new SudokuToString(points);
        String sudoku = toStr.getString();
        return sudoku;
    }
}