package sudoku.ui;

import java.util.*;
import java.util.Scanner;

import sudoku.domain.Grid;
import sudoku.logic.SolveFunctions;

public class Interface {

    public void start() {
        Grid sudoku = new Grid();
        Scanner reader = new Scanner(System.in);
        System.out.println("Hello, welcome to SudokuSolver. Here you can solve your Sudoku. You have to insert your own "
               + "numbers by giving their x and y coordinate on the grid. \nIf you insert a wrong number, you can also delete it. "
                + "NOTE: If you enter less than 17 numbers, solution will NOT be well-defined for certain. That does not mean "
                + "that 17 numbers guarantees unique answer. That varies between different Sudoku puzzles"
                + "\n\nCommands are: ");
        System.out.println("1 -- Insert a new number");
        System.out.println("2 -- Delete a number");
        System.out.println("3 -- Print");
        System.out.println("4 -- Solve");
        System.out.println("5 -- Empty");
        System.out.println("6 -- Exit");
        while(true) {
            System.out.println("Your command: ");
            int cmd;
            try {
                cmd  = Integer.valueOf(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid command");
                continue;
            }
            if (cmd == 0 || cmd > 6) {
                    System.out.println("That is not a valid command");
                    continue;
            }
            switch(cmd) {
                case 1:
                    int x = 0;
                    int y = 0;
                    int value = 0;
                    while(true) {
                        System.out.println("Enter the x-coordinate (1-9): ");
                        try {
                        x  = Integer.valueOf(reader.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("That is not a number.");
                            continue;
                        }
                        if (x < 1 || x > 9) {
                            System.out.println("The coordinate is out of range.");
                            continue;
                        }
                        break;                
                    }
                    while(true) {
                        System.out.println("Enter the y-coordinate (1-9): ");
                        try {
                        y  = Integer.valueOf(reader.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("That is not a number.");
                            continue;
                        }
                        if (y < 1 || y > 9) {
                            System.out.println("The coordinate is out of range.");
                            continue;
                        }
                        break;
                    }
                    while(true) {
                        System.out.println("Enter the value of the number (1-9): ");
                        try {
                        value  = Integer.valueOf(reader.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("That is not a number.");
                            continue;
                        }
                        if (value < 1 || value > 9) {
                            System.out.println("The value is out of range.");
                            continue;
                        }
                        break;
                    }
                    sudoku.addConstant(y-1, x-1, value);
                    break;
                case 2:
                    x = 0;
                    y = 0;
                    while(true) {
                        System.out.println("Enter the x-coordinate (1-9): ");
                        try {
                        x  = Integer.valueOf(reader.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("That is not a number.");
                            continue;
                        }
                        if (x < 1 || x > 9) {
                            System.out.print("The coordinate is out of range.");
                            continue;
                        }
                        break;                
                    }
                    while(true) {
                        System.out.println("Enter the y-coordinate (1-9): ");
                        try {
                        y  = Integer.valueOf(reader.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("That is not a number.");
                            continue;
                        }
                        if (y < 1 || y > 9) {
                            System.out.println("The coordinate is out of range.");
                            continue;
                        }
                        break;
                    }
                    sudoku.deleteNumber(y-1, x-1); 
                    break;
                case 3:
                    System.out.println(sudoku);
                    break;
                case 4:
                    SolveFunctions solver = new SolveFunctions(sudoku);
                    if(!solver.isPossibleToSolve()) {
                        System.out.println("Sudoku can't be solved. Initialize new Sudoku or delete wrong numbers.");
                    }
                    else {
                        solver.solve(0);
                        System.out.println("Sudoku solved.");
                    }
                    break;
                case 5:
                    while(true) {
                        System.out.println("Are you sure you want to empty your Sudoku? (y/n)");
                        String ans = reader.nextLine();
                        if (ans.equals("y")) {
                            sudoku = new Grid();
                            break;
                        }
                        if (ans.equals("n")) {
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting solver.");
                    return;
            }
       }
    }    
}