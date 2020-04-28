package sudoku.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
        
        stage.setTitle("SudokuSolver");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}