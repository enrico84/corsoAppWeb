<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="it.capone.bean.MenuItem" %>
<jsp:useBean id="labelMenu" class="it.capone.bean.MenuLabel" scope="request"/>

   <div class = "header">
      <h1>QaX vv. 1.0</h1>
          <ul>
          <%
			 labelMenu.loadMenu();
          	 for(MenuItem item : labelMenu.getMenu()) {
          		 out.print("<li><a href='"+item.getUrl()+"'>"+item.getLabel()+"</a></li>");
          	 }
          %>
             <!--   <li><a href="#">HomePage</a></li>
             	    <li><a href="viewLogin.jsp">Login</a></li>
             -->
           </ul>
   </div>