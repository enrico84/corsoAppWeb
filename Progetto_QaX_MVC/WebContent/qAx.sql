-- Dump Alternativo database QaX

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Java'),(2,'Javascript'),(3,'HTML'),(4,'CSS'),(5,'JQuery'),(6,'SQL'),(7,'Database'),(8,'Web'),(9,'JavaEE');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentodomanda`
--

DROP TABLE IF EXISTS `commentodomanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commentodomanda` (
  `idcommentodomanda` int(11) NOT NULL AUTO_INCREMENT,
  `iddomanda` int(11) NOT NULL,
  `idutente` int(11) DEFAULT NULL,
  `descrizione` text NOT NULL,
  `datacreazione` datetime NOT NULL,
  PRIMARY KEY (`idcommentodomanda`),
  KEY `fk_commentodomanda_utente1_idx` (`idutente`),
  KEY `fk_commentodomanda_domanda1_idx` (`iddomanda`),
  CONSTRAINT `fk_commentodomanda_domanda1` FOREIGN KEY (`iddomanda`) REFERENCES `domanda` (`iddomanda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_commentodomanda_utente1` FOREIGN KEY (`idutente`) REFERENCES `utente` (`idutente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentodomanda`
--

LOCK TABLES `commentodomanda` WRITE;
/*!40000 ALTER TABLE `commentodomanda` DISABLE KEYS */;
/*!40000 ALTER TABLE `commentodomanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentorisposta`
--

DROP TABLE IF EXISTS `commentorisposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commentorisposta` (
  `idcommentorisposta` int(11) NOT NULL AUTO_INCREMENT,
  `idrisposta` int(11) NOT NULL,
  `idutente` int(11) DEFAULT NULL,
  `descrizione` text NOT NULL,
  `datacreazione` datetime NOT NULL,
  PRIMARY KEY (`idcommentorisposta`),
  KEY `fk_commentorisposta_utente1_idx` (`idutente`),
  KEY `fk_commentorisposta_risposta1_idx` (`idrisposta`),
  CONSTRAINT `fk_commentorisposta_risposta1` FOREIGN KEY (`idrisposta`) REFERENCES `risposta` (`idrisposta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_commentorisposta_utente1` FOREIGN KEY (`idutente`) REFERENCES `utente` (`idutente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentorisposta`
--

LOCK TABLES `commentorisposta` WRITE;
/*!40000 ALTER TABLE `commentorisposta` DISABLE KEYS */;
/*!40000 ALTER TABLE `commentorisposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domanda`
--

DROP TABLE IF EXISTS `domanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domanda` (
  `iddomanda` int(11) NOT NULL AUTO_INCREMENT,
  `titolo` varchar(120) NOT NULL,
  `descrizione` text NOT NULL,
  `categoria` int(11) NOT NULL,
  `idutente` int(11) DEFAULT NULL,
  `datacreazione` datetime NOT NULL,
  `idrispostascelta` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddomanda`),
  KEY `fk_domanda_utente1_idx` (`idutente`),
  KEY `fk_domanda_risposta1_idx` (`idrispostascelta`),
  KEY `categoria_domanda_idx` (`categoria`),
  CONSTRAINT `categoria_domanda` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_domanda_risposta1` FOREIGN KEY (`idrispostascelta`) REFERENCES `risposta` (`idrisposta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_domanda_utente1` FOREIGN KEY (`idutente`) REFERENCES `utente` (`idutente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domanda`
--

LOCK TABLES `domanda` WRITE;
/*!40000 ALTER TABLE `domanda` DISABLE KEYS */;
INSERT INTO `domanda` VALUES (1,'Domanda numero 1','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',1,1,'2017-06-30 16:43:03',NULL),(2,'Domanda numero 2','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',1,1,'2017-06-30 16:43:03',NULL),(3,'Domanda numero 3','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',1,1,'2017-06-30 16:43:03',NULL),(4,'Domanda numero 4','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',4,1,'2017-06-30 16:43:03',NULL),(5,'Domanda numero 5','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',1,1,'2017-06-30 16:43:03',NULL),(6,'Domanda numero 6','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',2,1,'2017-06-30 16:43:03',NULL),(7,'Domanda numero 7','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',3,1,'2017-06-30 16:43:03',NULL),(8,'Domanda numero 4','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',4,1,'2017-06-30 16:43:03',NULL),(9,'Domanda numero 8','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',4,1,'2017-06-30 16:43:03',NULL),(10,'Domanda numero 9','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',5,1,'2017-06-30 16:43:04',NULL),(11,'Domanda numero 3','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',5,1,'2017-06-30 16:43:04',NULL),(12,'Domanda numero 10','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',5,1,'2017-06-30 16:43:04',NULL),(13,'Domanda numero 11','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',6,1,'2017-06-30 16:43:04',NULL),(14,'Domanda numero 12','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',3,1,'2017-06-30 16:43:04',NULL),(15,'Domanda numero 13','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',6,1,'2017-06-30 16:43:04',NULL),(16,'Domanda numero 14','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. \n				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et \n                magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, \n                pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.',7,1,'2017-06-30 16:43:04',NULL);
/*!40000 ALTER TABLE `domanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risposta`
--

DROP TABLE IF EXISTS `risposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `risposta` (
  `idrisposta` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` text NOT NULL,
  `idutente` int(11) DEFAULT NULL,
  `datacreazione` datetime NOT NULL,
  `iddomanda` int(11) NOT NULL,
  PRIMARY KEY (`idrisposta`),
  KEY `fk_risposta_utente1_idx` (`idutente`),
  KEY `fk_risposta_domanda1_idx` (`iddomanda`),
  CONSTRAINT `fk_risposta_utente1` FOREIGN KEY (`idutente`) REFERENCES `utente` (`idutente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_risposta_domanda1` FOREIGN KEY (`iddomanda`) REFERENCES `domanda` (`iddomanda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risposta`
--

LOCK TABLES `risposta` WRITE;
/*!40000 ALTER TABLE `risposta` DISABLE KEYS */;
INSERT INTO `risposta` VALUES (1,'Risp di Dario alla domanda 1, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla',2,'2017-07-03 15:21:49',1),(2,'Risp di Enrico alla domanda 1, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla',3,'2017-07-03 15:21:49',1),(3,'Risp di Dario alla domanda 2, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla',2,'2017-07-03 15:21:49',2),(4,'Risp di Enrico alla domanda 2, bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla',3,'2017-07-03 15:21:49',2);
/*!40000 ALTER TABLE `risposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `idutente` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL COMMENT 'nome "reale" dell''utente',
  `email` varchar(45) NOT NULL,
  `dataregistrazione` datetime NOT NULL,
  PRIMARY KEY (`idutente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'root','gianni','giannig@tiscali.it','2017-06-30 16:12:50'),(2,'bayern','dario','dariop@gmail.com','0000-00-00 00:00:00'),(3,'juve','enrico','enricoc@gmail.com','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-04 14:48:35
