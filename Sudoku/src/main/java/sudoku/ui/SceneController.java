  
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
import sudoku.Dice;

public class SceneController implements Initializable {
    private Dice dice;

    public SceneController() {
        dice = new Dice();
    }
     
    @FXML
    private Label display1;
    private TextField tf1;private TextField tf2;private TextField tf3;private TextField tf4;
    private TextField tf5;private TextField tf6;private TextField tf7;private TextField tf8;
    private TextField tf9;private TextField tf10;private TextField tf11;private TextField tf12;
    private TextField tf13;private TextField tf14;private TextField tf15;private TextField tf16;
    private TextField tf17;private TextField tf18;private TextField tf19;private TextField tf20;
    private TextField tf21;private TextField tf22;private TextField tf23;private TextField tf24;
    private TextField tf25;private TextField tf26;private TextField tf27;private TextField tf28;
    private TextField tf29;private TextField tf30;private TextField tf31;private TextField tf32;
    private TextField tf33;private TextField tf34;private TextField tf35;private TextField tf36;
    private TextField tf37;private TextField tf38;private TextField tf39;private TextField tf40;
    private TextField tf41;private TextField tf42;private TextField tf43;private TextField tf44;
    private TextField tf45;private TextField tf46;private TextField tf47;private TextField tf48;
    private TextField tf49;private TextField tf50;private TextField tf51;private TextField tf52;
    private TextField tf53;private TextField tf54;private TextField tf55;private TextField tf56;
    private TextField tf57;private TextField tf58;private TextField tf59;private TextField tf60;
    private TextField tf61;private TextField tf62;private TextField tf63;private TextField tf64;
    private TextField tf65;private TextField tf66;private TextField tf67;private TextField tf68;
    private TextField tf69;private TextField tf70;private TextField tf71;private TextField tf72;
    private TextField tf73;private TextField tf74;private TextField tf75;private TextField tf76;
    private TextField tf77;private TextField tf78;private TextField tf79;private TextField tf80;
    private TextField tf81;
    
    @FXML
    private void onlyOneChar(ActionEvent event) {
        TextField textField = new TextField();
        textField.setTextFormatter(new TextFormatter<String>((Change change) -> {
        String newText = change.getControlNewText();
        if (newText.length() > 1) {
            return null ;
        } else {
            return change ;
        }
        }));
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        dice.roll();
        display1.setText("you got "+dice.getValue());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        display1.setText("dice not rolled yet...");
    }    
}