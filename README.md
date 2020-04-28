# SudokuApp

The application offers a sudoku playing platform. The first version of the app enables user to input numbers of their choice to
a graphical interface and let the application solve the sudoku automatically or solve it by themselves.



## Documentation

[requirements_spesification.md](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/requirements_spesification.md)

[work_hour_tracking.md](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/work_hour_tracking.md)

[architecture.md](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/architecture.md)

[manual.md](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/manual.md)

[testing.md](https://github.com/Latelaukki/ot-harjoitustyo/blob/master/Documentation/testing.md)

## Command line commands

### Testing

Executing tests

mvn test

Test coverage report

mvn jacoco:report

Report can be viewed in target/site/jacoco/index.html

### Generating executable jar

Command

mvn package

Generates jar-file to target-dictionary

### JavaDoc

JavaDoc can be generated with command

mvn javadoc:javadoc

JavaDoc can be viewed in target/site/apidocs/index.html

### Checkstyle

Style check with rules defined in checkstyle.xml

mvn jxr:jxr checkstyle:checkstyle

Possible errors can be viewed in target/site/checkstyle.html
