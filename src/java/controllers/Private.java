/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import business.User;
import data.MathDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tmdel
 */
public class Private extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
        if (loggedInUser == null) {
            response.sendRedirect("Public");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "default";
        }

        String url = "/index.jsp";

        switch (action) {
            case "logout": {
                HttpSession session;
                session = request.getSession();
                session.invalidate();

                url = "/Public?action=gotoIndex";
                break;
            }
            case "selectQuestions": {
                url = "./createAssignments.jsp";
                
                LinkedHashMap questions = new LinkedHashMap();
                try {
                    questions = MathDB.selectQuestions(questionID);
                    request.setAttribute("questions", questions);
                } catch (Exception e) {
                    request.setAttribute("msg", "Failed to get Questions");
                }
                break;
            }
            case "selectStudents": {
                LinkedHashMap students = new LinkedHashMap();
                try {
                    students = MathDB.selectStudents();
                    request.setAttribute("students", students);
                } catch (Exception e) {
                    request.setAttribute("msg", "Failed to get Students");
                }
                break;
            }
            case "selectTestResults": {
                LinkedHashMap results = new LinkedHashMap();
                try {
                    results = MathDB.selectResults(resultID);
                    request.setAttribute("results", results);
                } catch (Exception e) {
                    request.setAttribute("msg", "Failed to get Results");
                }
                break;
            }
            case "deleteUser": {
                int userID = 0;
                try {
                    userID = Integer.parseInt(request.getParameter("userID"));
                } catch (Exception e) {
                    request.setAttribute("msg", "Failed to parse int");
                }
                try {
                    MathDB.deleteUser(userID);
                } catch (SQLException ex) {
                    Logger.getLogger(Private.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "student": {
                url = "/student.jsp";
                break;
            }
            case "teacher": {
                url = "/teacher.jsp";
                break;
            }
            case "admin": {
                url = "/admin.jsp";
                break;
            }
            case "parent": {
                url = "/parent-dashboard.jsp";
                break;
            }
            case "gotoregister": {
                url = "/register.jsp";
                break;
            }
            case "gotoadmin": {
                url = "/admin.jsp";
                break;
            }
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
