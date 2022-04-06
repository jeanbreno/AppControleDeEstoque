<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
	<title>Cadastro de Roupa - AppEstoque - Infnet</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
	<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
	<c:import url="/WEB-INF/jsp/menu-voltar.jsp"/>
	</div>
	</header>
	
	<div class="container">
	
		<form action="/roupa/incluir" method="post">
			<h2>Cadastramento de Roupas</h2>
		
			<div class="form-group">
				<label>Descrição:</label>
				<input type="text" class="form-control" name="descricao" value="Camisa Marca X"> 
			</div>
			
			<div class="form-group">
				<label>Valor:</label>
				<input type="text" class="form-control" name="valor" value="20">
			</div>
			
			<div class="form-group">
				<label>Tamanho:</label>
				
				<div class="radio">
				  <label><input type="radio" name="tamanho" value="PP"> Tamanho PP</label>
				</div>				
				<div class="radio">
				  <label><input type="radio" name="tamanho" value="P"> Tamanho P</label>
				</div>				
				<div class="radio">
				  <label><input type="radio" name="tamanho" value="M" checked> Tamanho M</label>
				</div>				
				<div class="radio">
				  <label><input type="radio" name="tamanho" value="G"> Tamanho G</label>
				</div>	
				<div class="radio">
				  <label><input type="radio" name="tamanho" value="GG"> Tamanho GG</label>
				</div>			
			</div>
			
			<div class="form-group">
			  	<label for="quantidade">Quantidade:</label>
  				<input type="number" id="quantidade" name="quantidade" min="1" max="10" value="5">
			</div>
			
			<div class="form-group">
				<label>Disponibilidade:</label>
				<select name="disponibilidade" class="form-control">
					<option value="I">Imediata</option>
					<option value="EM" selected>Máximo 2 dias</option>
					<option value="EP">Mínimo 3 dias</option>
				</select>
			</div>

			<button type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>
