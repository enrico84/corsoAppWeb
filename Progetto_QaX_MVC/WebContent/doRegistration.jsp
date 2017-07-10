<!-- 
	CONTROLLER 
	registra un nuovo utente nel sito 
	prende le credenziali inviate in "viewRegistration" e la passa allo strato dao "UtenteDAO"
	UtenteDAO farà una query di inserimento 
 -->
<%@page import="it.capone.utility.Data"%>
<%@page import="it.capone.dao.UtenteDAO"%>
<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session"/>
<% 
	UtenteDAO utenteDAO = new UtenteDAO();

	String nome = request.getParameter("nome");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	
	utenteDAO.registraUtente(loginBean, nome, password, email);
	
	
	response.sendRedirect("doListaDomande.jsp");
%>