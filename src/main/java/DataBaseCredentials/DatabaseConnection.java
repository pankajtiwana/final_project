/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseCredentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pankajtiwana
 */
public class DatabaseConnection {
     public static Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String jdbc = "jdbc:mysql://127.8.163.130:3306/blogbase";
            String user = "adminM7cKxr7";
            String pass = "ehNHrEKpG2_Y";
            conn = DriverManager.getConnection(jdbc, user, pass);
            //String query = "SELECT * FROM product";

        } catch (SQLException ex) {
            System.err.println("No class found Exception" + ex.getMessage());
        }
        return conn;
    }
    
}
