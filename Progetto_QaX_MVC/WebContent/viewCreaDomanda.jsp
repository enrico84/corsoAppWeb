<jsp:include page="doVerificaUtente.jsp" flush="false"/>
<jsp:useBean id="errBean" class="it.capone.utility.ErrMsg" scope="request"/>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Inserimento domanda</title>
	<link type="text/css" rel="stylesheet" href="css/sito.css"/>
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/selezionaCategoria.js"></script>
	<script type="text/javascript" src="js/verifyDomanda.js"></script>
	<script type="text/javascript" src="js/popolaCategoria.js"></script>
</head>
<body>
	 <jsp:include page="fragment/header.jsp" flush="true"/>
	 <div class="clearfix">    
            <div class = "column content">
            <h1>Inserimento domanda</h1>
            	<% 
            		if(errBean.isListErr()) {
            	%>	
            		<p><%
            			for(String err: errBean.getErrori()) 
            				out.println("<p>"+err+"</p>");
            			%>
            	<% 	
            		}
            	%>
            <form name="domandaForm" method="post" action="doCreaDomanda.jsp">
            		<table>
            		<tr><td>Titolo:</td><td><input type="text" name="titolo"/></td></tr>      
            		<tr><td>Descrizione:</td><td><input type="text" name="descrizione"/></td></tr>
            		<tr><td>Categoria:</td>
            			<td>
            				<select name="selectCategoria"><option value="">Scegli la categoria</option>
            			    </select>
            			</td>
            		</tr>
            		<tr><td>Non c'è la categoria? Aggiungila:</td><td><input type="text" name="categ" /></td></tr>
            		
            		<tr><td><input type="submit" value="Inserisci domanda"/></td><td><input type="reset" value="Resetta i campi"/></td></tr>
            		</table>
            		<!--  <p id="registrationErr"></p> -->
            		<p id="domandaErr"></p>
            	</form>
            </div> 
     </div>       
      <jsp:include page="fragment/footer.jsp" flush="true"/>
</body>
</html>