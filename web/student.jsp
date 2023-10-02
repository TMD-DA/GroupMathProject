<%-- 
    Document   : student
    Created on : Sep 18, 2023, 1:26:11 PM
    Author     : tl571727
--%>

<%@page import="business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
    // code to redirect user out off the page if they're not logged in
    User jspUser = (User) request.getSession().getAttribute("loggedInUser");
    if (jspUser == null) {
        response.sendRedirect("Public");
        return;
    }
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
        <style>
            a#stmc {
                position: absolute;
                top: 999999px;
                left: -999999px;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <a href="#main-content" id="stmc">Skip to Main Content</a>
        <h1 id="main-content">Welcome Student</h1>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="tests.jsp">Tests</a>
            <a href="drills.jsp">Drills</a>
            <a href="grades.jsp">Grades</a>
        </nav>
        <main>
            <div class="logout">
                <form action="Private">
                    <input type="hidden" name="action" value="logout">
                    <input type="submit" type="submit" value="Logout">
                </form>
            </div>
        </main>
    </body>
</html>
