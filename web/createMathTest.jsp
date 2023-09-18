<%-- 
    Document   : createMathTest
    Created on : Sep 18, 2023, 2:18:02 PM
    Author     : isaac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Math Test</title>
    </head>
    <body>
        <h1>Create Math Test</h1>
        <form action="Private" method="post">
            <input type="hidden" name="action" value="createMathTest">
            <label>Test Name:</label>
            <input type="text" name="name">
            <br><br>
            <input type="submit" value="Create">
        </form>
    </body>
</html>
