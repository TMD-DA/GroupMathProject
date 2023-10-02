/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author dt655510
 */
public class Assignment {
    private int assignmentID, classID;
    private String asignmentType, description;

    public Assignment() {
    }

    public Assignment(int assignmentID, String asignmentType, int classID, String description) {
        this.assignmentID = assignmentID;
        this.classID = classID;
        this.asignmentType = asignmentType;
        this.description = description;
    }
    
    public Assignment(String asignmentType, int classID, String description) {
        this.classID = classID;
        this.asignmentType = asignmentType;
        this.description = description;
    }
    
    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getAsignmentType() {
        return asignmentType;
    }

    public void setAsignmentType(String asignmentType) {
        this.asignmentType = asignmentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
