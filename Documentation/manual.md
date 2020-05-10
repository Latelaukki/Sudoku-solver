# Manual

Load [sudoku.jar](https://github.com/Latelaukki/ot-harjoitustyo/releases/tag/viikko7) file

## Starting the application

Start the application with command:

*java -jar sudoku.jar*

## Using the application

Application is very simple to use. When you start the program, it will tell you all the commands. You use your keyboard to input commands from 1-9. 

1 -- Insert a number:   Insert your own numbers. You have to choose, whether the number is a constant number or just guess. 
2 -- Delete a number:   Remove number if you want to change it.
3 -- Print Sudoku:      Print out your Sudoku as a text format. Only way to see your progress. 
4 -- Solve:             Solve the puzzle. Application will always give a solution but there might be more solutions if you don't insert at                         least 17. Application will tell you if there is none.
5 -- Empty:             Reset all the numbers.
6 -- Load a game:       Load a game from database. Game has to be saved first before you can do this.
7 -- Save your puzzle:  Save your puzzle to database. NOTE: The application will create a new file "sudoku.db".
8 -- Exit:              Close the application. You will lose all unsaved progress.
