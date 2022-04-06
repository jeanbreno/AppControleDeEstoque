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
</head>
<body>

	<c:set var="statusBotao" value="enable" />

	<header class="masthead">
		<div class="container px-4 px-lg-5 h-100">
			<c:import url="/WEB-INF/jsp/menu-voltar.jsp" />
		</div>
	</header>

	<div class="container">

		<form action="/pedido/incluir" method="post">
			<h2>Cadastramento de Pedidos</h2>

			<div class="form-group">
				<label>Descrição:</label> <input type="text" class="form-control"
					name="descricao" value="Remessa de roupas loja TY">
			</div>

			<div class="form-group">
				<label>Numero do Pedido:</label> 
				<input type="text"
					class="form-control" name="numeroPedido" value="3">
			</div>

			<div class="form-group">
				<c:if test="${not empty lojaLista}">
					<label>Loja:</label>
					<select name="loja.id" class="form-control">
						<c:forEach var="l" items="${lojaLista}">
							<option value="${l.id}">${l.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				
				<c:if test="${empty lojaLista}">
					<label>Nenhuma loja cadastrado!!!</label>
					<c:set var="statusBotao" value="disabled"/>
				</c:if>
				
			</div>

			<div class="form-group">
				<c:if test="${not empty roupaLista}">
					<label>Roupas:</label>

					<c:forEach var="p" items="${roupaLista}">
						<div class="checkbox">
							<label><input type="checkbox" name="idsRoupas"
								value="${p.id}" checked> ${p.descricao}</label>
						</div>
					</c:forEach>
				</c:if>

				<c:if test="${empty roupaLista}">
					<label>Nenhuma roupa cadastrado!!!</label>
					<c:set var="statusBotao" value="disable" />
				</c:if>
			</div>

			<button ${statusBotao} type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>