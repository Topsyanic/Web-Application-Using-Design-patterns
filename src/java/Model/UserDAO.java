/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raaid
 */
public class UserDAO {

    Connection connection;
    Database database = Database.getInstance();

    public UserDAO() throws SQLException {
        connection = database.getConnection();
    }

    public boolean registerUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into users(email,first_name,last_name,password,user_type)" + "values(?,?,?,?,?)");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public User authenticateUser(String email, String password) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select email,password,user_type,first_name,last_name from users");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String dbEmail = rs.getString("email");
            String dbPassword = rs.getString("password");
            String userRole = rs.getString("user_type");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            if (email.equals(dbEmail) && password.equals(dbPassword)) {
                User authenticatedUser = new User(firstName, lastName, dbEmail, dbPassword, userRole);
                return authenticatedUser;
            }
        }
        User invalidUser = new User("invalid");
        return invalidUser;
    }

    public List<User> getAllUser() throws SQLException {
        List<User> userList = new ArrayList<User>();
        PreparedStatement ps = connection.prepareStatement("select email,password,user_type,first_name,last_name from users ");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String dbEmail = rs.getString("email");
            String dbPassword = rs.getString("password");
            String userRole = rs.getString("user_type");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            User user = new User(firstName, lastName, dbEmail, dbPassword, userRole);
            userList.add(user);
        }
        return userList;
    }
}
