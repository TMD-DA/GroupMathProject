<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Test</title>
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
        <a href="#main-content" id="#stmc">Skip to Main Content</a>
        <h1 id="main-content">View Test</h1>
        <form action="Private" method="post">
            <input type="hidden" name="action" value="ViewTest">
            <table>
                <tr>
                    <th>Assignment Type</th>
                    <th>class ID</th>
                    <th>Description</th>
                </tr>
                <c:forEach var="assignment" items="${assignments}">
                    <tr>
                    <input type="hidden" name="assignmentID" value="${assignment.value.assignmentID}">
                    <td>${assignment.value.assignmentType}</td>
                    <td>${assignment.value.classID}</td>
                    <td>${assignment.value.description}</td>
                    <input type="submit" value="View Results">
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
