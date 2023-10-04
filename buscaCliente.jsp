<jsp:include page="menu.jsp"></jsp:include>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3 class="page-header">Buscar Cliente</h3>

<form action="buscarCliente" method="post">
	<div class="form-group">
		Nome: <input type="text" name="nome"
			placeholder="Nome do Cliente" class="form-control">
	</div>
	<input type="submit" value="Buscar Cliente" class="btn btn-primary">
</form>
${msg}
<c:if test="${fn:length(lista) > 0 }">
	<table class="table table-bordered">
		<tr align="center">
			<th>ID</th>
			<th>NOME CLIENTE</th>
			<th>EMAIL</th>
			<th>CPF</th>
			<th colspan="2">AÇÕES</th>
		</tr>
		<c:forEach items="${lista}" var="cli">
			<tr align="center">
				<td>${cli.idCliente}</td>
				<td>${cli.nome}</td>
				<td>${cli.email}</td>
				<td>${cli.cpf}</td>
				<td><a href="editarCliente.html?id=${cli.idCliente}"
					class="btn btn-warning">Editar</a></td>
				<td><a href="excluirCliente.html?id=${cli.idCliente}"
					class="btn btn-danger"
					onclick="return confirm('Deseja realmente excluir o Cliente?')">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<jsp:include page="rodape.jsp"></jsp:include>


l>