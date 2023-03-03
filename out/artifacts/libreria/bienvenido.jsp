<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Bienvenido</title>
  <link rel="stylesheet" href="login_sidebar.css">
</head>
<body>
<div class="login">
  <h1>Bienvenido <%= session.getAttribute("nombre") %></h1>
  <form action="${pageContext.request.contextPath}/ServletDesconectar" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <div class="button-container">
      <input type="submit" value="Desconectar">
    </div>
  </form>
</div>
</body>
</html>