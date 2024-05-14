import javax.swing.table.DefaultTableModel;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

   
    private DatabaseManager() {}

 
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/document","root", "123456");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

