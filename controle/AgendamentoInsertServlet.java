package br.com.ProjetoCRUD.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ProjetoCRUD.dao.AgendamentoDao;
import br.com.ProjetoCRUD.entidades.Agendamento;

/**
 * Servlet implementation class AgendamentoInsertServlet
 */
@WebServlet("/AgendamentoInsertServlet")
public class AgendamentoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendamentoInsertServlet() {
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
	    
		// Recupera o ID do cliente autenticado na sessão (supondo que seja um atributo chamado "authenticatedClientId")
		Integer authenticatedClientId = (Integer) request.getSession().getAttribute("authenticatedClientId");

		if (authenticatedClientId != null) {
		    int clientId = authenticatedClientId.intValue();
		
		// Recupera os parâmetros do formulário
	    String idAgendaParam = request.getParameter("idAgenda");
	    String dataAgenda = request.getParameter("dataAgenda");
	    String horaAgenda = request.getParameter("horaAgenda");
	    String nomeServico = request.getParameter("nomeServico");
	    String nomeFuncionario = request.getParameter("nomeFuncionario");
	    String nomeCliente = request.getParameter("nomeCliente");
	    String idServicoParam = request.getParameter("idServico");
	    String idClienteParam = request.getParameter("idCliente");	    
	    String idFuncionarioParam = request.getParameter("idFuncionario");

	    // Verifica se os parâmetros obrigatórios foram preenchidos
	    if (idAgendaParam != null && !idAgendaParam.isEmpty() &&
	        dataAgenda != null && !dataAgenda.isEmpty() &&
	        horaAgenda != null && !horaAgenda.isEmpty() &&
	        nomeServico != null && !nomeServico.isEmpty() &&
	        nomeFuncionario != null && !nomeFuncionario.isEmpty() &&
	        nomeCliente != null && !nomeCliente.isEmpty() &&
	        idServicoParam != null && !idServicoParam.isEmpty( )&&
	        idClienteParam != null && !idClienteParam.isEmpty() &&
	        idFuncionarioParam != null && !idFuncionarioParam.isEmpty()
	        ) {

	        try {
	            // Faz a conversão dos parâmetros para inteiros
	            int idAgenda = Integer.parseInt(idAgendaParam);
	            int idServico = Integer.parseInt(idServicoParam);
	            int idCliente = Integer.parseInt(idClienteParam);
	            int idFuncionario = Integer.parseInt(idFuncionarioParam);
	            

	            // Cria o objeto Agendamento com os dados do formulário
	            Agendamento agendamento = new Agendamento (idAgenda, dataAgenda, horaAgenda, nomeServico, nomeFuncionario, nomeCliente, idServico, idCliente, idFuncionario);

	            // Insere o agendamento no banco de dados
	            AgendamentoDao agendamentoDao = new AgendamentoDao();
	            agendamentoDao.insert(agendamento);

	            // Redireciona para a página de listagem de agendamentos
	            response.sendRedirect("./private-adm/info-agenda.jsp");
	            
	            
	        } catch (NumberFormatException e) {
	            // Trata o erro de conversão caso algum dos parâmetros não seja um número válido
	            // Você pode redirecionar para uma página de erro ou exibir uma mensagem de erro no próprio formulário
	            response.sendRedirect("pagina_de_erro.jsp");
	        } catch (Exception e) {
	            // Trata outros erros que possam ocorrer na inserção do agendamento no banco de dados
	            // Você pode redirecionar para uma página de erro ou exibir uma mensagem de erro no próprio formulário
	            response.sendRedirect("pagina_de_erro.jsp");
	        }
	    } else {
	        // Caso algum dos campos obrigatórios do formulário não esteja preenchido,
	        // redirecione para uma página de erro ou exiba uma mensagem de erro no próprio formulário
	        response.sendRedirect("pagina_de_erro.jsp");
	    }
	}

	}	
}
