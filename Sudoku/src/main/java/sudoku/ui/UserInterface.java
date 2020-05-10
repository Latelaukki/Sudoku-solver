package sudoku.ui;

import java.util.*;
import java.util.Scanner;
import sudoku.dao.FileManagement;

import sudoku.domain.Grid;
import sudoku.domain.Point;
import sudoku.logic.SolveFunctions;

public class UserInterface {

    public void start() {
        Grid sudoku = new Grid();
        Scanner reader = new Scanner(System.in);
        System.out.println("Hello, welcome to SudokuSolver. Here you can solve your Sudoku. You have to insert your own "
               + "numbers by giving their x and y coordinate on the grid. \nIf you insert a wrong number, you can also delete it. "
                + "\nNOTE: If you enter less than 17 numbers, solution will NOT be well-defined for certain. That does not mean "
                + "that 17 numbers guarantees unique answer. That varies between different Sudoku puzzles"
                + "\n\nCommands are: ");
        System.out.println("1 -- Insert a number");
        System.out.println("2 -- Delete a number");
        System.out.println("3 -- Print Sudoku");
        System.out.println("4 -- Solve");
        System.out.println("5 -- Empty");
        System.out.println("6 -- Load a game");
        System.out.println("7 -- Save the game");
        System.out.println("8 -- Exit\n");
        while(true) {
            System.out.println("Your command: ");
            int cmd;
            try {
                cmd  = Integer.valueOf(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid command");
                continue;
            }
            if (cmd == 0 || cmd > 8) {
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
                    if (sudoku.getValue((y-1) * 9 + (x-1)) != 0) {
                        while(true) {
                            System.out.println("There is already a number in these coordinates. Do you want to overwrite it? (y/n)");
                            String ans = reader.nextLine();
                            if (ans.equals("y")) {
                                sudoku = new Grid();
                                continue;
                            }
                            if (ans.equals("n")) {
                                break;
                            }
                        }
                    }
                    while(true) {
                        System.out.println("Is the number a constant or your guess for the number? (c/g)");
                        String ans = reader.nextLine();
                        if (ans.equals("c")) {
                            sudoku.addConstant(y-1, x-1, value);
                            break;
                        }
                        if (ans.equals("g")) {
                            sudoku.setNumber((y-1) * 9 + (x-1), value);
                            break;
                        }
                    } 
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
                    System.out.println("*x* = constant number");
                    System.out.println("x = guessed number");
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
                    FileManagement manager = new FileManagement();
                    ArrayList<String> games = new ArrayList<>();
                    try {
                        games = manager.searchForGames();
                    } catch (Exception e) {
                        System.out.println("There are no saved games");
                        break;
                    }
                    if (games.isEmpty()) {
                        System.out.println("There are no saved games");
                        break;
                    }
                    System.out.println("Which game do you want to load?");
                    System.out.println("Saved games: ");
                    System.out.println(games);
                    String name = reader.nextLine();
                    try {
                        ArrayList<Point> points = manager.loadFromFile(name);
                        sudoku.setPoints(points);
                    } catch (Exception e) {
                        System.out.println("No game found by this name.");
                        break;
                    }
                    break;
                case 7:                 
                    manager = new FileManagement();
                    manager.createFile();
                    System.out.println("New 'sudoku' file created");
                    System.out.println("Name of the game: ");
                    name = reader.nextLine();
                    if (manager.checkIfGameExists(name)) {
                            System.out.println("Saving failed. A game by that name already exists.");
                            break;
                    } else {
                        try {
                            manager.saveNewGame(name, sudoku.getPoints());
                        } catch (Exception e) {
                            System.out.println("Don't save two times in a row. I mean, I couldn't fix this bug...");
                        }                      
                    }
                    break;
                case 8:
                    while(true) {
                        System.out.println("Are you sure you want to exit? You will lost any unsaved progress. (y/n)");
                        String ans = reader.nextLine();
                        if (ans.equals("y")) {
                            System.out.println("Exiting solver.");
                            return;
                        }
                        if (ans.equals("n")) {
                            break;
                        }
                    }
            }
       }
    }    
}