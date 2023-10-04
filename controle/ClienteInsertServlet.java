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

/**
 * Servlet implementation class ClienteInsertControle
 */
@WebServlet("/ClienteInsertServlet")
public class ClienteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteInsertServlet() {
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
		HttpSession session = request.getSession();
		doGet(request, response);
		String nomeCliente = request.getParameter("nomeCliente");
		String emailCliente = request.getParameter("emailCliente");

		String senha = request.getParameter("senha");
		String cpfCliente = request.getParameter("cpfCliente");
		String celularCliente = request.getParameter("celularCliente");

		// Instanciando um Objeto do tipo Cliente
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		cliente.setEmail(emailCliente);
		cliente.setCelular(celularCliente);
		cliente.setSenha(senha);
		cliente.setCpf(cpfCliente);
		// Instanciando um Objeto do tipo ClienteDao
		try {
			ClienteDao clienteDao = new ClienteDao();
			clienteDao.adicionar(cliente);
			
			session.setAttribute("email", emailCliente);
			
			request.setAttribute("msg", "<div class='alert alert-success'>Cliente Cadastrado!</div>");
			response.sendRedirect("./private-adm/info-cliente.jsp");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("msg", "<div class='alert alert-danger'>Cliente não Cadastrado!</div>!!!");
		}
	}

}
