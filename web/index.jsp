<%-- 
    Document   : index
    Created on : Sep 13, 2023, 6:26:19 PM
    Author     : tmdel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math Class Login</title>
        <link rel="stylesheet" type="text/css" href="group.css" />
    </head>

    <body>
        <div id="wrapper">
            <header>
                <h1>Welcome to Math School!</h1>
            </header>

            <main>
                <p>Please log in by clicking the button bellow.</p>
            </main>
            <div class="form">
                <form action="Public" method="post">
                    <input type="hidden" name="action" value="gotologin">
                    <input type="submit" value="Login">
                </form>
            </div>
        </div>
        <footer>
            <p>Copyright &#169;2023</p>
        </footer>
    </body>
</html>