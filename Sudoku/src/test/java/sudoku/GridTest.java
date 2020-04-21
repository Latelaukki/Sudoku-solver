
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
    public void newConstantIsCorrectlyAddedToArray() {
        sudoku.addConstant(0,3,2);
        assertEquals(2,sudoku.getValue(3));
    }
    
    @Test
    public void returnTrueIfPointIsConstant() {
        sudoku.addConstant(1, 1, 1);
        assertEquals(true, sudoku.checkIfConstant(10));
    }
}

