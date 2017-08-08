<!-- 
	CONTROLLER 
	Registra un nuovo utente nel sito 
	prendendo le credenziali inviate in "viewRegistrazione" e passandole allo strato dao "UtenteDAO"
	UtenteDAO farà una query di inserimento 
	
	Controlli integrità lato client: se uno o più campi sono vuoti o invalidi, ritorna 
	alla "viewRegistrazione" con un messaggio di errore
 --><%@page 
 import="it.capone.utility.Data"%><%@page 
 import="it.capone.service.CGestioneUtente" %><%@page 
 import="it.capone.dao.UtenteDAO"%><jsp:useBean
  id="loginBean" class="it.capone.bean.LoginBean" scope="session"/><jsp:useBean 
  id="errBean" class="it.capone.utility.ErrMsg" scope="request" />	<%
  
	UtenteDAO utenteDAO = new UtenteDAO();
    CGestioneUtente cGestUt = (CGestioneUtente)request.getSession().getAttribute("cGestUt");
    if(cGestUt == null) {
  	  cGestUt = new CGestioneUtente();
      request.getSession().setAttribute("cGestUt", cGestUt);
    }

	String nome = request.getParameter("nome");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	
	if( (nome != null && !nome.equals("")) && 
		(password != null && !password.equals("")) && 
		(email != null && !email.equals("")) ) {         //OK
		
		//utenteDAO.registraUtente(loginBean, nome, password, email);
		cGestUt.registraUtente(loginBean, nome, password, email);
%>
		<jsp:setProperty name="loginBean" property="nome" />
		<jsp:setProperty name="loginBean" property="password" />
		<jsp:setProperty name="loginBean" property="email" />
<%
		response.sendRedirect("doListaDomande.jsp");
		
	}
	else {
		errBean.add(loginBean.getErrorRegMsg());        //ERRORI
%>
		<jsp:forward page="viewRegistrazione.jsp"/>

<% 		
	}
%>