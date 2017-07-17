<%@page import="it.capone.bean.ListaDomandeBean"%><%@page import="it.capone.bean.DomandaBean"%><%@
page import="it.capone.dao.DomandaDAO"%><%@page import="it.capone.utility.Data"%><%@
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><jsp:useBean 
id="listaDomande" class="it.capone.bean.ListaDomandeBean" scope="request"/><%
    
String catDomanda = request.getParameter("categoriaDomanda");
    
if(catDomanda != null && !catDomanda.equals("")) {
    //creo un oggetto dao che interagisce con il db
    DomandaDAO domandaDAO = new DomandaDAO();
       
    //l'oggetto dao interrogherà il db e popolerà il bean "listadomande" con il risultato della query
    domandaDAO.getDomande(listaDomande, catDomanda);
    
    if(!listaDomande.getListaDomande().isEmpty()) {
    
	    out.println("<table>");
	    for(DomandaBean d : listaDomande.getListaDomande()) {
	   		String titolo = d.getTitolo();
	   		String descrizione = d.getDescrizione();
	   		if(descrizione.length() > 100)
					descrizione = descrizione.substring(0, 99);
	   		String utente = d.getUtente().getNome();
	   		Data datacreazione = d.getDatacreazione();
	   		//out.println(titolo  +", " +descrizione+", " +utente+ ", " +datacreazione);
	   		
	   		out.println("<tr>");
	   		out.println("<td>Domanda:</td>");
	   		out.println("<td><a href='doVisualizzaDomanda.jsp?iddomanda=" +d.getIddomanda()+ "'>"+titolo+"</a></td>");
	   		out.println("</tr><tr>");
	   		out.println("<td>Descrizione:</td><td>"+descrizione+"</td>");
	   		out.println("</tr><tr>");
	   		out.println("<td>Utente:</td><td>"+utente+"</td>");
	   		out.println("</tr><tr>");
	   		out.println("<td>Data:</td><td>"+datacreazione+"</td>");
	   		out.println("</tr><tr>");
	   		out.println("<td colspan=2><hr class='generic'></td>");
	   		out.println("</tr>");
	    }
	    out.println("</table>");
    
     } else {
     	out.println("Nessun post correlato alla domanda");
     }
    
   
}
%>