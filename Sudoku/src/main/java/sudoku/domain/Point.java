
package sudoku.domain;

public class Point {    
    private int y;
    private int x;
    private int value;
    private boolean constant;

    public Point(int y, int x, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
        this.constant = false;
    }
    
    public void setConstant(int value) {
        this.value = value;
        this.constant = true;
    }
    
    public void setNonConstantNumber(int value) {
        this.value = value;
    }
    
    public boolean isConstant() {
        return this.constant;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getValue() {
        return this.value;
    }
}
