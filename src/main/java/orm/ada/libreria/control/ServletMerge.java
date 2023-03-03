package orm.ada.libreria.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import orm.ada.libreria.model.LibrosEntity;
import orm.ada.libreria.servicio.LibrosServiceImpl;
import orm.ada.libreria.servicio.LibrosServicio;

import java.io.IOException;

@WebServlet(name = "ServletMerge", value = "/ServletMerge")
@MultipartConfig
public class ServletMerge extends HttpServlet {

    private LibrosServicio servicio = new LibrosServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibrosEntity libro = (LibrosEntity) request.getSession().getAttribute("libro");
        libro.setTitulo(request.getParameter("titulo"));
        libro.setAnyoEdicion(Integer.valueOf(request.getParameter("anyo_edicion")));
        libro.setAutor(request.getParameter("autor"));
        libro.setEditorial(request.getParameter("editorial"));
        if(request.getPart("imagen").getInputStream().read() == -1) {
            libro.setImage(libro.getImage());
        } else {
            Part part = request.getPart("imagen");
            byte [] imagen = part.getInputStream().readAllBytes();
            libro.setImage(imagen);
        }
        servicio.update(libro);
        response.sendRedirect("/libreria");
    }
}
