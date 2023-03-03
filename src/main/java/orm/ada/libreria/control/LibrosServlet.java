package orm.ada.libreria.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import orm.ada.libreria.model.LibrosEntity;
import orm.ada.libreria.servicio.LibrosServiceImpl;
import orm.ada.libreria.servicio.LibrosServicio;

import java.io.IOException;

@WebServlet(name = "LibrosServlet", value = "/libros/LibrosServlet")
@MultipartConfig
public class LibrosServlet extends HttpServlet {

    private LibrosServicio servicio = new LibrosServiceImpl();
    public LibrosServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String editorial = request.getParameter("editorial");
        Integer anyo_edicion = Integer.valueOf(request.getParameter("anyo_edicion"));
        Part part = request.getPart("imagen");
        byte [] imagen = part.getInputStream().readAllBytes();
        LibrosEntity libro = new LibrosEntity(null, anyo_edicion, autor, editorial, titulo, imagen);
        this.servicio.create(libro);
        response.sendRedirect("/libreria");
    }
}
