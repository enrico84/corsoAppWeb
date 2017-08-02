<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session"/><%@ 
	page import="it.capone.bean.LoginBean" %><%@ 
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifica informazioni utente</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/modificaUtente.js"></script>
</head>
<body>
<%
	// Prendo l'Utente inviatomi dal "ControllerUtente"
	loginBean = (LoginBean) request.getSession().getAttribute("utenteBean");
	String email = loginBean.getEmail();
	
%>
	<h1> Modifica credenziali dell'utente ${loginBean.nome} </h1>
	
	<form action="ControllerUtente" method="POST" name="modForm">
		<p><label>Password: </label><input type="text" name="password" value="${loginBean.password }"></p>
		<p>
			<label>Email: </label><input type="text" name="email" value="<%= email %>">
			<input type="hidden" name="utente" value="${loginBean.idutente}">
			<input type="hidden" name="scelta" value="modifica">
		</p>
		<p><input type="submit" value="Modifica">  <input type="reset" value="Resetta i campi">
	</form>
	<span id="errForm"></span>
	
</body>
</html>