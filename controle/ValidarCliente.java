package br.com.ProjetoCRUD.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ProjetoCRUD.dao.ClienteDao;
import br.com.ProjetoCRUD.entidades.Cliente;

import br.com.ProjetoCRUD.dao.AdminDao;
import br.com.ProjetoCRUD.entidades.Admin;

/**
 * Servlet implementation class ValidarCliente
 */
@WebServlet("/ValidarCliente")
public class ValidarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidarCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
		HttpSession session = request.getSession();
		String email = request.getParameter("txtLogin");
		String login = request.getParameter("txtLogin");
		String senha = request.getParameter("txtSenha");
		
		try {
			
			ClienteDao clienteDao = new ClienteDao();
			Cliente cliente = clienteDao.validarCliente(email, senha);
			System.out.println(cliente.getIdCliente());
			
			AdminDao adminDao = new AdminDao();
		    Admin admin = adminDao.validarCliente(login, senha);
		    System.out.println(admin.getIdAdmin());
		    
		    
			if (cliente.getIdCliente() > 1) {
				
				session.setAttribute("email", cliente.getEmail());
				session.removeAttribute("id");
				session.setAttribute("id", cliente.getIdCliente());

				response.sendRedirect("area-cliente.jsp");
			
			} else if (admin.getIdAdmin() == 1) {
				session.setAttribute("login", admin.getLogin());
				session.removeAttribute("id");
				session.setAttribute("id", admin.getIdAdmin());

				response.sendRedirect("private-adm/info-produto.jsp");
				
			}else {
				System.out.println("Erro ao acessar a página");
				response.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "servlet");
		}

	}

}
