<!-- Estrapolo i dati inseriti nel Bean "DomandaBean" per popolare la pagina con le info sulla domanda -->
<%@page import="it.capone.bean.RispostaBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="it.capone.utility.Data" %>
<jsp:useBean id="domanda" 
		     class="it.capone.bean.DomandaBean" 
			 scope="request">
</jsp:useBean> 
<html>
    <head>
        <title>Home page</title>
        <link rel="stylesheet" href="css/sito.css">
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" flush="true"/>
        
        <div class="clearfix">    
            <div class = "column content">
            	
           	    		<h1>Domanda</h1>
           	    		<p>
           	    		<table>
           	    		<%	
	            			String titolo = domanda.getTitolo();
           	    			String descrizione = domanda.getDescrizione();
           	    			Data data = domanda.getDatacreazione();
           	    			String utente = domanda.getUtente().getNome();            		
            			%>
            				<tr><td><h3>Titolo</h3> :</td><td><%=titolo %></td></tr>
            				<tr><td><h3>Descrizione</h3> :</td><td><%=descrizione %></td></tr>
            				<tr><td><h3>Utente</h3> :</td><td><%=utente %></td></tr>
            				<tr><td><h3>Data creazione</h3> :</td><td><%=data %></td></tr>
            				<tr><td colspan="2"></td></tr>
            			</table>
            			<p>
            			
            			<% 
            				if(!domanda.getRisposte().isEmpty()) {
            			%> 
            				<table>
            				<%		
            					for(RispostaBean r : domanda.getRisposte()) {
            						String descr = r.getDescrizione();
            						Data dataRisp = r.getDataCreazione();
            						String utenteRisp = r.getUtente().getNome();
            				%>
            					   <tr><td><h3>Descrizione</h3> :</td><td><%=descr %></td></tr>
            					   <tr><td><h3>Utente</h3> :</td><td><%=utenteRisp %></td></tr>
            					   <tr><td><h3>Data risposta</h3> :</td><td><%=dataRisp %></td></tr>
            				<% 
            					}
            				%>	   
            				</table>
            			<% } else { %>
            				<h3>Nessuna risposta data alla domanda</h3>
            			<% } %>
            			
            </div>
            <jsp:include page="fragment/side.jsp" flush="true"/>
        </div>
        
        <jsp:include page="fragment/footer.jsp" flush="true"/>
    </body>    
</html>