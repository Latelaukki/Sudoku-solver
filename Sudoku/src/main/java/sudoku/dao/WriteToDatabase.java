
package sudoku.dao;

import java.sql.*;
import java.util.*;

import sudoku.domain.Point;

public class WriteToDatabase  {
    
    public void create(Connection db) throws SQLException {
        Statement s = db.createStatement();
        s.execute("CREATE TABLE Games (id INTEGER PRIMARY KEY, name TEXT)");
        s.execute("CREATE TABLE Points (id INTEGER PRIMARY KEY, game_id INTEGER, x INTEGER, y INTEGER, value INTEGER,"
                + " constant INTEGER)");
        System.out.println("A new database succesfully created.");
    }
    
    public void addNewGame(Connection db, String gameName) throws SQLException {
        PreparedStatement ps = db.prepareStatement("INSERT INTO Games (name) VALUES (?)");
        ps.setString(1, gameName);
        ps.executeUpdate();  
    }
    
    public void addPoints(Connection db, int gameId, ArrayList<Point> points) throws SQLException {
        PreparedStatement ps = db.prepareStatement("INSERT INTO Points (game_id, x, y, value, constant) VALUES (?, ?, ?, ?, ?)");
        for (Point p : points) {
            ps.setInt(1, gameId);
            ps.setInt(2, p.getX());
            ps.setInt(3, p.getY());
            ps.setInt(4, p.getValue());
            if (p.isConstant()) {
                ps.setInt(5, 1);
            } else {
                ps.setInt(5, 0);
            }
            ps.executeUpdate();
        }
        System.out.println("Game saved");
    }
}
