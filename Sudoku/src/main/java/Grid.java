
import java.util.*;

public class Grid {
    private int[][] grid;
    private ArrayList<Point> constants;
    
    public Grid(int[][] grid) {
        this.grid = new int[9][9];
        this.constants = new ArrayList<>();
    }
    
    public void setNumber(int x, int y, int value) {
        grid[x-1][y-1] = value;
    }
    
    public void setConstant(int x, int y, int value) {
        Point p = new Point(x,y,value);
        constants.add(p);
    }
    
    public boolean checkIfConstant(int x, int y) {
        
    }
    
    
    public int getValue(int x, int y) {
        return grid[x-1][y-1];
    }
}
