<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="it.capone.bean.DomandaBean"%>
<%@page import="it.capone.utility.Data"%>
<!-- 
	Estrapolo i dati inseriti nel Bean "listaDomande" per popolare 
	la pagina con la lista delle prime 10 domande 
-->
<jsp:useBean id="listaDomande" class="it.capone.bean.ListaDomandeBean"
	scope="request" />
<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean"
	scope="session" />
<html>
<head>
<title>Home page</title>
<link type="text/css" rel="stylesheet" href="css/sito.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/selezionaCategoria.js"></script>
<script type="text/javascript" src="js/ricercaDomande.js"></script>
</head>
<body>
	<jsp:include page="fragment/header.jsp" flush="true" />

	<div class="clearfix">
		<div class="column content">

			<% 
            		if(!listaDomande.getListaDomande().isEmpty()) {
           	    %>
			<h1>Ultimi 10 post</h1>
			<div>
				<form action="#" method="GET" name="formAutoCompl">
					<p>
						<label>Categoria: <input type="text" name="categoria"></label>
						<span id="completaCat"></span>
					</p>
					<p>
						<label><input type="submit" value="Cerca"></label>
					</p>
					<span id="completaDom"></span>
					
					
				</form>
			</div>
			<table id="tableDefault">
				<%
           	    			
	            			for(DomandaBean d : listaDomande.getListaDomande()) {
	            		   		String titolo = d.getTitolo();
	            		   		String descrizione = d.getDescrizione();
	            		   		if(descrizione.length() > 100)
										descrizione = descrizione.substring(0, 99);
	            		   		String utente = d.getUtente().getNome();
	            		   		Data datacreazione = d.getDatacreazione();
	            		   		String categoria = d.getCategoria().getNome();
                 %>

				<tr>
					<td>Domanda:</td>
					<td><a
						href="doVisualizzaDomanda.jsp?iddomanda=<%=d.getIddomanda()%>">
							<%=titolo %>
					</a></td>
				</tr>
				<tr>
					<td>Descrizione:</td>
					<td><%=descrizione%></td>
				</tr>
				<tr>
					<td>Utente:</td>
					<td><%=utente %></td>
				</tr>
				<tr>
					<td>Data:</td>
					<td><%=datacreazione %></td>
				</tr>
				<tr>
					<td>Categoria:</td>
					<td><span class="cat"><%=categoria %></span></td>
				</tr>
				<tr>
					<td colspan=2><hr class="generic"></td>
				</tr>
				<%	
            	    		}
	            	
            	%>
			</table>
			<%
            	   }else {
            	%>
			<h1>Nessun post ancora posto</h1>
			<% } %>
		</div>
		<jsp:include page="fragment/side.jsp" flush="true" />
	</div>

	<jsp:include page="fragment/footer.jsp" flush="true" />
</body>
</html>