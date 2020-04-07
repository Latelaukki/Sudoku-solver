
package sudoku.domain;

import java.util.*;

public class Grid {
    int[][] grid;
    Point previous;
    ArrayList<Point> constants;
    
    public Grid() {
        grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = 0;
            }
        }
        this.constants = new ArrayList<>();
    }
    
    public void addConstant(Point p) {
        grid[p.getY()][p.getX()] = p.getValue();
        constants.add(p);
    }
    
    public void setNumber(int y, int x, int value) {
        grid[y][x] = value;
    }
 
    public ArrayList<Point> getConstants() {
        return constants;
    }
    
    public int getValue(int y, int x) {
        return grid[y][x];
    }
    
    public void addValueByOne(int y, int x) {
        grid[y][x] = grid[y][x] + 1;
    }
    
    public int[][] getGrid() {
        return grid;
    }
    
}