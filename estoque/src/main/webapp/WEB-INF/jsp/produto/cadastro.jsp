<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- %@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%-->
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
	<title>Cadastro de Produto - AppEstoque - Infnet</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
<!--  
	<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	</div>
	</header>
-->
	<div class="container">
	
		<form action="/aluno/incluir" method="post">
			<h2>Cadastramento de Alunos</h2>
		
			<div class="form-group">
				<label>Nome:</label>
				<input type="text" class="form-control" name="nome" value="Elberth L C Moraes"> 
			</div>
			
			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" class="form-control" name="email" value="elberth.moraes@prof.infnet.edu.br">
			</div>
			
			<div class="form-group">
				<label>Idade:</label>
				<input type="text" class="form-control" name="idade" value="43"> 
			</div>

			<div class="form-group">
				<label>Mensalidade:</label>
				<input type="text" class="form-control" name="mensalidade" value="1000"> 
			</div>

			<div class="form-group">
				<label>Curso:</label>
				
				<div class="radio">
				  <label><input type="radio" name="curso" value="G"> Gradua��o</label>
				</div>				
				<div class="radio">
				  <label><input type="radio" name="curso" value="E"> Especializa��o</label>
				</div>				
				<div class="radio">
				  <label><input type="radio" name="curso" value="M" checked> Mestrado</label>
				</div>				
				<div class="radio">
				  <label><input type="radio" name="curso" value="D"> Doutorado</label>
				</div>				
			</div>
			
			<div class="form-group">
				<label>Disciplinas:</label>
				
				<div class="checkbox">
				  <label><input type="checkbox" name="disciplinas" value="fun" checked> Fundamentos Java</label>
				</div>				
				<div class="checkbox">
				  <label><input type="checkbox" name="disciplinas" value="poo" checked> Orienta��o a Objetos</label>
				</div>				
				<div class="checkbox">
				  <label><input type="checkbox" name="disciplinas" value="web" checked> Java Web</label>
				</div>				
			</div>
			
			<div class="form-group">
				<label>Regi�o:</label>
				<select name="regiao" class="form-control">
					<option value="S">Sul</option>
					<option value="Su" selected>Sudeste</option>
					<option value="C">Centro-Oeste</option>
					<option value="N">Norte</option>
					<option value="No">Nordeste</option>
				</select>
			</div>

			<button type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>