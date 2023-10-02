<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Math Assignment</title>
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
        <h1 id="main-content">Create Math Assignment</h1>
        <form action="Private" method="post">
            <input type="hidden" name="action" value="createMathTest">
            <label>Assignment Type: </label>
            <br>
            <input type="radio" id="drill" name="AssignmentType" value="drill" checked="true">
            <label>Drill</label>
            <br>
            <input type="radio" id="test" name="AssignmentType" value="test">
            <label>Test</label>
            <br><br>
            <label>class ID : </label>
            <select name="rating" id="rating">
                    <option value="1">1</option>
                    <option value="2">2</option>
             </select>
            <br><br>
            <label>Description: </label>
            <input type="text" name="description">
            <br><br>
            <input type="submit" value="Create">
        </form>
    </body>
</html>
