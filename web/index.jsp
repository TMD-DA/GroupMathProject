<%-- 
    Document   : index
    Created on : Sep 13, 2023, 6:26:19 PM
    Author     : tmdel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math Class Login</title>
    </head>
    
    <body>
 <div id="wrapper">
            <header>
                <h1>Login To Our Site</h1>
            </header>
            <nav>
                <a href="index.jsp">Login&emsp;&#124;</a>
                <a href="">&emsp;Register&emsp;&#124;</a>
                <a href="">&emsp;Your Profile&emsp;&#124;</a>
                <a href="">&emsp;All Users</a>
            </nav>
            <main>
                <div class="logout">
                    <form action="Public">
                        <input type="hidden" name="action" value="logout">
                        <input type="submit" value="Logout">
                    </form>
                </div>
                <div>
                    
                </div>
                <div class="form">
                    <form action="Public" method="post">
                        <input type="hidden" name="action" value="login">

                        <label>Username: </label>
                        <input type="text" name="username"><br>

                        <label>Password: </label>
                        <input type="text" name="password"><br>
                        <br>
                        <input type="submit" value="login">
                    </form>
                </div>
            </main>
        </div>
        <footer>
            <p>Copyright &#169;2023</p>
        </footer>
    </body>
</html>