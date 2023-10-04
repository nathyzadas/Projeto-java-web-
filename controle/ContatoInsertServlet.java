package br.com.ProjetoCRUD.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ProjetoCRUD.dao.ContatoDao;
import br.com.ProjetoCRUD.entidades.Contato;

@WebServlet("/ContatoInsertServlet")
public class ContatoInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ContatoInsertServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String emailContato = request.getParameter("emailContato");
        String textoContato = request.getParameter("txtContato"); // Corrigido o nome do parâmetro

        Contato contato = new Contato();
        contato.setEmailContato(emailContato);
        contato.setTextoContato(textoContato);

        try {
            ContatoDao contatoDao = new ContatoDao();
            contatoDao.insert(contato);

            // Definir atributos de sessão e de solicitação
            session.setAttribute("email", emailContato);
            request.setAttribute("msg", "<div class='alert alert-success'>Mensagem enviada!</div>");
            // Usar o método forward para exibir a mensagem e o redirecionamento
            request.getRequestDispatcher("./indexhome.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.setAttribute("msg", "<div class='alert alert-danger'>Mensagem não enviada!</div>");
            // Usar o método forward para exibir a mensagem de erro
            request.getRequestDispatcher("./indexhome.jsp").forward(request, response);
        }
    }
}