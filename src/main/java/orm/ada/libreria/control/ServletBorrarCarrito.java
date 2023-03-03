package orm.ada.libreria.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import orm.ada.libreria.dao.LibrosDAOJPAImpl;
import orm.ada.libreria.model.LibrosEntity;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletBorrarCarrito", value = "/ServletBorrarCarrito")
public class ServletBorrarCarrito extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String libroId = request.getParameter("libroId");
        System.out.println(libroId);
        if (libroId != null) {
            LibrosEntity libroSeleccionado = new LibrosDAOJPAImpl().findOne(Integer.parseInt(libroId));
            ArrayList<LibrosEntity> carrito = (ArrayList<LibrosEntity>) session.getAttribute("carrito");
            for (int i = 0; i < carrito.size(); i++){
                System.out.println(carrito.get(i).getIdL());
                if(carrito.get(i).getIdL() == Integer.valueOf(libroId)){
                    carrito.remove(i);
                }
            }
        }
        response.sendRedirect("/libreria/carrito.jsp");
    }
}
