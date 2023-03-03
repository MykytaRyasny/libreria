<%@ page import="orm.ada.libreria.control.ServletEditar" %>
<%@ page import="org.apache.tika.Tika" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Editar un libro</title>
</head>
<body>
<div class="container">
    <div class="banner">
        <%@ include file="../util/banner.jsp" %>
    </div>
    <%  LibrosEntity libro = (LibrosEntity)session.getAttribute("libro");
        String mimeType = null;
        String base64Image = null;
        if (libro.getImage() != null) {
            mimeType = new Tika().detect(libro.getImage());
            base64Image = Base64.getEncoder().encodeToString(libro.getImage());
        }
    %>
<div class="tabla">
    <form action="${pageContext.request.contextPath}/ServletMerge" method="post" enctype="multipart/form-data">
        <input type="hidden" name="libroId" value="<%= libro.getIdL() %>" required>
        <label for="titulo">Titulo</label>
        <input type="text" class="form-control" name="titulo" id="titulo" value="<%= libro.getTitulo() %>" required>

        <label for="autor">Autor</label>
        <input type="text" class="form-control" name="autor" id="autor" value="<%= libro.getAutor() %>" required>

        <label for="editorial">Editorial</label>
        <input type="text" class="form-control" name="editorial" id="editorial" value="<%= libro.getEditorial() %>" required>

        <label for="anyo_edicion">Año edición</label>
        <input type="number" class="form-control" name="anyo_edicion" id="anyo_edicion" value="<%= libro.getAnyoEdicion() %>" required>

        <label for="imagen">Imagen</label>
        <input type="file" class="form-control" name="imagen" id="imagen">

        <button type="submit" class="btn">Guardar</button>
    </form>
</div>
    <div class="login-form">
        <%if (session.getAttribute("nombre") == null) { %>
        <%@ include file="/login_sidebar.jsp" %>
        <% } else { %>
        <%@ include file="/bienvenido.jsp" %>
        <% } %>
    </div>
    <div class="hora">
        <%@ include file="../util/hora.jsp" %>
    </div>
</div>
</body>
</html>