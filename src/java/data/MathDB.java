/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Assignment;
import business.Parent;
import business.Question;
import business.StudentScore;
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

    public static String getPasswordForUsername(String username) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT password "
                + "FROM users "
                + "WHERE username = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            String password = "";
            rs = ps.executeQuery();
            if (rs.next()) {
                password = rs.getString("password");
            }
            return password;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** get password", e);
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** get password null pointer?", e);
                throw e;
            }
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
    
    public static boolean validateEmail(String email) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT email FROM users "
                + "WHERE email = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            //String emailCheck = rs.getString("email");
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** validate email sql", e);
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** validate email null pointer?", e);
                throw e;
            }
        }
    }

    public static boolean validateUsername(String username) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT username FROM users "
                + "WHERE username = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            //String usernameCheck = rs.getString("username");
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** validate username sql", e);
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** validate username null pointer?", e);
                throw e;
            }
        }
    }
    
     public static User getUserInfo(String username, String password) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT * "
                + "FROM users "
                + "WHERE username = ? AND password = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                int userid = rs.getInt("userID");
                String userName = rs.getString("username");
                String Password = rs.getString("password"); 
                String email = rs.getString("email");
                String userType = rs.getString("userType");
                user = new User(userid, userName, Password, email, userType);
            }
            return user;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** get password", e);
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** get password null pointer?", e);
                throw e;
            }
        }
    }
    
    public static User getUserInfo(String username) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT * "
                + "FROM users "
                + "WHERE username = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                int userid = rs.getInt("userID");
                String userName = rs.getString("username");
                String Password = rs.getString("password"); 
                String email = rs.getString("email");
                String userType = rs.getString("userType");
                user = new User(userid, userName, Password, email, userType);
            }
            return user;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** get password", e);
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** get password null pointer?", e);
                throw e;
            }
        }
    }
    
    public static ArrayList<Question> getAssignmentWithQuestions(int assignmentID)throws SQLException {
        ArrayList<Question> questions = new ArrayList();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT * "
                + "FROM questions "
                + "WHERE assignmentID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, assignmentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int questionID = rs.getInt("questionID");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                Question tempQuestion = new Question(questionID, assignmentID, question, answer);
                questions.add(tempQuestion);
            }
            return questions;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** get password", e);
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** get password null pointer?", e);
                throw e;
            }
        }
    }
    
    public static ArrayList<Assignment> getClassAssignments(int classID)throws SQLException {
        ArrayList<Assignment> assignments = new ArrayList();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT * "
                + "FROM assignments "
                + "WHERE classID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, classID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int assignmentID = rs.getInt("assignmentID");
                String assignmentType = rs.getString("assignmentType");
                String description = rs.getString("desciption");
                Assignment tempAssignment = new Assignment(assignmentID, assignmentType, classID, description);
                assignments.add(tempAssignment);
            }
            return assignments;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** get password", e);
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** get password null pointer?", e);
                throw e;
            }
        }
    }
    
    public static ArrayList<StudentScore> getStudentScores(int userID) throws SQLException {
        ArrayList<StudentScore> scores = new ArrayList();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "SELECT * "
                + "FROM studentscores "
                + "WHERE userID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int resultID = rs.getInt("resultID");
                int assignmentID = rs.getInt("assignmentID");
                Double resultScore = rs.getDouble("resultScore");
                Double resultWeight = rs.getDouble("resultWeight");
                StudentScore score = new StudentScore(resultID, assignmentID, userID, resultScore, resultWeight);
                scores.add(score);
            }
            return scores;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** get password", e);
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** get password null pointer?", e);
                throw e;
            }
        }
    } 
    
    public static Double getStudentPercentage(int userID) throws SQLException {
        ArrayList<StudentScore> scores = MathDB.getStudentScores(userID);
        double weightTotal = 0;
        double currentScore = 0;
        // Result score is the score as a percentage, ie. if a student got a 95/100, the resultScore would be 95
        // Result weight is the amount of points that the assignment is worth in the class
        for(StudentScore s: scores) {
            double resultScore = s.getResultScore();
            double resultWeight = s.getResultWeight();
            weightTotal += resultWeight;
            currentScore += weightTotal * resultScore * 0.01;
        } 
        double percentage = currentScore / weightTotal;
        percentage = (Math.round(percentage * 100)) / 100;
        return percentage;
    }
    
    
}
