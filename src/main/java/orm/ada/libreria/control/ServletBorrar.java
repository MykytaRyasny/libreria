package orm.ada.libreria.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import orm.ada.libreria.servicio.LibrosServiceImpl;
import orm.ada.libreria.servicio.LibrosServicio;

import java.io.IOException;

@WebServlet(name = "ServletBorrar", value = "/ServletBorrar")
public class ServletBorrar extends HttpServlet {
    private LibrosServicio servicio = new LibrosServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int libroId = Integer.parseInt(request.getParameter("libroId"));
        servicio.delete(libroId);
        response.sendRedirect(request.getContextPath() + "/libreria.jsp");
    }
}
