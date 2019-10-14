CREATE DATABASE  IF NOT EXISTS `helpcenter` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `helpcenter`;
-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: helpcenter
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `helpcabno`
--

DROP TABLE IF EXISTS `helpcabno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helpcabno` (
  `n_idcabno` int(11) NOT NULL AUTO_INCREMENT,
  `d_dathcabno` datetime DEFAULT NULL,
  `n_quancabno` int(11) DEFAULT NULL,
  `n_idclien` int(11) DEFAULT NULL,
  `n_totacabno` decimal(10,2) DEFAULT NULL,
  `c_eoscabno` char(1) DEFAULT NULL,
  PRIMARY KEY (`n_idcabno`),
  KEY `fk_helpcabno_helpclien_idx` (`n_idclien`),
  CONSTRAINT `fk_helpcabno_helpclien` FOREIGN KEY (`n_idclien`) REFERENCES `helpclien` (`n_idclien`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helpcabno`
--

LOCK TABLES `helpcabno` WRITE;
/*!40000 ALTER TABLE `helpcabno` DISABLE KEYS */;
INSERT INTO `helpcabno` VALUES (6,'2017-09-18 17:08:08',3,6,420.00,'N'),(9,'2017-09-21 18:00:03',5,3,743.80,'N'),(10,'2017-09-29 10:29:46',3,6,240.00,'N'),(11,'2017-09-29 10:49:36',2,10,254.60,'N'),(12,'2017-09-29 11:01:24',1,10,20.00,'N'),(20,'2017-10-11 19:26:34',2,1,80.00,'S'),(21,'2017-10-11 20:00:00',2,7,84.00,'S'),(23,'2017-10-24 17:29:14',2,10,2420.00,'N'),(24,'2017-11-17 11:15:56',2,7,160.00,'S'),(25,'2017-11-17 11:29:39',2,1,2420.00,'N'),(31,'2018-01-06 14:21:35',1,12,33.00,'S');
/*!40000 ALTER TABLE `helpcabno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `helpclien`
--

DROP TABLE IF EXISTS `helpclien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helpclien` (
  `n_idclien` int(11) NOT NULL AUTO_INCREMENT,
  `c_nomeclien` varchar(100) DEFAULT NULL,
  `c_fpriclien` varchar(20) NOT NULL DEFAULT '',
  `c_fsegclien` varchar(20) NOT NULL DEFAULT '',
  `c_emaiclien` varchar(100) DEFAULT NULL,
  `c_endeclien` varchar(150) DEFAULT NULL,
  `c_cpfclien` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`n_idclien`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helpclien`
--

LOCK TABLES `helpclien` WRITE;
/*!40000 ALTER TABLE `helpclien` DISABLE KEYS */;
INSERT INTO `helpclien` VALUES (1,'Ricardo Balboa','(51) 9921-1222','(41) 2222-3333','ricb@yahoo.com','Rua Da Praça, 412',''),(3,'Mauro Borges','(51) 9892-3322','(51) 3732-8722','maurob@hotmail.com','Rua Cambaí, 231',''),(4,'Mauro Rodrigues','(51) 9892-3322','(51) 9992-3322','mauror@hotmail.com','Rua Osório, 231',''),(6,'Lauro Loyola','(31) 2211-4422','','lloyola@hotmail.com','Rua Fernando de Noronha, 412',''),(7,'Yan Bruno','(52) 98721-4533','(54) 3789-2211','yanb@bol.com','Rua do Ipiranga, 456',''),(8,'Yan Melo','(11) 99721-4533','','yanb@bol.com','Rua do Ipiranga, 456',''),(10,'Jonata Hermes','(22) 99425-1244','','jhermes@hotmail.com','Rua Ibitinga, 341',''),(11,'Rodolfo Limberger','(11) 98221-5922','','rodolfol@hotmail.com','Rua Andrada, 2130',''),(12,'Tobias Bezerro','(41) 98734-1245','','tobiasb@outlook.com','Rua Boiada, 534',''),(14,'Marcos Espindola','(51) 99721-5622','(51) 3715-3412','marcosespindola@gmail.com','Rua da Independência, 512',''),(15,'Henrique Bastos','(51) 98822-4435','','henriqueb@hotmail.com','Rua das Bandeiras, 453',''),(16,'Pedro Manso','(51) 98722-1345','','pedrom@gmail.com','Rua Barcelona, 456',''),(17,'Joares Sheneider','(51) 98122-4512','','jos@jometalurgica.com','Rua Campestre, 231','022.344.222-34'),(18,'Fulano Teste','(51) 22222-2222','','','','222.222.222-22'),(19,'Fulano Teste 2','(51) 22222-2222','(41) 2222-2222','fulteste@fulteste.com','Rua Beltranas','222.333.444-55'),(20,'Fulano Teste 3','(51) 22222-2222','','fulteste2@fulteste.com','Rua Beltranas 2',''),(21,'Alexandre Konzen','(51) 99845-1233','','','Rua Marcílio Dias',''),(22,'Alex Rodrigues','(51) 99727-3145','(51) 3731-1190','','Rua Almirante Abreu',''),(23,'teste','(22) 22222-2222','','','teste','');
/*!40000 ALTER TABLE `helpclien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `helpiteno`
--

DROP TABLE IF EXISTS `helpiteno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helpiteno` (
  `n_iditeno` int(11) NOT NULL AUTO_INCREMENT,
  `n_quaniteno` varchar(45) DEFAULT NULL,
  `n_preciteno` decimal(10,2) DEFAULT NULL,
  `n_idcabno` int(11) NOT NULL,
  `n_idprodu` int(11) NOT NULL,
  PRIMARY KEY (`n_iditeno`),
  KEY `fk_helpitno_helpcabno_idx` (`n_idcabno`),
  KEY `fk_helpiteno_helpprodu_idx` (`n_idprodu`),
  CONSTRAINT `fk_helpiteno_helpcabno` FOREIGN KEY (`n_idcabno`) REFERENCES `helpcabno` (`n_idcabno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_helpiteno_helpprodu` FOREIGN KEY (`n_idprodu`) REFERENCES `helpprodu` (`n_idprodu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helpiteno`
--

LOCK TABLES `helpiteno` WRITE;
/*!40000 ALTER TABLE `helpiteno` DISABLE KEYS */;
INSERT INTO `helpiteno` VALUES (1,'1',20.00,6,9),(2,'2',200.00,6,7),(5,'2',20.00,9,9),(6,'3',234.60,9,1),(7,'2',20.00,10,9),(8,'1',200.00,10,7),(9,'1',20.00,11,9),(10,'1',234.60,11,1),(11,'1',20.00,12,9),(14,'1',20.00,23,9),(15,'1',2400.00,23,8),(16,'1',20.00,25,9),(17,'1',2400.00,25,8);
/*!40000 ALTER TABLE `helpiteno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `helpmovi`
--

DROP TABLE IF EXISTS `helpmovi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helpmovi` (
  `n_idmovim` int(11) NOT NULL AUTO_INCREMENT,
  `c_catemovim` varchar(45) DEFAULT NULL,
  `c_descmovim` varchar(45) DEFAULT NULL,
  `n_valomovim` decimal(10,2) DEFAULT NULL,
  `d_dathmovim` datetime DEFAULT NULL,
  `c_tipomovim` char(1) DEFAULT NULL,
  `n_idcabno` int(11) DEFAULT NULL,
  `n_numeos` int(11) DEFAULT NULL,
  `c_ntosmovim` char(1) DEFAULT NULL,
  PRIMARY KEY (`n_idmovim`),
  KEY `fk_helpmovi_helpcabno_idx` (`n_idcabno`),
  KEY `fk_helpmovi_helpos_idx` (`n_numeos`),
  CONSTRAINT `fk_helpmovi_helpcabno` FOREIGN KEY (`n_idcabno`) REFERENCES `helpcabno` (`n_idcabno`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_helpmovi_helpos` FOREIGN KEY (`n_numeos`) REFERENCES `helpos` (`n_numeos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helpmovi`
--

LOCK TABLES `helpmovi` WRITE;
/*!40000 ALTER TABLE `helpmovi` DISABLE KEYS */;
INSERT INTO `helpmovi` VALUES (6,'VENDA DE MERCADORIA','VENDA DE MERCADORIA',420.00,'2017-09-18 17:08:08','E',6,NULL,'N'),(7,'VENDA DE MERCADORIA','VENDA DE MERCADORIA',743.80,'2017-09-21 18:00:03','E',9,NULL,'N'),(8,'VENDA DE MERCADORIA','VENDA DE MERCADORIA',240.00,'2017-09-29 10:29:46','E',10,NULL,'N'),(9,'VENDA DE MERCADORIA','VENDA DE MERCADORIA',254.60,'2017-09-29 10:49:36','E',11,NULL,'N'),(10,'VENDA DE MERCADORIA','VENDA DE MERCADORIA',20.00,'2017-09-29 11:01:24','E',12,NULL,'N'),(16,'OS','Placa mãe',50.00,'2017-10-11 20:00:00','E',21,8,'S'),(17,'OS','PC Gamer',34.00,'2017-10-11 20:00:00','E',21,9,'S'),(20,'VENDA DE MERCADORIA','VENDA DE MERCADORIA',2420.00,'2017-10-24 17:29:14','E',23,NULL,'N'),(21,'Recarga','Operadora Vivo',13.00,'2017-11-16 19:08:08','E',NULL,NULL,'N'),(22,'Xerox','1 Folha',0.50,'2017-11-16 19:12:17','E',NULL,NULL,'N'),(23,'Pagamentos','Conta de luz',80.00,'2017-11-16 19:42:23','S',NULL,NULL,'N'),(24,'OS','Celular',100.00,'2017-11-17 11:15:56','E',24,2,'S'),(25,'OS','CDJ Pioneer',60.00,'2017-11-17 11:15:56','E',24,5,'S'),(26,'VENDA DE MERCADORIA','VENDA DE MERCADORIA',2420.00,'2017-11-17 11:29:39','E',25,NULL,'N'),(27,'Pagamentos','Conta de água',34.00,'2017-12-01 11:31:59','S',NULL,NULL,'N'),(28,'Pagamentos','Conta de luz',40.00,'2017-12-01 11:34:04','S',NULL,NULL,'N'),(29,'Chip','2 Chips Vivos',20.00,'2017-12-01 11:34:29','E',NULL,NULL,'N'),(30,'Pagamentos','Internet',60.00,'2017-12-01 00:00:00','S',NULL,NULL,'N'),(34,'OS','s',33.00,'2018-01-06 14:21:35','E',31,12,'S');
/*!40000 ALTER TABLE `helpmovi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `helpos`
--

DROP TABLE IF EXISTS `helpos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helpos` (
  `n_numeos` int(11) NOT NULL AUTO_INCREMENT,
  `d_dathos` datetime DEFAULT NULL,
  `c_tipoos` enum('Orçamento','Ordem de serviço') DEFAULT NULL,
  `c_situos` varchar(50) DEFAULT NULL,
  `c_equios` varchar(100) DEFAULT NULL,
  `c_defeos` varchar(255) DEFAULT NULL,
  `c_servos` varchar(100) DEFAULT NULL,
  `n_valoros` decimal(10,2) DEFAULT '0.00',
  `n_idclien` int(11) NOT NULL,
  `n_idcabno` int(11) DEFAULT NULL,
  `c_temntos` char(1) DEFAULT NULL,
  PRIMARY KEY (`n_numeos`),
  KEY `fk_helpos_helpclien_idx` (`n_idclien`),
  KEY `fk_helpos_helpcabno_idx` (`n_idcabno`),
  CONSTRAINT `fk_helpos_helpcabno` FOREIGN KEY (`n_idcabno`) REFERENCES `helpcabno` (`n_idcabno`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `fk_helpos_helpclien` FOREIGN KEY (`n_idclien`) REFERENCES `helpclien` (`n_idclien`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helpos`
--

LOCK TABLES `helpos` WRITE;
/*!40000 ALTER TABLE `helpos` DISABLE KEYS */;
INSERT INTO `helpos` VALUES (1,'2017-09-01 11:34:50','Orçamento','Na bancada','Notebook positivo','Placa Wifi com defeito','Efetuar troca',40.00,1,20,'S'),(2,'2017-09-02 13:42:00','Ordem de serviço','Orçamento APROVADO','Celular','Sensor não funciona','trocar tela',100.00,3,24,'S'),(5,'2017-09-12 16:34:00','Orçamento','Orçamento APROVADO','CDJ Pioneer','Leitor óptico não funciona','Troca de componente',60.00,7,24,'S'),(7,'2017-09-21 15:14:10','Ordem de serviço','Orçamento APROVADO','Smartphone Galaxy S1','Tela trincada','Troca de tela',40.00,1,20,'S'),(8,'2017-10-11 19:38:35','Ordem de serviço','Orçamento APROVADO','Placa mãe','Capacitor queimado','Troca',50.00,7,21,'S'),(9,'2017-10-11 19:43:30','Ordem de serviço','Orçamento APROVADO','PC Gamer','Luzes do gabinete não acendem','Troca',34.00,7,21,'S'),(12,'2018-01-06 12:23:16','Orçamento','Aguardando aprovação','s','s','s',33.00,14,31,'S'),(14,'2018-01-06 12:51:57','Ordem de serviço','Orçamento APROVADO','teste','teste','teste',22.34,12,NULL,'N'),(15,'2018-01-06 14:06:50','Orçamento','Orçamento APROVADO','Dell Vostro Desktop','Memória Empoeirada','Limpeza',34.55,1,NULL,'N');
/*!40000 ALTER TABLE `helpos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `helpprodu`
--

DROP TABLE IF EXISTS `helpprodu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helpprodu` (
  `n_idprodu` int(11) NOT NULL AUTO_INCREMENT,
  `c_eanprodu` varchar(45) DEFAULT NULL,
  `c_descprodu` varchar(100) DEFAULT NULL,
  `n_precprodu` decimal(10,2) DEFAULT NULL,
  `n_quanprodu` int(11) DEFAULT NULL,
  PRIMARY KEY (`n_idprodu`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helpprodu`
--

LOCK TABLES `helpprodu` WRITE;
/*!40000 ALTER TABLE `helpprodu` DISABLE KEYS */;
INSERT INTO `helpprodu` VALUES (1,'12123FASDFSDF','Carregador para notebook',234.60,12),(7,'123414AFADFASDF','Mouse sem fio bateria, Logitech',200.00,10),(8,'23456','Notebook Acer Gamer',2400.00,10),(9,'123','Pilhas recarregáveis',20.00,10),(10,'345612350','Controle T3 bluetooh',40.00,10);
/*!40000 ALTER TABLE `helpprodu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-13 21:18:54
