/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raaid
 */
public class Database {

    private static Database uniqueInstance = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return uniqueInstance;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/adventurepilot?useSSL=false";
        String username = "root";
        String password = "password";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

    public  void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());

        }
    }
}
