<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
	<title>App.2022 - Java</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>

	<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	</div>
	</header>

	<div class="container">
	
		<form action="/bebida/incluir" method="post">
			<h2>Cadastramento de Bebidas</h2>
		
			<div class="form-group">
				<label>Descri��o:</label>
				<input type="text" class="form-control" name="descricao" value="Suco de Manga"> 
			</div>

			<div class="form-group">
				<label>Valor:</label>
				<input type="text" class="form-control" name="valor" value="10"> 
			</div>

			<div class="form-group">
				<label>Peso:</label>
				<input type="text" class="form-control" name="peso" value="300"> 
			</div>

			<div class="form-group">
				<label>Marca:</label>
				<input type="text" class="form-control" name="marca" value="DaFruta"> 
			</div>

			<div class="form-group">
				<label>Caracter�sticas:</label>
				
				<div class="checkbox">
				  <label><input type="checkbox" name="importada" value="true" checked> Importada</label>
				</div>				
				<div class="checkbox">
				  <label><input type="checkbox" name="gelada" value="true" checked> Gelada</label>
				</div>				
			</div>

			<button type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>