<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>App.2022 - Java</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.alert {
	padding: 20px;
	background-color: #f44336;
	color: white;
	opacity: 1;
	transition: opacity 0.6s;
	margin-bottom: 15px;
}

.alert.success {
	background-color: #04AA6D;
}

.alert.info {
	background-color: #2196F3;
}

.alert.warning {
	background-color: #ff9800;
}

.closebtn {
	margin-left: 15px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}
</style>
</head>
<body>
	<header class="masthead">
		<div class="container px-4 px-lg-5 h-100">
			<c:import url="/WEB-INF/jsp/menu-voltar.jsp" />
		</div>
	</header>

	<div class="container">

		<h4>Cadastramento de usuários:</h4>


		<c:if test="${not empty mensagem}">
			<div class="alert success">
				<span class="closebtn">&times;</span> <strong>Confirmação!</strong>
				${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty usuarioLista}">
			<p>Quantidade de usuários cadastrados: ${usuarioLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Admin</th>
						<th>Endereço</th>
						<th>Lojas</th>
						<th>Roupas</th>
						<th>Pedidos</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="u" items="${usuarioLista}">
						<tr>
							<td>${u.nome}</td>
							<td>${u.email}</td>
							<td>${u.admin}</td>
							<td>${u.endereco.uf}</td>
							<td>${u.lojas.size()}</td>
							<td>${u.roupas.size()}</td>
							<td>${u.pedidos.size()}</td>
							<td><c:if test="${user.admin}">
									<c:if test="${user.id != u.id}">
										<a href="/usuario/${u.id}/excluir">Excluir</a>
									</c:if>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Admin</th>
						<th>Endereço</th>
						<th>Lojas</th>
						<th>Roupas</th>
						<th>Pedidos</th>
						<th></th>
					</tr>
				</tfoot>
			</table>
		</c:if>

		<c:if test="${empty usuarioLista}">
			<p>Não existem usuários cadastrados!!!</p>
		</c:if>
	</div>


	<script>
			var close = document.getElementsByClassName("closebtn");
			var i;
			
			for (i = 0; i < close.length; i++) {
			  close[i].onclick = function(){
			    var div = this.parentElement;
			    div.style.opacity = "0";
			    setTimeout(function(){ div.style.display = "none"; }, 600);
			  }
			}
		</script>
</body>
</html>