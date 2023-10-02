<%-- 
    Document   : admin
    Created on : Sep 25, 2023, 1:35:13 PM
    Author     : tmdel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
        <link rel="stylesheet" type="text/css" href="group.css" />
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
        <a href="#main-content">Skip to Main Content</a
            >
        <div id="wrapper">
            <h1 id="main-content">Welcome to the admin page, here you will be able to conduct admin actions.</h1>
            <div class="logout">
                <form action="Public">
                    <input type="hidden" name="action" value="logout">
                    <input type="submit" value="Logout">
                </form>
            </div>
            <div class="form">
                <form action="Private">
                    <input type="hidden" name="action" value="gotoregister">
                    <input type="submit" value="Register User">
                </form>
                <form action="Private">
                    <input type="hidden" name="action" value="gotodelete">
                    <input type="submit" value="Delete User">
                </form>
            </div>
        </div>
    </body>


</html>


