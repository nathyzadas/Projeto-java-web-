<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>ProjetoCRUD</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="styleSheet" href="css/estilo.css">
</head>
<body>
<div class="container">
<jsp:include page="topo.jsp"></jsp:include>
 	<h2>Cadastre-se</h2>
 	
<form id="cadastro" method="post" action="cadastrarCliente">
    <div class="form-group">
	    Nome do Cliente:
	    <input type="text" name="nome" class="form-control">
    </div>   
    <div class="form-group">
	    Email:
	    <input type="email" name="email" class="form-control" placeholder="Ao logar, insira seu e-mail">
    </div>    
    <div class="form-group">   
	    Senha:
	    <input type="password" name="senha" class="form-control">
    </div>    	
    <div class="form-group"> 
    	CPF:
    	<input type="text" id="cpf" name="cpf" class="form-control">
	</div>
	<input type="submit" value="Cadastrar Cliente" class="btn btn-primary">
		
</form>

${msg}
 </div>
 <jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>
