package br.com.ProjetoCRUD.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ProjetoCRUD.dao.ProdutoDao;
import br.com.ProjetoCRUD.entidades.Categoria;
import br.com.ProjetoCRUD.entidades.Produto;
/**
 * Servlet implementation class ProdutoControle
 */
@WebServlet(name="/ProdutoControle",urlPatterns= {"/cadastrarProduto","/buscarProduto"})
public class ProdutoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Pegando uma URL que chamou a Servlet
			String url = request.getServletPath();
			if (url.equalsIgnoreCase("/cadastrarProduto")) {
				cadastrar(request, response);
			}else if (url.equalsIgnoreCase("/buscarProduto")) {
				buscar(request, response);
			}/*else if(url.equalsIgnoreCase("/excluirProduto")) {
				excluir(request, response);
			}else if(url.equalsIgnoreCase("/editarProduto")) {
				editar(request, response);
			}else if(url.equalsIgnoreCase("/confirmarProduto")) {
				confirmar(request, response);
			}*/
                     else {
				throw new Exception("URL Inválida!!!");
			}
		} catch (Exception e) {
			response.sendRedirect("cadastraProduto.jsp");
			e.printStackTrace();
		}
	}
	
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		double preco = Double.parseDouble(request.getParameter("preco").replace(',', '.')) ;
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));

		Produto produto = new Produto();
		Categoria categoria = new Categoria();

		produto.setNome(nome);
		produto.setEstoque(estoque);
		produto.setPreco(preco);		
		categoria.setIdCategoria(idCategoria);

		// Relacionando as Classes Produto com Categoria
		produto.setCategoria(categoria);

		// Gravando os dados no Banco de Dados
		// Populando o Banco de Dados
		ProdutoDao pd = new ProdutoDao();
		try {
			pd.cadastrarProduto(produto);
			request.setAttribute("msg", "<div class='alert alert-success'>Produto cadastrado com sucesso!!!</div>");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "<div class='alert alert-danger'>Produto não cadastrado!!!</div>");
		} finally {
			request.getRequestDispatcher("cadastraProduto.jsp").forward(request, response);
		}

	}
	public void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			ProdutoDao pd = new ProdutoDao();

			List<Produto> lista = pd.buscarProduto(nome);

			if (lista.size() == 0) {
				request.setAttribute("msg", "<div class='alert alert-info'>Nenhum Produto na lista!!!</div>");
			}
			request.setAttribute("nome", nome);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("buscaProduto.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

