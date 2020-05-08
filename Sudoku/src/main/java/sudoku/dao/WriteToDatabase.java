//
//package sudoku.dao;
//
//import java.sql.*;
//import java.util.*;
//
//import sudoku.domain.Point;
//
//public class WriteToDatabase  {
//    
//    public void create(Connection db) throws SQLException {
//        Statement s = db.createStatement();
//        s.execute("CREATE TABLE Kayttajat (id INTEGER PRIMARY KEY, username TEXT)");
//        s.execute("CREATE TABLE Games (id INTEGER PRIMARY KEY, user_id INTEGER, x INTEGER, y INTEGER, value INTEGER)");
//        System.out.println("A new database succesfully created.");
//    }
//    
//    public void write(ArrayList<Point> points, Connection db, String username) throws SQLException {
//        PreparedStatement ps = db.prepareStatement("SELECT id FROM Kayttajat WHERE username=?");
//        ps.setString(1, username);
//        ResultSet r = ps.executeQuery();
//        for (Point p : points) {
//            ps = db.prepareStatement("INSERT INTO Games (user_id, x, y, value) VALUES (?, ?, ?, ?)");
//            ps.setInt(1, r.getInt("id"));
//            ps.setInt(2, p.getX());
//            ps.setInt(3, p.getY());
//            ps.setInt(4, p.getValue());
//        }
//        ps.executeUpdate();
//    }
//}
