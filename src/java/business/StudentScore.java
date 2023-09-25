/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author dt655510
 */
public class StudentScore {
    private int resultID, assignmentID, userID;
    private double resultScore, resultWeight;

    public StudentScore() {
    }

    public StudentScore(int resultID, int assignmentID, int userID, double resultScore, double resultWeight) {
        this.resultID = resultID;
        this.assignmentID = assignmentID;
        this.userID = userID;
        this.resultScore = resultScore;
        this.resultWeight = resultWeight;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getResultScore() {
        return resultScore;
    }

    public void setResultScore(double resultScore) {
        this.resultScore = resultScore;
    }

    public double getResultWeight() {
        return resultWeight;
    }

    public void setResultWeight(double resultWeight) {
        this.resultWeight = resultWeight;
    }
    
    
}
