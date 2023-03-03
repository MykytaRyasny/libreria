package orm.ada.libreria.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import orm.ada.libreria.model.LibrosEntity;
import orm.ada.libreria.servicio.LibrosServiceImpl;
import orm.ada.libreria.servicio.LibrosServicio;

import java.io.IOException;

@WebServlet(name = "ServletEditar", value = "/ServletEditar")
public class ServletEditar extends HttpServlet {

    private LibrosServicio servicio = new LibrosServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer libroID = Integer.parseInt(request.getParameter("libroId"));
        LibrosEntity libro = servicio.findOne(libroID);
        request.getSession().setAttribute("libro", libro);
        response.sendRedirect("/libreria/libros/editar_libro.jsp");
    }
}
