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

	<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
	<c:import url="/WEB-INF/jsp/menu-voltar.jsp"/>
	</div>
	</header>

	<div class="container">
	
		<form action="/camisa/incluir" method="post">
			<h2>Cadastramento de Camisas</h2>
		
			<div class="form-group">
				<label>Nome:</label>
				<input type="text" class="form-control" name="nome" value="Calca Nike lT"> 
			</div>
		
			<div class="form-group">
				<label>Descrição:</label>
				<input type="text" class="form-control" name="descricao" value="Calça preta com elastico e brasao"> 
			</div>

			<div class="form-group">
				<label>Valor:</label>
				<input type="text" class="form-control" name="valor" value="99"> 
			</div>

			<div class="form-group">
				<label>Disponibilidade:</label>
				<input type="text" class="form-control" name="disponibilidade" value="Imediata"> 
			</div>

			<div class="form-group">
				<label>Tamanho:</label>
				<input type="text" class="form-control" name="tamanho" value="GG"> 
			</div>
			<div class="form-group">
				<label>Quantidade:</label>
				<input type="text" class="form-control" name="quantidade" value="5"> 
			</div>
			
			<div class="form-group">
				<label>Marca:</label>
				<input type="text" class="form-control" name="marca" value="NIKE"> 
			</div>
			<div class="form-group">
				<label>Secao:</label>
				<input type="text" class="form-control" name="secao" value="T56A"> 
			</div>

			<div class="form-group">
				<label>Características:</label>
				
				<div class="checkbox">
				  <label><input type="checkbox" name="especial" value="true" checked> Especial?</label>
				</div>							
			</div>
			<button type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>