//
//package sudoku;
//
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import sudoku.domain.Grid;
//import sudoku.logic.Solvefunctions;
//import sudoku.domain.Point;
//
//public class SolvefunctionsTest {
//    
//    Grid grid;
//    Solvefunctions solver;
//    
//    @Before
//    public void setUp() {
//        grid = new Grid();
//        grid.addConstant(0,1,7);
//        grid.addConstant(0,2,4);
//        grid.addConstant(0,5,1);
//        grid.addConstant(0,6,2);
//        grid.addConstant(1,8,6);
//        grid.addConstant(2,3,8);
//        grid.addConstant(2,7,5);
//        grid.addConstant(2,8,9);
//        grid.addConstant(3,3,2);
//        grid.addConstant(3,4,3);
//        grid.addConstant(4,0,9);
//        grid.addConstant(4,4,7);
//        grid.addConstant(4,5,5);
//        grid.addConstant(5,1,1);
//        grid.addConstant(5,8,8);
//        grid.addConstant(6,0,7);
//        grid.addConstant(6,1,5);
//        grid.addConstant(6,4,2);
//        grid.addConstant(6,6,9);
//        grid.addConstant(7,1,3);
//        grid.addConstant(7,3,5);
//        grid.addConstant(8,0,6);
//        grid.addConstant(1,0,8); //extra
//        grid.addConstant(0,0,5); //extra
//        solver = new Solvefunctions(grid);
//    }
//
//    @Test
//    public void checkRowWithSameNumberReturnTrue() {
//        assertEquals(true,solver.checkRow(12, 6));
//    }
//    
//    @Test
//    public void checkRowWithDifferentNumbersReturnFalse() {
//        assertEquals(false,solver.checkRow(12, 7));
//        assertEquals(false,solver.checkRow(10, 9));
//    }
//    
//    @Test
//    public void checkColumnWithSameNumberReturnTrue() {
//        assertEquals(true,solver.checkColumn(12, 5));
//    }
//    
//    @Test
//    public void checkColumnWithDifferentNumbersReturnFalse() {
//        assertEquals(false,solver.checkColumn(13, 5));
//        assertEquals(false,solver.checkRow(10, 9));
//    }
//    
//    @Test
//    public void checkSquareWithSameNumberReturnTrue() {
//        assertEquals(true,solver.checkSquare(13, 1));
//    }
//    
//    @Test
//    public void checkSquareWithDifferentNumbersReturnFalse() {
//        assertEquals(false,solver.checkSquare(13, 2));
//        assertEquals(false,solver.checkRow(10, 9));
//    }
//    
////    @Test
////    public void ifPointIsConstantReturnTrue() {
////        p = new Point(3,3,2);
////        assertEquals(true,solver.checkIfConstant(3,3));
////    }
////    
////    @Test
////    public void ifPointIsNotConstantReturnFalse() {
////        p = new Point(3,2,2);
////        assertEquals(false,solver.checkIfConstant(3,2));
////    }
//}
