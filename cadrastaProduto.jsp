<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>ProjetoCRUD</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- Carregando a classe CategoriaBean(que contem a lista de Categoria) -->

<jsp:useBean id="cb" class="br.com.ProjetoCRUD.categoria.CategoriaBean"></jsp:useBean>

<div class="container">
<h3 class="page-header"> Sistema de Produtos</h3>

<form id="cadastro" method="post" action="cadastrarProduto">
    <div class="form-group">
	    Nome do produto:
	    <input type="text" name="nome" class="form-control">
    </div>   
    <div class="form-group">
	    Estoque:
	    <input type="number" name="estoque" class="form-control">
    </div>    
     <div class="form-group">
	    Preco:
	    <input type="text" name="preco" class="form-control">
    </div>
 
    <div class="form-group">
	    Categoria do Produto:
	    <select name="categoria" class="form-control">
		    <option value="0">Selecione</option>
		    <c:if test="${fn:length(cb.listaCategoria) > 0}">
		    	<c:forEach items="${cb.listaCategoria }" var="cat">    
		    		<option value="${cat.idCategoria }">${cat.nomeCategoria }</option> 
	    		</c:forEach>
	    	</c:if>   	    
	    </select>
    </div>    
    <input type="submit" value="Cadastrar Produto" class="btn btn-primary">

</form>

${msg}
</div>



</body>
</html>
html>