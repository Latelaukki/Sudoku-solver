    
package sudoku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
         
import sudoku.domain.Point;

public class FileManagement {
    
    final private WriteToDatabase writer;
    final private LoadFromDatabase loader;
    private Connection db;

    public FileManagement() {
        this.writer = new WriteToDatabase();
        this.loader = new LoadFromDatabase();
        try {
            this.db = DriverManager.getConnection("jdbc:sqlite:sudoku.db"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createFile() {
        try {      
            writer.create(db);
        } catch (SQLException e) {
        }
    }
    
    public ArrayList<String> searchForGames() throws Exception {
        return loader.listGames(db);
    }
    
    public ArrayList<Point> loadFromFile(String gameName) throws Exception {
        int id = getGameId(gameName);
        ArrayList<Point> points = loader.loadPoints(db, id);
        return points;
    }
    
    public boolean checkIfGameExists(String gameName) {
        try {         
            loader.getSavedGameId(db, gameName);        
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public void saveNewGame(String gameName, ArrayList<Point> points) throws Exception {      
        writer.addNewGame(db, gameName);
        int id = getGameId(gameName);
        writer.addPoints(db, id, points);
    }
    
    public int getGameId(String gameName) throws Exception {
        int id = loader.getSavedGameId(db, gameName);
        return id;
    }
    
}
