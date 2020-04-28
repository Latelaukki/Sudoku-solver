  
package sudoku.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

public class SceneController implements Initializable {

     
    @FXML
    private Label display1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        display1.setText("SudokuSolver");
    }    
}