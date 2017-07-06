<!--  
	CONTROLLER 
	1) Controlla se esiste un dato utente nel db, se OK va verso la HomePage 
	2) Crea un nuovo utente nel database, se OK va verso la HomePage 
-->
<%@page import="javafx.beans.property.SetProperty"%>
<%@page import="it.capone.dao.UtenteDAO" %>
<jsp:useBean id="loginBean" 
		     class="it.capone.bean.LoginBean" 
		     scope="session" />
<jsp:useBean id="errBean" 
		     class="it.capone.utility.ErrMsg" 
		     scope="request" />	
		     	     
<% 
	String nome = request.getParameter("nome");
	String password = request.getParameter("password");
	
	UtenteDAO utenteDAO = new UtenteDAO();
	boolean exist = utenteDAO.verifyUtente(nome, password);
	//login.setNome(nome);
	//login.setPassword(password);
	if(exist) 
	{
%>
		<jsp:setProperty name="loginBean" property="nome" />
		<jsp:setProperty name="loginBean" property="password" />
		<jsp:forward page="doListaDomande.jsp" />
<%  }else { 
		errBean.add(loginBean.getErrorMsg());
%>
		<jsp:forward page="viewLogin.jsp" />
<%  } %>		


<% 
	//if(loginBean.isValidLogin()) {
%>
<% //} else { 
	//	 for (String err : loginBean.getErrs().getErrori())	
		// 	errBean.add(err);
%>		
<% //} %>
