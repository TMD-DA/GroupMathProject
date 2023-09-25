<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Test Pool Question</title>
    </head>
    <body>
        <h1>Remove Test Pool Question</h1>
        <form action="Private" method="post">
            <input type="hidden" name="action" value="RemoveTestPool">
            <table>
                <tr>
                    <th>Question ID</th>
                    <th>Assignment ID</th>
                    <th>Question</th>
                    <th>Answer</th>
                </tr>
                <c:forEach var="question" items="${questions}">
                   <tr>
                       <input type="hidden" name="questionID" value="${question.value.questionID}">
                        <td>${question.value.assignmentID}</td>
                        <td>${question.value.question}</td>
                        <td>${question.value.answer}</td>
                        <input type="submit" value="Delete">
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>

