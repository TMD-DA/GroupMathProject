<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Test Pool</title>
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
        <a href="#main-content" id="stmc">Skip to Main Content</a>
        <h1 id="main-content">Update Test Pool</h1>
        <form action="Private" method="post">
            <input type="hidden" name="action" value="UpdateTestPool">
            <table>
                <tr>
                    <th>Question ID</th>
                    <th>Assignment ID</th>
                    <th>Question</th>
                    <th>Answer</th>
                </tr>
                <c:forEach var="question" items="${questions}">
                    <tr>
                    <input type="hidden" name="questionID" value="${questions.value.questionID}">
                    <td>${question.value.questionID}</td>
                    <td>${question.value.assignmentID}</td>
                    <td>${question.value.question}</td>
                    <td>${question.value.answer}</td>
                    <input type="submit" value="Update">
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
