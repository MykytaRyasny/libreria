<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Crear un nuevo libro</title>
</head>
<body>
<div class="container">
    <div class="banner">
        <%@ include file="../util/banner.jsp" %>
    </div>
    <div class="tabla">
    <form action="LibrosServlet" method="post" enctype="multipart/form-data">
        <label for="titulo">Titulo</label>
        <input type="text" class="form-control" name="titulo" id="titulo" required>

        <label for="autor">Autor</label>
        <input type="text" class="form-control" name="autor" id="autor" required>

        <label for="editorial">Editorial</label>
        <input type="text" class="form-control" name="editorial" id="editorial" required>

        <label for="anyo_edicion">Año edición</label>
        <input type="number" class="form-control" name="anyo_edicion" id="anyo_edicion" required>

        <label for="imagen">Imagen</label>
        <input type="file" class="form-control" name="imagen" id="imagen" required>

        <button type="submit" class="btn">Crear Libro</button>
    </form>
    </div>
    <div class="login-form">
        <%if (session.getAttribute("nombre") == null) { %>
        <%@ include file="../login_sidebar.jsp" %>
        <% } else { %>
        <%@ include file="../bienvenido.jsp" %>
        <% } %>
    </div>
    <div class="hora">
        <%@ include file="../util/hora.jsp" %>
    </div>
</div>
</body>
</html>