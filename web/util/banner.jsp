<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="orm.ada.libreria.model.LibrosEntity" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/global.css">
    <title></title>
    <% if (session.getAttribute("privilegio") == null) {
        session.setAttribute("privilegio", false);
    }
        if (session.getAttribute("carrito") == null) {
            ArrayList<LibrosEntity> carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }
    %>
</head>
<body>
<a href="/libreria">
    <div class="banner-wrapper">
        <div class="banner-container">
            <img class="imagen" src="/libreria/imageRes/library.gif" alt="banner de la pagina">
        </div>
    </div>
</a>
</body>
</html>
