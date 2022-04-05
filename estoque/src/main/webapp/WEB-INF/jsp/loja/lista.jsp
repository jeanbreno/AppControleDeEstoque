<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
	<title>Estoque</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container fixed-top" >	

		<h4>Cadastramento de lojas:</h4>

		<form action="/loja" method="get">
			<button type="submit">Nova Loja</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty lojaLista}">
		  	<p>Quantidade de lojas cadastrados: ${lojaLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>CNPJ</th>
			        <th>Usuário</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="l" items="${lojaLista}">
			      <tr>
			        <td>${l.nome}</td>
			        <td>${l.email}</td>
			        <td>${l.cnpj}</td>
			        <td>${l.usuario.nome}</td>
			        <td><a href="/loja/${l.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>CNPJ</th>
			        <th>Usuário</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty lojaLista}">
	  		<p>Não existem lojas cadastrados!!!</p>            
	  	</c:if>
	</div>
</body>
</html>