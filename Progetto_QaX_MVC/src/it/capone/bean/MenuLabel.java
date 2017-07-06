package it.capone.bean;

import java.util.ArrayList;
import java.util.List;

public class MenuLabel {

	List<MenuItem> menu = new ArrayList<MenuItem>();
	
	//Versione base
	public void loadMenu() {
		
		menu.add(new MenuItem("HomePage", "welcome.jsp") );
		menu.add(new MenuItem("Login", "viewLogin.jsp"));
		menu.add(new MenuItem("Logout", "welcome.jsp"));
		menu.add(new MenuItem("Registrazione", "viewRegistrazione.jsp"));
		
	}
	
	//Versione definitiva
	public void loadMenu(LoginBean user) {
		
		menu.add(new MenuItem("HomePage", "welcome.jsp") );
		//se l'utente non è loggato mostro il link di login, se è già dentro mostro il link di logout 
		if( !user.isLoggato() ) {
			menu.add(new MenuItem("Login", "viewLogin.jsp"));
			menu.add(new MenuItem("Registrazione", "viewRegistrazione.jsp"));
		}
		else
			menu.add(new MenuItem("Logout", "welcome.jsp"));
	}

	public List<MenuItem> getMenu() {
		return menu;
	}
	
	
	
}
