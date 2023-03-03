<%@ page import="orm.ada.libreria.model.LibrosEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>
<%@ page import="orm.ada.libreria.dao.LibrosDAOJPAImpl" %>
<%@ page import="org.apache.tika.Tika" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  String libroId = request.getParameter("libroId");
  if (libroId != null) {
    LibrosEntity libroSeleccionado = new LibrosDAOJPAImpl().findOne(Integer.parseInt(libroId));
    ArrayList<LibrosEntity> carrito = (ArrayList<LibrosEntity>) session.getAttribute("carrito");
    carrito.add(libroSeleccionado);
  }
%>
<div class="tablaLibreria">
  <table>
    <thead>
    <tr>
      <th>Titulo</th>
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
      List<LibrosEntity> librosList = new LibrosDAOJPAImpl().findAll();
      for (LibrosEntity libro : librosList) {
        if (!(libro.getImage() == null)) {
          mimeType = new Tika().detect(libro.getImage());
          base64Image = Base64.getEncoder().encodeToString(libro.getImage());
        }
    %>
    <tr>
      <td><%= libro.getTitulo() %></td>
      <td><%= libro.getAutor() %></td>
      <td><%= libro.getEditorial() %></td>
      <td><%= libro.getAnyoEdicion() %></td>
      <% if (!(mimeType == null)) { %>
      <td><img id="no-imagen-libro" src="data:<%= mimeType %>;base64, <%= base64Image %>"/></td>
      <% } else { %>
      <td><img id="imagen-libro" src=""></td>
      <% } %>
      <td>
        <form method="post" action="libreria.jsp">
          <input type="hidden" name="libroId" value="<%= libro.getIdL() %>">
          <input type="submit" value="Añadir">
        </form>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
</body>
</html>