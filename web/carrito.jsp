<%@ page import="orm.ada.libreria.model.LibrosEntity" %>
<%@ page import="orm.ada.libreria.dao.LibrosDAOJPAImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>
<%@ page import="org.apache.tika.Tika" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrito</title>
</head>
<body>
<div class="container">
    <div class="banner">
        <%@ include file="util/banner.jsp" %>
    </div>
    <div class="tabla">
    <div class="tablaLibreria">
        <table>
            <thead>
            <tr>
                <th>Título</th>
                <th>Autor</th>
                <th>Editorial</th>
                <th>Año de edición</th>
                <th>Imagen</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%
                String mimeType = null;
                String base64Image = null;
                ArrayList<LibrosEntity> listaCarrito = (ArrayList<LibrosEntity>)session.getAttribute("carrito");
                for (LibrosEntity libro : listaCarrito) {
                    if (!(libro.getImage() == null)) {
                        mimeType = new Tika().detect(libro.getImage());
                        base64Image = Base64.getEncoder().encodeToString(libro.getImage());
                    }
            %>
            <tr>
                <td><%= libro.getTitulo() %>
                </td>
                <td><%= libro.getAutor() %>
                </td>
                <td><%= libro.getEditorial() %>
                </td>
                <td><%= libro.getAnyoEdicion() %>
                </td>
                <% if (!(mimeType == null)) { %>
                <td><img id="no-imagen-libro" src="data:<%= mimeType %>;base64, <%= base64Image %>"/></td>
                <% } else { %>
                <td><img id="imagen-libro" src=""></td>
                <% }
                %>
                <td>
                    <form method="post" action="ServletBorrarCarrito">
                        <input type="hidden" name="libroId" value="<%= libro.getIdL() %>">
                        <input type="submit" value="Borrar">
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    </div>
    <div class="login-form">
        <%if(session.getAttribute("nombre") == null){ %>
        <%@ include file="login_sidebar.jsp" %>
        <% } else { %>
        <%@ include file="bienvenido.jsp" %>
        <%  } %>
    </div>
</div>
<div class="hora">
    <%@ include file="util/hora.jsp" %>
</div>
</body>
</html>
