
<!DOCTYPE html>
<html lang="pt-br">
<head>
<!-- - - - - - - - - | CSS | - - - - - - - - -->
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/global.css">
<link rel="stylesheet" href="./css/login.css">

<!-- - - - - - - - -| JQUERY/JS | - - - - - - - - -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<!-- - - - - - - - - | FONTE | - - - - - - - - -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kanit:wght@200;900&family=Montserrat:wght@300;400:500&display=swap"
	rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- - - - - - - - - | ANIMAÃ‡ÃƒO | - - - - - - - - -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<!-- - - - - - - - - | TÃTULO & ÃCONE HEAD | - - - - - - - - -->
<title>FourBarber | Login</title>
<link rel="icon" type="image/x-icon" href="./images/logo2.png">

</head>
<title>Cadastrar</title>
</head>

<style>
.button2 { 
	margin-top: 20px;
	background-color: var(--wine);
	color: var(--grey-ligth);
	border-radius: 8px;
	border: none;
	transition: 800ms all;
}

#cpf {

	margin-top: 10px;
	
}

</style>

<body>
	<main class="content">
		<section class="area-a">
			<div class="background f-kanit f-900 f-24">
				<p class="title animation">Todo dia é dia para dar um trato no visual.</p>

				<div class="position-logo display-f align-c justify-bt">
					<div class="">
						<ul class="display-f align-c">
							<li class="f-mont f-400 f-16"><a href="./indexhome.jsp">Home</a></li>
							<li class="f-mont f-400 f-16"><a href="./indexhome.jsp#sobre">Sobre Nós</a></li>
							<li class="f-mont f-400 f-16"><a href="./home-servicos.jsp">Serviços</a></li>
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
				
					<form action="ClienteInsertControle" method="post">
					
						<label class="f-kanit f-900 t-center f-36 title-login">Cadastre-se</label>
						
						<label class="f-mont f-500 f-18">Nome</label> <input
						
							class="input-login" type="text" placeholder="Digite seu nome"
							
							id="nomeCliente" name="nomeCliente" required name="nomeCliente"
							
							required maxlength="45"> 
							
							<label id="cpf" class="f-mont f-500 f-18">CPF</label>
							
						<input class="input-login" type="text"
						
							placeholder="Digite seu CPF" id="cpfCliente" name="cpfCliente"
							
							required name="cpfCliente">


						<ul></ul>


						<label class="f-mont f-500 f-18">Telefone</label> <input
							class="input-login" type="text"
							placeholder="Digite o número de telefone com o DDD"
							name="celularCliente" id="celularCliente">

						<ul></ul>


						<label class="f-mont f-500 f-18">Email</label> <input
							class="input-login" type="text" id="emailCliente" required
							name="emailCliente" placeholder="Digite seu email">


						<ul></ul>


						<label class="f-mont f-500 f-18">Senha</label> <input
							class="input-login" type="password"
							placeholder="Escolha uma senha com no mínimo 8 caracteres"
							name="senha" id="senha" minlength="8" required>


						<ul></ul>


						<!--  onclick="abrirAlerta()" -->

						<input class="button f-mont f-700 f-18" type="submit"
							value="Enviar">
							 <input class="button2 f-mont f-700 f-18"
							type="reset" value="Limpar"> <br>
						<p>
							Já é cadastrado? <a href="login.jsp">Entre aqui</a>.
						</p>
					</form>
				</div>
			</div>
		</section>
	</main>


</body>
</html>