<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add to drill pool</h1>
        <form action="Private" method="post">
            <input type="hidden" name="action" value="addTestPool">
            <label>Question: </label>
            <input type="text" name="question">
            <br><br>
            <label>Answer: </label>
            <input type="text" name="answer">
            <br><br>
            <label>Assignment: </label>
            <input type="text" name="AssignmentID">
            <br><br>
            <input type="submit" value="Create">
        </form>
    </body>
</html>
