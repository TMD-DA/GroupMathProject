<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Page</title>
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
        <header>
        <h1>Teacher Page</h1>
        <p> 
            <a href="createAssignments.jsp">Create Math Assignment</a> 
            <a href="addTestPool.jsp">Add to Test Pool</a>
            <a href="removeTestPool.jsp">Remove to Test Pool</a>
            <a href="updateTestPool.jsp">Update to Test Pool</a>
            <a href="viewTest.jsp">View Test</a> 
            <a href="viewData.jsp">View Data</a>
        </p>
        </header>
        <main id="main-content">
            
        </main>
    </body>
</html>

