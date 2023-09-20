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
        <title>Create Math Assignment</title>
    </head>
    <body>
        <h1>Create Math Assignment</h1>
        <form action="Private" method="post">
            <input type="hidden" name="action" value="createMathTest">
            <label>Assignment Type: </label>
            <br>
            <input type="radio" id="drill" name="AssignmentType" value="drill">
            <label>Drill</label>
            <br>
            <input type="radio" id="test" name="AssignmentType" value="test">
            <label>Test</label>
            <br><br>
            <label>class ID : </label>
            <br><br>
            <label>Description: </label>
            <input type="text" name="description">
            <br><br>
            <input type="submit" value="Create">
        </form>
    </body>
</html>
