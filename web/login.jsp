<%-- 
    Document   : login
    Created on : Sep 18, 2023, 2:27:20 PM
    Author     : tmdel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Enter Login information below</h1>
    </body>
    <div>
        <c:forEach var="errors" items="${message}">
            <h3>${errors.value}</h3>
        </c:forEach>
        <h3>${msg}</h3>
    </div>

    <div class="form">
        <form action="Public" method="post">
            <input type="hidden" name="action" value="login">

            <label>Username: </label>
            <input type="text" name="username"><br>

            <label>Password: </label>
            <input type="text" name="password"><br>
            <br>
            <input type="submit" value="login">
        </form>
    </div>
</html>
