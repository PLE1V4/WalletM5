package walletm5.shared.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import walletm5.usuario.model.dao.UsuarioDao;
import walletm5.usuario.model.dao.impl.UsuarioDaoImpl;
import walletm5.usuario.model.entidad.Usuario;
import walletm5.usuario.model.service.UsuarioService;
import walletm5.usuario.model.service.impl.UsuarioServiceImpl;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UsuarioDao usuarioDao;
    private UsuarioService usuarioService;
  
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		usuarioDao= new UsuarioDaoImpl();
		usuarioService= new UsuarioServiceImpl(usuarioDao);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("inEmail");
		String pwd = request.getParameter("inPwd");
		
		Usuario user = usuarioService.obtenerPorEmail(email);
		
		boolean resultado;
		
		if(user.getEmail().equals(email) && user.getPassword().equals(pwd)) {
			resultado = true;
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
		}else {
			resultado = false;
		}
		
		String url = resultado? "/home" : "/view/error.jsp"; 
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
