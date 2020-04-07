
package sudoku;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import sudoku.domain.Grid;
import sudoku.logic.Solvefunctions;
import sudoku.domain.Point;

public class SolvefunctionsTest {
    
    Point p;
    Grid sudoku;
    Solvefunctions solver;
    
    @Before
    public void setUp() {
        sudoku = new Grid();
        sudoku.addConstant(new Point(0,1,7));
        sudoku.addConstant(new Point(0,2,4));
        sudoku.addConstant(new Point(0,5,1));
        sudoku.addConstant(new Point(0,6,2));
        sudoku.addConstant(new Point(1,8,6));
        sudoku.addConstant(new Point(2,3,8));
        sudoku.addConstant(new Point(2,7,5));
        sudoku.addConstant(new Point(2,8,9));
        sudoku.addConstant(new Point(3,3,2));
        sudoku.addConstant(new Point(3,4,3));
        sudoku.addConstant(new Point(4,0,9));
        sudoku.addConstant(new Point(4,4,7));
        sudoku.addConstant(new Point(4,5,5));
        sudoku.addConstant(new Point(5,1,1));
        sudoku.addConstant(new Point(5,8,8));
        sudoku.addConstant(new Point(6,0,7));
        sudoku.addConstant(new Point(6,1,5));
        sudoku.addConstant(new Point(6,4,2));
        sudoku.addConstant(new Point(6,6,9));
        sudoku.addConstant(new Point(7,1,3));
        sudoku.addConstant(new Point(7,3,5));
        sudoku.addConstant(new Point(8,0,6));
        solver = new Solvefunctions(sudoku);
    }

    @Test
    public void checkRowWithSameNumberReturnFalse() {
        p = new Point(0,3,2);
        assertEquals(false,solver.checkRow(p));
    }
    
    @Test
    public void checkRowWithDifferentNumbersReturnTrue() {
        p = new Point(0,3,6);
        assertEquals(true,solver.checkRow(p));
    }
    
    @Test
    public void checkColumnWithSameNumberReturnFalse() {
        p = new Point(0,3,2);
        assertEquals(false,solver.checkColumn(p));
    }
    
    @Test
    public void checkColumnWithDifferentNumbersReturnTrue() {
        p = new Point(0,3,6);
        assertEquals(true,solver.checkColumn(p));
    }
    
    @Test
    public void checkSquareWithSameNumberReturnFalse() {
        p = new Point(0,3,8);
        assertEquals(false,solver.checkSquare(p));
    }
    
    @Test
    public void checkSquareWithDifferentNumbersReturnTrue() {
        p = new Point(0,3,6);
        assertEquals(true,solver.checkSquare(p));
    }
    
    @Test
    public void ifPointIsConstantReturnTrue() {
        p = new Point(3,3,2);
        assertEquals(true,solver.checkIfConstant(p));
    }
    
    @Test
    public void ifPointIsNotConstantReturnFalse() {
        p = new Point(3,2,2);
        assertEquals(false,solver.checkIfConstant(p));
    }
}
