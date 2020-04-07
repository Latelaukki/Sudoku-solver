
package sudoku;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.domain.Grid;
import sudoku.domain.Point;

public class GridTest {
    
    Grid sudoku;
    Point p;
    
    @Before
    public void setUp() {
        sudoku = new Grid();
        p = new Point(0,3,2);
    }
    
    @Test
    public void sudokuIsCorrectlyInitialized() {
        int [][] ref = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
        assertArrayEquals(ref,sudoku.getGrid());
    }

    @Test
    public void newConstantIsCorrectlyAddedToArray() {
        int [][] ref = {{0,0,0,2,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
        sudoku.addConstant(p);
        assertArrayEquals(ref,sudoku.getGrid());
    }
    
    @Test
    public void newConstantIsCorrectlyAddedToList() {
        sudoku.addConstant(p);
        assertEquals(true,sudoku.getConstants().contains(p));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
