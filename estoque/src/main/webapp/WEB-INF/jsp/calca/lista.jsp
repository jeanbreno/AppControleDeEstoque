<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Estoque</title>
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

		<h4>Cadastramento de calcas:</h4>

		<form action="/calca" method="get">
			<button type="submit">Nova calca</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert success">
				<span class="closebtn">&times;</span> <strong>Confirmação!</strong>
				${mensagem}
			</div>
		</c:if>


		<c:if test="${not empty calcaLista}">
			<p>Quantidade de calcas cadastradas: ${calcaLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Descricao</th>
						<th>Valor</th>
						<th>Disponibilidade</th>
						<th>Tamanho</th>
						<th>Quantidade</th>
						<th>Marca</th>
						<th>Especial</th>
						<th>Secao</th>
						<th>Estilo</th>
						<th>ComCinto</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${calcaLista}">
						<tr>
							<td>${c.id}</td>
							<td>${c.nome}</td>
							<td>${c.descricao}</td>
							<td>${c.valor}</td>
							<td>${c.disponibilidade}</td>
							<td>${c.tamanho}</td>
							<td>${c.quantidade}</td>
							<td>${c.marca}</td>
							<td>${c.especial}</td>
							<td>${c.secao}</td>
							<td>${c.estilo}</td>
							<td>${c.comCinto}</td>
							<td><a href="/calca/${c.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Descricao</th>
						<th>Valor</th>
						<th>Disponibilidade</th>
						<th>Tamanho</th>
						<th>Quantidade</th>
						<th>Marca</th>
						<th>Especial</th>
						<th>Secao</th>
						<th>Estilo</th>
						<th>ComCinto</th>
						<th></th>
					</tr>
				</tfoot>
			</table>
		</c:if>

		<c:if test="${empty calcaLista}">
			<p>Não existem calcas cadastradas!!!</p>
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