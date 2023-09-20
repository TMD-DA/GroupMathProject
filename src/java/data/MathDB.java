/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Parent;
import business.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dt655510
 */
public class MathDB {

    private static final Logger LOG = Logger.getLogger(MathDB.class.getName());

    public static int insertUser(User user) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO users (userID, username, password, firstName, lastName, email, userType) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setString(6, user.getEmail());
            ps.setString(7, (user.getUserType()));
            return ps.executeUpdate();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** insert sql", e);
            throw e;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** insert null pointer?", e);
                throw e;
            }
        }
    }
    
    public static int insertParent(Parent parent) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO parent (parentID, password, firstName, lastName, userID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, parent.getParentID());
            ps.setString(2, parent.getPassword());
            ps.setString(3, parent.getFirstName());
            ps.setString(4, parent.getLastName());
            ps.setString(5, parent.getUserID());
            return ps.executeUpdate();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** insert sql", e);
            throw e;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** insert null pointer?", e);
                throw e;
            }
        }
    }
    
    public static LinkedHashMap<String, User> selectAllUsers() throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM users";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            User user = null;
            LinkedHashMap<String, User> users = new LinkedHashMap();

            while (rs.next()) {
                int userID = rs.getInt("userID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String userType = rs.getString("userType");
                user = new User(userID, username, password, firstName, lastName, email, userType);
                users.put(user.getUsername(), user);
            }
            return users;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** select all sql", e);
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** select all null pointer?", e);
                throw e;
            }
        }
    }
    
    public static String getPasswordForUsername(String username) {
        LinkedHashMap<String, User> users = new LinkedHashMap();
        try {
            users = MathDB.selectAllUsers();
        } catch (Exception e) {

        }

        if (users.containsKey(username)) {
            User user = users.get(username);
            String password = user.getPassword();
            return password;
        } else {
            return null;
        }
        
        
    }
    
    public static int selectUserID(String username) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query
                = "SELECT userID "
                + "FROM users "
                + "WHERE username = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            int userID = 0;
            if (rs.next()) {
                userID = rs.getInt("userID");
            }
            return userID;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** select userID", e);
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** select userID null pointer?", e);
            }
        } 
    }
}