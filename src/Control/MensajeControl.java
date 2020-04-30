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
	Mensaje m = new Mensaje();
	Usuario u = new Usuario();
	MensajeDao mDao = new MensajeDao();
       
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
			String site = new String("http://localhost:8080/ProjectJSTL2.0/registro.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
			break;
		case "listar":
			MensajeDao mD = new MensajeDao();
			String site1 = new String("http://localhost:8080/ProjectJSTL2.0/mensaje.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site1);
			break;

		case "ingresar":
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
			String site2 = new String("http://localhost:8080/ProjectJSTL2.0/index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site2);
			break;
			
		case "atras":
			String site3 = new String("http://localhost:8080/ProjectJSTL2.0/index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site3);
			break;
			
		case "atras1":
			String site5 = new String("http://localhost:8080/ProjectJSTL2.0/index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site5);
			break;
			
		case "eliminar":
			String p = request.getParameter("id");
			int uno = Integer.parseInt(request.getParameter("id"));
			mDao.eliminar(uno);
			String site4 = new String("http://localhost:8080/ProjectJSTL2.0/mensaje.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site4);
			break;
			
		case "editar":
			//String x = request.getParameter("id");
			int dos = Integer.parseInt(request.getParameter("id"));
			m = mDao.buscar(dos);
			request.setAttribute("mensaje", m);
			System.out.println(m.getNombre());
			System.out.println(m.getEmail());
			System.out.println(m.getId());
			request.getRequestDispatcher("editar.jsp").forward(request, response);
			break;
			
		case "update":

			String nombre1= request.getParameter("nombre");
			String email1= request.getParameter("email");
			String website1= request.getParameter("website");
			String mensaje1= request.getParameter("mensaje");
			String usu = request.getParameter("usuario");
			u.setUsuario(usu);
			m.setNombre(nombre1);
			m.setEmail(email1);
			m.setWebsite(website1);
			m.setUsuario(u);
			m.setMensaje(mensaje1);
			mDao.actualizar(m);
			String site7 = new String("http://localhost:8080/ProjectJSTL2.0/editar.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site7);
			break;
			
		default:
			break;
		}
	}

}
