<jsp:include page="menu.jsp"></jsp:include>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container">

<h3 class="page-header">Buscar Produto</h3>

	<form action="buscarProduto" method="post">
		<div class="form-group">
			Nome:
			<input type="text" name="nome" placeholder="Nome do Produto" class="form-control">			
		</div>
			<input type="submit" value="Buscar Produto" class="btn btn-primary">
	</form>
	${msg}
	<c:if test="${fn:length(lista) > 0}">
		<table class="table table-bordered">
			<tr>			
				<th >ID</th>
				<th class="text-center">NOME</th>
				<th class="text-center">QTD ESTOQUE</th>
				<th class="text-center">PREÇO</th>
				
				<th class="text-center">CATEGORIA</th>
				<th class="text-center" colspan="2">AÇÕES</th>			
			</tr>	
			<c:forEach items="${lista}" var="prod">
				<tr class="text-center">
					<td>${prod.idProduto}</td>
					<td>${prod.nome}</td>
					<td>${prod.estoque}</td>
					<td>${prod.preco}</td>
					<td>${prod.categoria.nomeCategoria}</td>
					<td><a href="editarProduto?id=${prod.idProduto}" class="btn btn-warning">Editar</a></td>
					<td><a href="excluirProduto?id=${prod.idProduto}" class="btn btn-danger"
					onclick="return confirm('Deseja excluir realmente esse Registro?')">Excluir</a></td>
				</tr>
			</c:forEach>		
		</table>
	</c:if>
</div>
<jsp:include page="rodape.jsp"></jsp:include>