<%@ page import="it.capone.dao.CategoriaDAO; import java.util.Map;"%><%@ 
    page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><% 
	
   CategoriaDAO categoriaDAO = new CategoriaDAO();
   Map<Integer, String> categorie = null;
   categorie = categoriaDAO.getCategorie();
   
   if(!categorie.isEmpty()) {
	   
	   for (Map.Entry<Integer, String> cat : categorie.entrySet()) {
	   		out.println( "<option value='"+cat.getKey()+"'> " +cat.getValue()+ "</option>" );
	   }
	   out.println( "<option value=''>Seleziona una categoria </option>" );
   }
   
   
%>