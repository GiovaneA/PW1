-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bancoprojeto
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bancoweb`
--

DROP TABLE IF EXISTS `bancoweb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bancoweb` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `telefone` bigint(20) DEFAULT NULL,
  `pessoaF` tinyint(4) DEFAULT NULL,
  `pessoaJ` tinyint(4) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `nomeMae` varchar(45) DEFAULT NULL,
  `nomePai` varchar(45) DEFAULT NULL,
  `nomeFantasia` varchar(45) DEFAULT NULL,
  `contaCC` tinyint(4) DEFAULT NULL,
  `contaP` tinyint(4) DEFAULT NULL,
  `numeroConta` varchar(45) DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `situacao` tinyint(4) NOT NULL,
  `seguro` tinyint(4) DEFAULT NULL,
  `numeroSeg` varchar(45) DEFAULT NULL,
  `valorSeg` double DEFAULT NULL,
  `situacaoSeg` tinyint(4) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bancoweb`
--

LOCK TABLES `bancoweb` WRITE;
/*!40000 ALTER TABLE `bancoweb` DISABLE KEYS */;
/*!40000 ALTER TABLE `bancoweb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-18 11:34:48
