package Control;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MensajeDao;
import Dao.UsuarioDao;
import Entities.Mensaje;
import Entities.Usuario;

/**
 * Servlet implementation class MensajeControl
 */
@WebServlet("/MensajeControl")
public class MensajeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MensajeControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");	
		
		switch (accion) {
		case "registrar":
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			break;
		case "listar":
			MensajeDao mD = new MensajeDao();
			request.getRequestDispatcher("mensaje.jsp").forward(request, response);
			break;

		case "ingresar":
			Mensaje m = new Mensaje();
			Usuario u = new Usuario();
			MensajeDao mDao = new MensajeDao();
			String nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			String website = request.getParameter("website");
			String mensaje = request.getParameter("mensaje");
			String usuario = request.getParameter("usuario"); 
			u.setUsuario(usuario);
			m.setNombre(nombre);
			m.setEmail(email);
			m.setWebsite(website);
			m.setMensaje(mensaje);
			m.setUsuario(u);
			mDao.registrar(m);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		default:
			break;
		}
	}

}
