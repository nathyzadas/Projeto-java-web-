<!DOCTYPE html>
<%@page import="br.com.ProjetoCRUD.entidades.Cliente"%>
<%@page import="br.com.ProjetoCRUD.dao.ClienteDao"%>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<!-- - - - - - - - -| CSS | - - - - - - - - -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/private.css">
<link rel="stylesheet" href="css/private-clientes.css">
<link rel="stylesheet" href="css/conteudo-pag.css">
<!-- - - - - - - - -| FONTE | - - - - - - - - -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kanit:wght@200;300;700;900&family=Montserrat:wght@300;400:500&display=swap"
	rel="stylesheet">
<!-- - - - - - - - -| ANIMAÇÃO | - - - - - - - - -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<!-- - - - - - - - -| ÍCONE | - - - - - - - - -->
<link
	href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp"
	rel="stylesheet">
<!-- - - - - - - - -| TÍTULO & ÍCONE HEAD | - - - - - - - - -->
<title>Clientes | Four</title>
<link rel="icon" type="image/x-icon" href="../images/icon.png">
<!-- - - - - - - - -| JQUERY/JS | - - - - - - - - -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>

<body>
	<%
	String email = session.getAttribute("email").toString();
	Cliente cliente = ClienteDao.getElementById(email);
	request.setAttribute("cliente", cliente);
	%>
	<div>
		<!-- - - -| NAVBAR CANTO ESQUERDO <<= | - - - -->
		<nav class="nav">
			<div class="content-nav">
				<div class="content-img display-f justify-c">
					<a href="index-private-adm.jsp"><img class="img"
						src="./images/logo2.png" alt="Logo barbearia Duhel"></a>
				</div>
				<div class="content-menu">
					<div class="display-f justify-c">
						<div class="circulo"></div>
					</div>
					<div class="content-opcoes">
						<div class="display-f justify-c">
							<p class="f-mont f-700 f-18 color-white">Ol�, Bem-Vindo !</p>
						</div>
						<div class="display-f justify-c">
							<div class="linha"></div>
						</div>

						<ul class="principal">

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

		<!-- - - -| BARRA SUPERIOR DO SITE ^ | - - - -->
		<header
			class="header display-f justify-bt align-c content-body f-mont f-700 f-16 principal">
			<div
				class="display-f justify-bt align-c header-inicio content-header-list f-mont f-700 f-20">
				<p>Bem vindo !</p>

			</div>
				<div class="header-final principal">
                    <a href="logout-login.jsp" class="display-f align-c justify-c">
                        <span class="material-icons-round m-r">power_settings_new</span>
                        Sair
                    </a>
               </div>
		</header>


		<!-- - - -| - = - = - = - = - = - = - = - = - = - = - = - | - - - -->
		<!-- - - -| CORPO DO SITE ⬇️ | - - - -->
		<div class="content-pagina">
			<div class="content-body">
				<p></p>

				<!-- - - -| ESTRUTURA QUE PUXA AS INFORMAÇÕES DO BANCO ⬇️ | - - - -->

				<div class="display-f align-c w-100 content-card-content">
					<div class="card-pag-cliente animate_card">
						<div class="content-card">
							<div class="display-f align-c justify-c f-kanit f-900 f-20 upper m-b">
								<span class="material-icons-round m-r color-blue">account_circle</span>
								${cliente.getNome()}
							</div>

							<div class="display-f align-c justify-c f-kanit f-900 f-18 m-b">
								<span class="material-icons-round m-r">folder_shared</span>
								${cliente.getCpf()}
							</div>

							<div class="display-f align-c justify-c f-kanit f-900 f-18 m-b">
								<span class="material-icons-round m-r">phone</span> Celular:
								${cliente.getCelular()}
							</div>

							<div class="display-f align-c justify-c f-kanit f-900 f-18 m-b">
								<span class="material-icons-round m-r">email</span> E-mail:
								${cliente.getEmail()}
							</div>



						</div>
					</div>
				</div>

			</div>

		</div>
	</div>


</body>

</html>