
package sudoku.logic;

import java.util.*;
import sudoku.domain.Grid;
import sudoku.domain.Point;

public class Solvefunctions {
    private Grid g;
    
    public Solvefunctions(Grid grid) {
        this.g = grid;
    }
    
    public void solve(int y, int x, Point previous) {
        if (y == 8 && x == 9) {
            return;
        }
        if (x == 9) {
            y++;
            x = 0;
        }
        int value = g.getValue(y, x);
        Point present = new Point(y, x, value);
        if (checkIfConstant(present)) {
            if (previous.getX() == 0 && previous.getY() > y) {  //edellinen piste oli seuraavalla rivillä
                solve(previous.getY() - 1, 8, present);
            }
            if (previous.getX() > x) { //edellinen piste oli x+1 
                solve(y, x - 1, present);               
            }
            solve(y, x + 1, present);
        }
        if (!checkRow(present) || !checkColumn(present) || !checkSquare(present)) {
            if (value == 9) {
                if (previous.getX() > x || previous.getY() > y) {
                    solve(y, x - 1, present);
                }
                g.addValueByOne(y, x);
                solve(y, x, present);            
            }
            solve(y, x + 1, present);
        }
    }
    
    public boolean checkIfConstant(Point p) {
        return g.getConstants().contains(p);
    }
    
    public boolean checkRow(Point p) {
        for (int i = 0; i < 9; i++) {
            if (i == p.getX()) {
                continue;
            }
            if (g.getGrid()[p.getY()][i] == p.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkColumn(Point p) {
        for (int i = 0; i < 9; i++) {
            if (i == p.getY()) {
                continue;
            }
            if (g.getGrid()[i][p.getX()] == p.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkSquare(Point p) {
        int y = p.getY() % 3;
        int x = p.getX() % 3;
        int k = p.getY() - y;
        int l = p.getX() - x;
        for (int i = k; i < k + 3; i++) {
            for (int j = l; j < l + 3; j++) {
                if (i == p.getY() && j == p.getX()) {
                    continue;
                }
                if (g.getGrid()[i][j] == p.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
