# Applications Architecture

## Package structure

The application has three package layers with four packages in total. Sudoku.ui package consists of the user interface. This package implements sudoku.logic and sudoku.dao. Sudoku.logic consist of the solving funtioncs and creating sudoku string for printing and sudoku.dao manages saving and loading from the file. These packages don't communicate with each other but they both implement Sudoku.domain includes sudoku data structures. 
![package structure](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/images/r-2.png)

## User interface

User interface is in a text format in this release. Interface starts by telling all the commands there are available for the user.  Interface does not have different profiles, although it is computer specific when it comes to the file system. More of this in the file section.

Interface is mostly isolated from logic functions. 

## Sequence diagram

![sequence diagram](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/images/r-3.png)


## Weak points in the structure

There should a class in sudoku.logic package which handles all the operations between sudoku.ui and sudoku.domain for modifying only the data structures wihtout solving it.
However, there are a lot of error handlers which probably should need their own class.
