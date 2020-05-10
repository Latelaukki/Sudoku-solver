# Applications Architecture

## Package structure

The application has three package layers with four packages in total. Sudoku.ui package consists of the user interface. This package implements sudoku.logic and sudoku.dao. Sudoku.logic consist of the solving funtioncs and creating sudoku string for printing and sudoku.dao manages saving and loading from the file. These packages don't communicate with each other but they both implement Sudoku.domain includes sudoku data structures. 
![package structure](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/images/r-2.png)

## User interface

User interface is in a text format in this release. Interface starts by telling all the commands there are available for the user.  Interface does not have different profiles, although it is computer specific when it comes to the file system. More of this in the file section.

Interface is mostly isolated from logic functions. 

## Application logic

Sudoku is quite simple game and therefore the main data structure is also simple. Classes Grid and Point create the main structure which all the other classes refer either directly or between indirectly.

![main classes](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/images/r-4.png)

Grid class includes methods for editing the puzzle directly by adding or removing numbers from the puzzle. This methods are setNumber/addConstant, which depends whether user wants to insert their own guess or already known number, and deleteNumber.

## Files and game data

User is able to save their progress. This can be done via FileManagement class which creates a file named "sudoku" in users project's folder if it's not already created. There are no profiles in the game, so the database is saved on user's computer. User can save or load their data from the database which is created by using SQL.

## Sequence diagram

![sequence diagram](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/images/r-3.png)


## Weak points in the structure

### Packages and classes

There should a class in sudoku.logic package which handles all the operations between sudoku.ui and sudoku.domain for modifying only the data structures without solving it. A "Game" class or something would definitely improve the structure. Also, because there is no single class for all the user functions, there is little weird relation between toString() in sudoku.domain and Sudoku.ToString in sudoku.logic. In addition, there are a lot of error handlers which probably should need their own class. 

### User interface

Playing Sudoku with a text UI is definitely not optimal. If you really want to try to solve the puzzle yourself, you really need GUI for it. Therefore, it would probably be the first in line in further development.

### Handling data

SQL is pretty complicated way to store simple data. Therefore it would probably be better to use some other way to manage it. 
