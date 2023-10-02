<%-- 
    Document   : parent-dashboard
    Created on : Sep 27, 2023, 1:36:40 PM
    Author     : Joshua Root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parent Dashboard</title>
        <link rel="stylesheet" type="text/css" href="group.css" />

        <style>
            * {
                font-family: sans-serif;

                a {
                    text-decoration: none;
                }

                a#stmc {
                    position: absolute;
                    top: 999999px;
                    left: -999999px;
                }
            }

            #students-grid {
                display: grid;
                grid-template-columns: repeat(3, calc(calc(100% / 3) - 10px));
            }

            #students-grid #student-itemv {
                background-color: #e8e8e8;
            }

            #students-grid #student-item img {
                border: 1px solid black;
                border-radius: 5px;
            }

        </style>
    </head>
    <body>
        <a href=""#main-content" id="stmc">Skip to Main Content</a>

        <main id=main-content"">
            <h1>Welcome to the Parent Dashboard, ${loggedInUser != null ? loggedInUser.username : "Din Djarin"}</h1>

            <h3>You Currently Have 6 People Taking Math Lessons</h3>
            <div id="students-grid">
                <div id="student-item">
                    <img src="some_random_pic.png" alt="" width="25" height="25">
                    <span>Obi-Wan Kenobi</span>
                </div>
                <div id="student-item">
                    <img src="some_random_pic.png" alt="" width="25" height="25">
                    <span>Hondo Onaka</span>
                </div>
                <div id="student-item">
                    <img src="some_random_pic.png" alt="" width="25" height="25">
                    <span>Bart Simpson</span>
                </div>
                <div id="student-item">
                    <img src="some_random_pic.png" alt="" width="25" height="25">
                    <span>Lisa Simpson</span>
                </div>
                <div id="student-item">
                    <img src="some_random_pic.png" alt="" width="25" height="25">
                    <span>Stewie Griffin</span>
                </div>
                <div id="student-item">
                    <img src="some_random_pic.png" alt="" width="25" height="25">
                    <span>Glenn Quagmire</span>
                </div>
            </div>
        </main>
    </body>
</html>
