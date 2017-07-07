<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="it.capone.bean.MenuItem" %>
<jsp:useBean id="labelMenu" class="it.capone.bean.MenuLabel" scope="request"/>
<jsp:useBean id="loginBean" class="it.capone.bean.LoginBean" scope="session" />

   <div class = "header">
      <h1>QaX vv. 1.0</h1>
          <ul>
          <%
			 labelMenu.loadMenu(loginBean);
          	 for(MenuItem item : labelMenu.getMenu()) {
          		 out.print("<li><a href='"+item.getUrl()+"'>"+item.getLabel()+"</a></li>");
          	 }
          %>
           </ul>
   </div>