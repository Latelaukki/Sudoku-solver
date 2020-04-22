
package sudoku.logic;

import sudoku.domain.Grid;

public class Solvefunctions {
    private Grid g;
    private int[][] t;
    private boolean exit;
    
    public Solvefunctions(Grid grid) {
        this.g = grid;
        t = new int[9][9];
        int n = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                t[i][j] = g.getValue(n);
                n++;
            }
        }
        this.exit = false;
    }
    
    public void solve(int n) {
        if (n == 81) {
            exit = true;
            return;
        }
        if (g.getValue(n) != 0) {
            solve(n + 1);
        } else {
            for (int value = 1; value < 10; value++) {
                if (checkTerms(n, value)) {
                    setNumber(n, value);
                    solve(n + 1);  
                }
                if (exit) {
                    return;
                }
            }
            setNumber(n, 0);
        }
    }
    
    public boolean checkTerms(int n, int value) {
        return (!checkRow(n, value) && !checkColumn(n, value) && !checkSquare(n, value));
    }

    public boolean checkRow(int n, int value) {
        int y = g.getY(n);
        int x = g.getX(n);
        for (int i = 0; i < 9; i++) {
            if (i == x) {
                continue;
            }
            if (t[y][i] == value) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkColumn(int n, int value) {
        int y = g.getY(n);
        int x = g.getX(n);
        for (int i = 0; i < 9; i++) {
            if (i == y) {
                continue;
            }
            if (t[i][x] == value) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkSquare(int n, int value) {
        int y = g.getY(n);
        int x = g.getX(n);
        int k = y - y % 3;
        int l = x - x % 3; 
        for (int i = k; i < k + 3; i++) {
            for (int j = l; j < l + 3; j++) {
                if (i == y && j == x) {
                    continue;
                }
                if (t[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void setNumber(int n, int value) {
        int y = g.getY(n);
        int x = g.getX(n);
        g.setNumber(n, value);
        t[y][x] = value;
    }
    
    public boolean isPossibleToSolve() {
        for (int n = 0; n < 81; n++) {
            if (g.getValue(n) != 0) {
                if (!checkTerms(n, g.getValue(n))) {
                return false;
                }
            }
        }
        return true;
    }
}
