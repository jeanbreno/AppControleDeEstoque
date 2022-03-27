<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8" />
		<title>AppEstoque</title>
		<!-- link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"-->
		
		<!-- link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"-->
		<link href="css/bootstrap-css.css" rel="stylesheet" />
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
	 
		<div class="wrapper fadeInDown">
		  <div id="formContent">
		    <!-- Tabs Titles -->
			<label>ERP - Estoque</label>
		    <!-- Icon -->
		    <div class="fadeIn first">
		      	<img src="assets/img/estoque-login.png" id="icon" alt="User Icon" />
		    </div>

	   		<c:if test="${not empty mensagem}">
				<div class="alert warning">
				  	<span class="closebtn">&times;</span>  
				  	<strong>Atenção!</strong> ${mensagem}
				</div>
			</c:if>
	 	
		    <!-- Login Form -->
		    <form action="/login" method="post">
		      <input type="email" id="login" class="fadeIn second" name="email" placeholder="login" value="jota@gmail.com">
		      <input type="password" id="password" class="fadeIn third" name="senha" placeholder="password" value="jota@gmail.com">
		      <input type="submit" class="fadeIn fourth" value="Entrar">
		    </form>
		
		  </div>
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