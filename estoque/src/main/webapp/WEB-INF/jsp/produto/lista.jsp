<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
	    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1"/>
		<title>App.2022 - Java</title>
	  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	    
	    <style>
			.alert {
			  padding: 20px;
			  background-color: #f44336;
			  color: white;
			  opacity: 1;
			  transition: opacity 0.6s;
			  margin-bottom: 15px;
			}
			
			.alert.success {background-color: #04AA6D;}
			.alert.info {background-color: #2196F3;}
			.alert.warning {background-color: #ff9800;}
			
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
		<!-- <c:import url="/WEB-INF/jsp/menu.jsp"/> -->
	
		<div class="container fixed-top" >	
	
			<h4>Cadastramento de produtos:</h4>
	
			<form action="/produto" method="get">
				<button type="submit">Novo produto</button>
			</form>
	<%-- 
			<c:if test="${not empty mensagem}">
				<div class="alert alert-success">
				  <strong>Confirmação!</strong> ${mensagem}
				</div>
			</c:if>
			 --%>
	   		<c:if test="${not empty mensagem}">
				<div class="alert success">
				  	<span class="closebtn">&times;</span>  
				  	<strong>Confirmação!</strong> ${mensagem}
				</div>
			</c:if>
	
			<c:if test="${not empty produtoLista}">
			  	<p>Quantidade de produtos cadastrados: ${produtoLista.size()}</p>            
			  	<table class="table table-striped">
				    <thead>
				      <tr>
				        <th>Nome</th>
				        <th>E-mail</th>
				        <th>Idade</th>
				        <th>Curso</th>
				        <th>Região</th>
				        <!--<th>Usuário</th> -->
				        <th></th>
				      </tr>
				    </thead>
				    <tbody>
				    <c:forEach var="a" items="${produtoLista}">
				      <tr>
				        <td>${a.nome}</td>
				        <td>${a.email}</td>
				        <td>${a.idade}</td>
				        <td>${a.curso}</td>
				        <td>${a.regiao}</td>
				        <td>${a.usuario.nome}</td>
				        <td><a href="/produto/${a.id}/excluir">Excluir</a></td>
				      </tr>
					</c:forEach>
				    </tbody>
				    <tfoot>
				      <tr>
				        <th>Nome</th>
				        <th>E-mail</th>
				        <th>Idade</th>
				        <th>Curso</th>
				        <th>Região</th>
				        <th></th>
				      </tr>
				    </tfoot>
			  	</table>
			</c:if>
			
			<c:if test="${empty produtoLista}">
		  		<p>Não existem produtos cadastrados!</p>            
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