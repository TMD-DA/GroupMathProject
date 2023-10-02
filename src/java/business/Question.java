/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author dt655510
 */
public class Question {
    private int questionID, assignmentID;
    private String question, answer;

    public Question() {
    }

    public Question(int questionID, int assignmentID, String question, String answer) {
        this.questionID = questionID;
        this.assignmentID = assignmentID;
        this.question = question;
        this.answer = answer;
    }
    
    public Question(int assignmentID, String question, String answer) {
        this.assignmentID = assignmentID;
        this.question = question;
        this.answer = answer;
    }
    
    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
