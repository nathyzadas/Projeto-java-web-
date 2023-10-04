package br.com.ProjetoCRUD.controle;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.ProjetoCRUD.dao.ServicoDao;
import br.com.ProjetoCRUD.entidades.Servico;

/**
 * Servlet implementation class ProdutoInsertServlet
 */
@WebServlet("/ServicoInsertServlet")
@MultipartConfig
public class ServicoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServicoInsertServlet() {
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
		String fotoServico = "";
		Part filePart = request.getPart("fotoServico");

		// Obtém o nome original do arquivo
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

		String path = getServletContext().getRealPath("/uploads/");
		// Grava o arquivo em disco
		File file = new File(path + fileName);
		try (InputStream fileContent = filePart.getInputStream()) {
			Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

			fotoServico = fileName;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		// =====================================================
		String descServico = request.getParameter("descServico");
		String nomeServico = request.getParameter("nomeServico");
		//String image = request.getParameter("fotoProduto");
		Servico servico = new Servico(nomeServico, fotoServico, descServico);
		try {
			ServicoDao servicoDao = new ServicoDao();
			servicoDao.insert(servico);
			response.sendRedirect("./private-adm/info-servico.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage()+"servlet");
			// TODO: handle exception
		}

	}

}

