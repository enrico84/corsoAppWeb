package it.capone.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.capone.bean.LoginBean;
import it.capone.dao.UtenteDAO;
import it.capone.service.CGestioneDomande;
import it.capone.service.CGestioneUtente;

/**
 * Servlet implementation class ControllerUtente
 * CONTROLLER - SERVLET 
 * Serve a modificare i dati di un Utente nel Database
 * Redirige la navigazione verso una determinata VIEW in base al parametro "request.getParameter("scelta")"
 */
@WebServlet(name="ControllerUtente", urlPatterns="/ControllerUtente")
public class ControllerUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
	        if(request.getParameter("scelta") != null)
	        {
	        	CGestioneDomande cGestDom = (CGestioneDomande)request.getSession().getAttribute("cGestDom");
	            if(cGestDom == null) {
	            	cGestDom = new CGestioneDomande();
	                request.getSession().setAttribute("cGestDom", cGestDom);
	            }
	        	if(request.getParameter("scelta").equals("visualizza")) {
	      
	        		String utente = request.getParameter("utente");
		        	Integer idUtente = Integer.parseInt(utente);
		        	
		        	//Prendo l'utente dal Database tremite l'id passatomi dalla View "side.jsp"
		        	
		        	//LoginBean utenteBean = it.capone.dao.DomandaDAO.prendiUtente(idUtente);
		            LoginBean utenteBean = cGestDom.prendiUtente(idUtente);
		            
	        	   //L'utente recuperato lo setto come variabile di sessione e me lo porto avanti 
	        	   //recuperandolo successivamente
	        	   request.getSession().setAttribute("utenteBean", utenteBean);
	        	   
	               RequestDispatcher rd = request.getRequestDispatcher("viewModificaUtente.jsp");
	               if(rd != null){
	            	   rd.forward(request, response);
	               }
	               else
	               {
	                 System.out.println("Problema nel forward verso la View viewModificaUtente ");
	               } 
	        	}
	        	else if(request.getParameter("scelta").equals("modifica")) {
	        		   boolean modificato = false;
	        		   String utente = request.getParameter("utente");
			           Integer idUtente = Integer.parseInt(utente);
			           
			           //Prendo l'utente dal Database dato l'id passatomi dalla View "viewModificaUtente.jsp"
			           
			           //LoginBean utenteBean = it.capone.dao.DomandaDAO.prendiUtente(idUtente);
			           LoginBean utenteBean = cGestDom.prendiUtente(idUtente);
	        		   
			           String password = request.getParameter("password");
	        		   String email = request.getParameter("email");
		        	   
		        	   modificato = modificaUtente(request, idUtente, password, email);
		        	   
		        	   if(modificato) {
		        		   
		        		   utenteBean.setPassword(password);
		        		   utenteBean.setEmail(email);
		        		   
		        		   //L'utente recuperato lo setto come variabile di sessione e me lo porto avanti 
			        	   //recuperandolo successivamente
			        	   request.getSession().setAttribute("utenteBean", utenteBean);
			        	   
		        		   RequestDispatcher rd = request.getRequestDispatcher("doLogin.jsp");
			               if(rd != null){
			            	   rd.forward(request, response);
			               }
			               else
			               {
			                 System.out.println("Problema nel forward verso la View viewModificaUtente ");
			               } 
		        	   }
		        	   else{
		        		   System.out.println("Utente non modificato");
		        		   response.sendRedirect("viewModificaUtente.jsp");
		        	   }
		        		   
		        	   
	        	}
	        		
	        }
        }catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }
	
	
	
	private boolean modificaUtente(HttpServletRequest request, int idUtente, String password, String email) {
		
		CGestioneUtente cGestUt = (CGestioneUtente)request.getSession().getAttribute("cGestUt");
        if(cGestUt == null) {
        	cGestUt = new CGestioneUtente();
            request.getSession().setAttribute("cGestUt", cGestUt);
        }
		
		//boolean modificato = UtenteDAO.aggiornaUtente(idUtente, password, email);
        boolean modificato = cGestUt.aggiornaUtente(idUtente, password, email);
		return modificato;
	}
		
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
