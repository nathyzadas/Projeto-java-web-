<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<!-- - - - - - - - - | CSS | - - - - - - - - -->
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/global.css">
<link rel="stylesheet" href="./css/login.css">
<!-- - - - - - - - - | FONTE | - - - - - - - - -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kanit:wght@200;900&family=Montserrat:wght@300;400:500&display=swap"
	rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- - - - - - - - - | ANIMAÇÃO | - - - - - - - - -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<!-- - - - - - - - - | TÍTULO & ÍCONE HEAD | - - - - - - - - -->
<title>Login | FourBarber </title>
<link rel="icon" type="image/x-icon" href="./images/icon.png">
<!-- - - - - - - - - | JQUERY/JS | - - - - - - - - -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>

<body>
	<main class="content">
		<section class="area-a">
			<div class="background f-kanit f-900 f-24">
				<p class="title animation">Todo dia � dia para dar um trato no
					visual .</p>

				<div class="position-logo display-f align-c justify-bt">
					<div class="">
						<ul class="display-f align-c">
							<li class="f-mont f-400 f-16"><a href="./indexhome.jsp">Home</a></li>
							<li class="f-mont f-400 f-16"><a href="./indexhome.jsp#sobre">Sobre
									N�s</a></li>
							<li class="f-mont f-400 f-16"><a href="./home-servicos.jsp">Servi�os</a></li>
							<li class="f-mont f-400 f-16"><a href="./home-produtos.jsp">Produtos</a></li>
							<li class="f-mont f-400 f-16"><a href="./login.jsp">Agendamento</a></li>
							<li class="f-mont f-400 f-16"><a href="./form-faleconosco.jsp">Fale Conosco</a></li>
						</ul>
					</div>
					<div>
						<img class="logo" src="./images/logo2.png" alt="Logo Duhel">
					</div>
				</div>
			</div>
		</section>

		<section class="area-b">
			<div class="heigth display-f justify-c align-c">
				<div class="form">
					<form action="ValidarCliente" method="post">
						<label class="f-kanit f-900 t-center f-36 title-login">Entre</label>
						<label class="f-mont f-500 f-18">Email</label> <input
							class="input-login" type="text"
							placeholder="Digite o seu nome de usu�rio" name="txtLogin"
							id="txtLogin" required >
							 <label
							class="f-mont f-500 f-18">Senha</label> <input
							class="input-login" type="password"
							placeholder="Digite sua senha" name="txtSenha" id="txtSenha"
							maxlength="8" required> <input
							class="button f-mont f-700 f-18" type="submit" value="Entrar">
						<ul></ul>
						<p>
							N�o � cadastrado? <a href="cadastra-login.jsp">Cadastre-se aqui</a>.
						</p>
					</form>
				</div>
			</div>
		</section>
	</main>
</body>

</html>