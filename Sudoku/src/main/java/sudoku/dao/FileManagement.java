//
//package sudoku.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.ArrayList;
//         
//import sudoku.dao.WriteToDatabase;
//import sudoku.domain.Point;
//
//public class FileManagement {
//    
//    public boolean createNewFile(WriteToDatabase writer, ArrayList<Point> points, String username) {
//        try {
//            Connection db = openConnection();
//            writer.create(db);
//            writer.write(points, db, username);
//        } catch (SQLException e) {
//            return false;
//        }
//        return true;
//    }       
//    
//    public void writeToExistingDatabase(WriteToDatabase writer) {
//       
//    }
//    
//    public Connection openConnection() throws SQLException {
//        Connection db = DriverManager.getConnection("jdbc:sqlite:sudoku.db");
//        return db;
//    }
//}
