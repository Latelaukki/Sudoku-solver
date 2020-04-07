
package sudoku.ui;

import java.util.*;
import sudoku.domain.Grid;
import sudoku.domain.Point;
import sudoku.logic.Solvefunctions;

public class TextUi {
   Grid grid = new Grid();
   
   public void start() {
       grid.addConstant(new Point(0,1,7));
       grid.addConstant(new Point(0,2,4));
       grid.addConstant(new Point(0,5,1));
       grid.addConstant(new Point(0,6,2));
       grid.addConstant(new Point(1,8,6));
       grid.addConstant(new Point(2,3,8));
       grid.addConstant(new Point(2,7,5));
       grid.addConstant(new Point(2,8,9));
       grid.addConstant(new Point(3,3,2));
       grid.addConstant(new Point(3,4,3));
       grid.addConstant(new Point(4,0,9));
       grid.addConstant(new Point(4,4,7));
       grid.addConstant(new Point(4,5,5));
       grid.addConstant(new Point(5,1,1));
       grid.addConstant(new Point(5,8,8));
       grid.addConstant(new Point(6,0,7));
       grid.addConstant(new Point(6,1,5));
       grid.addConstant(new Point(6,4,2));
       grid.addConstant(new Point(6,6,9));
       grid.addConstant(new Point(7,1,3));
       grid.addConstant(new Point(7,3,5));
       grid.addConstant(new Point(8,0,6));
       Solvefunctions solver = new Solvefunctions(grid);
       System.out.println(Arrays.deepToString(grid.getGrid()));
       solver.solve(0, 0, new Point(0,0,1));
   }
}
