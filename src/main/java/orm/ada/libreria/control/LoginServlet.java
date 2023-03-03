package orm.ada.libreria.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import orm.ada.libreria.servicio.LoginServicio;
import orm.ada.libreria.servicio.LoginServicioImpl;
import orm.ada.libreria.servicio.UsuariosServiceImpl;
import orm.ada.libreria.servicio.UsuariosServicio;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private LoginServicio servicioLogin = new LoginServicioImpl();
    private UsuariosServicio servicioUser = new UsuariosServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(servicioLogin.findOne(username));
        if (servicioLogin.findOne(username) != null && servicioLogin.findOne(username).getContrasenya().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", username);
            session.setAttribute("privilegio", servicioLogin.findOne(username).getPrivilegios());
            String nombre = servicioUser.nombreUsuario(username);
            session.setAttribute("nombre", nombre);
            response.sendRedirect("libreria.jsp");
        } else {
            response.sendRedirect("libreria.jsp?error=1");
        }
    }
}

