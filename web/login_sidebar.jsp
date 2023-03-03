<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="login_sidebar.css">
</head>
<body>
<div class="login">
    <h1>Login</h1>
    <form action="LoginServlet" method="post">
        <div class="input-container">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="input-container">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="button-container">
            <input type="submit" value="Login">
        </div>
    </form>
    <div class="button-container">
        <button onclick="window.location.href='register.jsp'">Register</button>
    </div>
    <% if (request.getParameter("error") != null) { %>
    <p style="color: red">Usuario o contraseña incorrectos.</p>
    <% } %>
</div>
</body>
</html>
