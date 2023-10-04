package br.com.ProjetoCRUD.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ProjetoCRUD.dao.AdminDao;
import br.com.ProjetoCRUD.dao.ClienteDao;
import br.com.ProjetoCRUD.entidades.Admin;
import br.com.ProjetoCRUD.entidades.Cliente;

/**
 * Servlet implementation class ClienteControle
 */
@WebServlet(name="/ClienteControle",urlPatterns= {
		"/cadastrarCliente",
		"/buscarCliente",
		"/logarCliente","/sairCliente","/sairAdmin"
		})
public class ClienteControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String url = request.getServletPath();

			if (url.equalsIgnoreCase("/cadastrarCliente")) {
				cadastrar(request, response);
			}  else if (url.equalsIgnoreCase("/logarCliente")) {
				logar(request, response);
			}else if (url.equalsIgnoreCase("/buscarCliente")) {
				buscar(request, response);
			}
			else {
				throw new Exception("URL Inválida!!!");
			}
		} catch (Exception e) {
			response.sendRedirect("home.jsp");
			e.printStackTrace();
		}

	}
	
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pegando os parâmetros passados pelo formulário
	
	}

	
	protected void logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		//String admin = "admin";
		Cliente cliente = new ClienteDao().login(login, senha);
		Admin admin = new AdminDao().consultarLoginSenha(login, senha);

		if (admin != null) {

			request.getSession().setAttribute("admin", admin);
			request.getSession().setAttribute("login", login);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {
		 
			try {

				if (cliente != null) {					
					
					request.getSession().setAttribute("cliente", cliente);
					request.getSession().setAttribute("login", login);	
					response.sendRedirect("sessaoCliente.jsp");
				} else {
					request.setAttribute("msg", "<div class='alert alert-danger'>Login não Encontrado!</div>");
					request.getRequestDispatcher("loginCliente.jsp").forward(request, response);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "Erro" + e.getMessage());
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
	}
	
	public void buscar(HttpServletRequest request, HttpServletResponse response) {
		try {
			String nomeCliente = request.getParameter("nome");
			ClienteDao pd = new ClienteDao();

			List<Cliente> lista = pd.listarCliente(nomeCliente);

			if (lista.size() == 0) {
				request.setAttribute("msg", "<div class='alert alert-info'>Nenhum Cliente Encontrado!</div>");
			}
			request.setAttribute("nomeCliente", nomeCliente);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("buscaCliente.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	protected void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Invalidando a sessão e deslogar do sistema
		request.getSession().invalidate();
		response.sendRedirect("home.jsp");
	}
	protected void sairAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Invalidando a sessão e deslogar do sistema
		request.getSession().invalidate();
		response.sendRedirect("home.jsp");
	}

}
