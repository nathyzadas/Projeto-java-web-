<%@ page import="java.util.List" %>
<%@ page import="br.com.ProjetoCRUD.dao.ClienteDao" %>
<%@ page import="br.com.ProjetoCRUD.dao.ServicoDao" %>
<%@ page import="br.com.ProjetoCRUD.dao.FuncionarioDao" %>
<%@ page import="br.com.ProjetoCRUD.entidades.Cliente" %>
<%@ page import="br.com.ProjetoCRUD.entidades.Servico" %>
<%@ page import="br.com.ProjetoCRUD.entidades.Funcionario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Recupera a lista de clientes e serviços do banco de dados
    List<Cliente> listaCliente = null;
    List<Servico> listaServico = null;
    List<Funcionario> listaFuncionario = null;

    try {
        ClienteDao clienteDao = new ClienteDao();
        ServicoDao servicoDao = new ServicoDao();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        listaCliente = clienteDao.buscarCliente();
        listaServico = servicoDao.buscarServico();
        listaFuncionario = funcionarioDao.buscarFuncionario();
    } catch (Exception e) {
        out.println(e.getMessage());
    }
%>


<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!-- - - - - - - - -| CSS | - - - - - - - - -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/private.css">
    <link rel="stylesheet" href="css/private-agenda.css">
    <!-- - - - - - - - -| FONTE | - - - - - - - - -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@200;300;700;900&family=Montserrat:wght@300;400:500&display=swap" rel="stylesheet">
    <!-- - - - - - - - -| ANIMAÃÃO | - - - - - - - - -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
    <!-- - - - - - - - -| ÃCONE | - - - - - - - - -->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <!-- - - - - - - - -| ÃCONE | - - - - - - - - -->
    <link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp" rel="stylesheet">

    <meta charset="UTF-8">
    <title>Agenda | FourBarber</title>
    <link rel="icon" type="image/x-icon" href="../images/icon.png">
</head>

<body>
    <div class="content">
        <!-- - - -| NAVBAR CANTO ESQUERDO â | - - - -->
        <nav class="area-a">
            <div class="content-nav">
                <div class="content-img display-f justify-c">
                    <a href="index-private-adm.jsp"><img class="img" src="./images/logo2.png" alt="Logo barbearia Duhel"></a>
                </div>
                <div class="content-menu">
                    <div class="display-f justify-c">
                        <div class="circulo"></div>
                    </div>
                    <div class="content-opcoes">
                        <div class="display-f justify-c">
                            <p class="f-mont f-700 f-18 color-white">Olá, Bem-Vindo!</p>
                        </div>
                        <div class="display-f justify-c">
                            <div class="linha"></div>
                        </div>

                            <a href="area-cliente.jsp">
								<li class="f-mont f-700 f-16"><span
									class="material-icons-round m-r">account_circle</span> Perfil </li>
							</a>

							<a href="https://wa.me/5521990539801?text=Ol%C3%A1%2C+gostaria+de+realizar+um+agendamento.">
								<li class="f-mont f-700 f-16"><span
									class="material-icons-round m-r">event_available</span> Agendamento </li>
							</a>

							<a href="form-cliente.jsp">
								<li class="f-mont f-700 f-16"><span
									class="material-icons m-r">contact_mail</span> Mensagens </li>
							</a>
							
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

        <div class="area-b">
            <!-- - - -| BARRA SUPERIOR DO SITE â | - - - -->
            <header class="display-f justify-bt align-c content-body f-mont f-700 f-16">
                <div class="display-f justify-bt align-c header-inicio content-header-cad f-mont f-700 f-20">
                    <div>
                        <a href="./info-agenda.jsp" class="display-f align-c">
                            <span class="material-icons-outlined m-r">arrow_back</span>
                            <p>Agendamento</p>
                        </a>
                    </div>

                </div>
                <div class="header-final principal">
                    <a href="logout-login.jsp" class="display-f align-c justify-c">
                        <span class="material-icons-round m-r">power_settings_new</span>
                        Sair
                    </a>
                </div>
            </header>

            <!-- - - -| FORMULÃRIO DE CADASTRO â | - - - -->
            <main class="display-f align-c justify-c">
                <div class="bg-form ">
                    <div class="content-body">
                        <div class="display-f align-c justify-c content-form">
                            <div class="card">
                                <div class="label-titulo">
                                    <label class="display-f align-c justify-c f-mont f-900 f-36 color-label">
                                        <span class="material-icons-round m-r color-blue">event_available</span>
                                        Agendamento
                                    </label>
                                </div>

                    <form method="post" action="AgendamentoInsertServlet">
							    <input type="hidden" value="${idcliente}" name="idCliente">
							
							    <label class="f-mont f-500 f-18">Data</label>
							    <input class="f-mont f-500 f-14 input" type="date" name="dataAgenda" id="dataAgenda">
							    <br><br>
							
							    <label class="f-mont f-500 f-18">Hora</label>
							    <input class="f-mont f-500 f-14 input" type="time" name="horaAgenda" id="horaAgenda">
							    <br><br>
							
							   <label class="f-mont f-500 f-18">Selecione um Serviço</label>
                                    <select class="f-mont f-500 f-14 input" name="idServico">
                                        <option value="0" selected>-Selecione um Serviço-</option>
                                        <% for (Servico servico : listaServico) { %>
                                            <option value="<%= servico.getIdServico() %>">
                                                <%= servico.getNomeServico() %>
                                            </option>
                                        <% } %>
                                    </select>     

                                    <br><br>
									<label class="f-mont f-500 f-18">Selecione um Barbeiro</label>
                                    <select class="f-mont f-500 f-14 input" name="idFuncionario" id="idFuncionario">
                                         <option value="0" selected>-Selecione um Funcionário-</option>
                                        <% for (Funcionario funcionario : listaFuncionario) { %>
                                            <option value="<%= funcionario.getIdFuncionario() %>">
                                                <%= funcionario.getNomeFuncionario() %>
                                            </option>
                                        <% } %>
                                    </select>
							
							    <input onclick="abrirAlerta2()" class="button f-mont f-700 f-18" type="submit" value="Agendar">
							    <input class="button2 f-mont f-700 f-18" type="reset" value="Limpar">
				</form>


                                
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>



</body>

</html>