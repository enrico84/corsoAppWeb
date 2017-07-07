<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="it.capone.bean.DomandaBean" %>
<%@page import="it.capone.utility.Data" %>
<!-- 
	Estrapolo i dati inseriti nel Bean "listaDomande" per popolare 
	la pagina con la lista delle prime 10 domande 
-->
<jsp:useBean id="listaDomande" 
	class="it.capone.bean.ListaDomandeBean" 
	scope="request"/>
<jsp:useBean id="loginBean" 
	class="it.capone.bean.LoginBean" 
	scope="session" />
<html>
    <head>
        <title>Home page</title>
        <link rel="stylesheet" href="css/sito.css">
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" flush="true"/>
        
        <div class="clearfix">    
            <div class = "column content">
            	
            	<% 
            		if(!listaDomande.getListaDomande().isEmpty()) {
           	    %>
           	    		<h1>Ultimi 10 post di <%=loginBean.getNome() %></h1>
           	    		<table>
           	    <%
           	    			
	            			for(DomandaBean d : listaDomande.getListaDomande()) {
	            		   		String titolo = d.getTitolo();
	            		   		String descrizione = d.getDescrizione();
	            		   		if(descrizione.length() > 100)
										descrizione = descrizione.substring(0, 99);
	            		   		String utente = d.getUtente().getNome();
	            		   		Data datacreazione = d.getDatacreazione();
                 %>
                 				
	                 			<tr><td>Domanda: </td><td><a href="doVisualizzaDomanda.jsp?iddomanda=<%=d.getIddomanda()%>"> <%=titolo %> </a></td></tr>
	                 			<tr><td>Descrizione: </td><td><%=descrizione%></td></tr>
	                 			<tr><td>Utente: </td><td><%=utente %></td></tr>
	                 			<tr><td>Data: </td><td><%=datacreazione %></td></tr>
	                 			<tr><td colspan=2><hr class="generic"></td></tr>
                 <%	
            	    		}
	            	
            	%>
            			</table>
            	<%
            	   }else {
            	%>
            			<h1>L'utente <%=loginBean.getNome() %> non ha inserito nessun post</h1>
            	<% } %>		
            </div>
            <jsp:include page="fragment/side.jsp" flush="true"/>
        </div>
        
        <jsp:include page="fragment/footer.jsp" flush="true"/>
    </body>    
</html>