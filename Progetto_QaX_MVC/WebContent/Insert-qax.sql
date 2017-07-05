-- Insert database qax

-- INSERT  TAB. UTENTE
INSERT INTO qax.utente(password,nome,email,dataregistrazione) VALUES 
                                  ('root', 'gianni', 'giannig@tiscali.it', now());
INSERT INTO qax.utente(password,nome,email,dataregistrazione) VALUES 
                                  ('bayern', 'dario', 'dariop@gmail.com', now());
INSERT INTO qax.utente(password,nome,email,dataregistrazione) VALUES 
                                  ('juve', 'enrico', 'enricoc@gmail.com', now());
                                  

-- INSERTI TAB. DOMANDA	
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 1", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        1, 1, now(), null);
	        
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 2", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        1, 1, now(), null);
              
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 3", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        1, 1, now(), null);              
                
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 4", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        4, 1, now(), null);
 
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 5", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        1, 1, now(), null);

INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 6", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        2, 1, now(), null);
              
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 7", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        3, 1, now(), null);              
                
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 4", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        4, 1, now(), null);  
               
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 8", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        4, 1, now(), null);

INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 9", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        5, 1, now(), null);
              
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 3", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        5, 1, now(), null);              
                
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 10", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        5, 1, now(), null);  
                
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 11", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        6, 1, now(), null);

INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 12", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        3, 1, now(), null);
              
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 13", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        6, 1, now(), null);              
                
INSERT INTO qax.domanda(titolo, descrizione, categoria, idutente, datacreazione, idrispostascelta) 
	    VALUES("Domanda numero 14", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et 
                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, 
                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", 
		        7, 1, now(), null);  
		        

-- INSERT TAB. RISPOSTA
INSERT INTO qax.risposta(descrizione, idutente, datacreazione, iddomanda) 
	    VALUES("Risp di Dario alla domanda 1, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla", 
		        2, now(), 1);
                
INSERT INTO qax.risposta(descrizione, idutente, datacreazione, iddomanda) 
	    VALUES("Risp di Enrico alla domanda 1, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla", 
		        3, now(), 1);                
                
INSERT INTO qax.risposta(descrizione, idutente, datacreazione, iddomanda) 
	    VALUES("Risp di Dario alla domanda 2, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla", 
		        2, now(), 2);
                
INSERT INTO qax.risposta(descrizione, idutente, datacreazione, iddomanda) 
	    VALUES("Risp di Enrico alla domanda 2, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla", 
		        3, now(), 2); 
              
		        
-- INSERT TAB. CATEGORIA
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (1,'Java');
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (2,'Javascript');
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (3,'HTML');
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (4,'CSS');
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (5,'JQuery');
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (6,'SQL');
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (7,'Database');
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (8,'Web');
INSERT INTO `categoria` (`idcategoria`,`nome`) VALUES (9,'JavaEE');

commit;                 