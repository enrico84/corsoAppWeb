<%@ page import="it.capone.service.CGestioneCategoria; import java.util.Map;"%><%@ 
    page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><% 
	
    CGestioneCategoria cGestCat = (CGestioneCategoria)request.getSession().getAttribute("cGestCat");
    if(cGestCat == null) {
    	cGestCat = new CGestioneCategoria();
        request.getSession().setAttribute("cGestCat", cGestCat);
    }
 
    
   Map<Integer, String> categorie = null;
   categorie = cGestCat.getCategorie();
   
   if(!categorie.isEmpty()) {
	   
	   for (Map.Entry<Integer, String> cat : categorie.entrySet()) {
	   		out.println( "<option value='"+cat.getValue()+"'> " +cat.getValue()+ "</option>" );
	   }
	   out.println( "<option value=''>Seleziona una categoria </option>" );
   }
   
   
%>