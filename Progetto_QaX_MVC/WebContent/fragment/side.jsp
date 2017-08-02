<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session" />
<div class = "column side">
<% 
		if(loginBean.isValidLogin()) {
			out.println("<h4>Benvenuto "+loginBean.getNome()+"</h4>");
			out.println("<a href='ControllerUtente?scelta=visualizza&utente="+loginBean.getIdutente()+ "'>Modifica i dati</a>");
		}
		else{
			out.println("<h4>Benvenuto Utente Anonimo</h4>");
		}
%>
</div>