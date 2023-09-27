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
    </head>
    <body>
        <div id="wrapper">
            <h1>Welcome to the admin page, here you will be able to conduct admin actions.</h1>
            <div class="logout">
                <form action="Public">
                    <input type="hidden" name="action" value="logout">
                    <input type="submit" value="Logout">
                </form>
            </div>
            <div>
                <form action="Private">
                    <input type="hidden" name="action" value="gotoregister">
                    <input type="submit" value="Register User">
                </form>
            </div>
        </div>
    </body>


</html>


