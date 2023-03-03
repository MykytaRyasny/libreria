<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Libreria</title>
</head>
<body>
<div class="container">
    <div class="banner">
        <%@ include file="util/banner.jsp" %>
    </div>
    <div class="tabla">
        <%if(session.getAttribute("privilegio").equals(false)) { %>
        <%@ include file="tabla_datos.jsp" %>
        <% } else { %>
        <%@ include file="tabla_datos_admin.jsp" %>
        <% } %>
    </div>
    <div class="insertar">
        <%if(session.getAttribute("privilegio").equals(true)){%>
        <%@ include file="util/botonLibro.jsp" %>
        <%}%>
    </div>
    <div class="carrito">
        <a href="carrito.jsp">
            <img id="carrito" src="./imageRes/carrito.png">
            <span><%= session.getAttribute("carrito") != null ? ((ArrayList<LibrosEntity>)session.getAttribute("carrito")).size() : 0 %></span>
        </a>
    </div>
    <div class="login-form">
        <%if(session.getAttribute("nombre") == null){ %>
        <%@ include file="login_sidebar.jsp" %>
        <% } else { %>
        <%@ include file="bienvenido.jsp" %>
        <%  } %>
    </div>
    <div class="hora">
        <%@ include file="util/hora.jsp" %>
    </div>
</div>
</body>
</html>