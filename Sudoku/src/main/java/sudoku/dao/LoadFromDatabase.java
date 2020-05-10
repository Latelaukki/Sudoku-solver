
package sudoku.dao;

import java.sql.*;
import java.util.ArrayList;
import sudoku.domain.Point;

public class LoadFromDatabase {
    
    public ArrayList<String> listGames(Connection db) throws SQLException {
        ArrayList<String> games = new ArrayList<>();
        PreparedStatement ps = db.prepareStatement("SELECT name FROM Games");
        ResultSet r = ps.executeQuery();
        while (r.next()) {
            games.add(r.getString("name"));
        }
        return games;
    }
    
    public int getSavedGameId(Connection db, String gameName) throws Exception {
        PreparedStatement ps = db.prepareStatement("SELECT id FROM Games WHERE name=?");
        ps.setString(1, gameName);
        ResultSet r = ps.executeQuery();
        int id = r.getInt("id");
        return id;
    }
        
    public ArrayList<Point> loadPoints(Connection db, int gameId) throws Exception {
        ArrayList<Point> points = new ArrayList<>();
        PreparedStatement ps = db.prepareStatement("SELECT x, y, value, constant FROM Points WHERE game_id=?");
        ps.setInt(1, gameId);
        ResultSet r = ps.executeQuery();
        while (r.next()) {
            Point p = new Point(r.getInt("x"), r.getInt("y"), r.getInt("value"));
            points.add(p);
            if (r.getInt("constant") == 1) {
                p.setConstant(r.getInt("value"));
            } else {
                p.setNonConstantNumber(r.getInt("value"));
            }
        }
        return points;
    }
}
