-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gerenciador_db8
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `func_id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `estadoConta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`func_id`),
  CONSTRAINT `func_id` FOREIGN KEY (`func_id`) REFERENCES `funcionario` (`idFunc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (2,'camaleao@gmail.com','asd','ativo'),(3,'asd@gmail.com','1234','ativo');
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `idDepart` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomeDepart` varchar(255) NOT NULL,
  `descricaoDepart` mediumtext,
  `gerenteId` bigint(20) NOT NULL,
  `estado_depart` varchar(45) NOT NULL,
  PRIMARY KEY (`idDepart`),
  UNIQUE KEY `nomeDepart` (`nomeDepart`),
  KEY `gerente_id_idx` (`gerenteId`),
  CONSTRAINT `gerente_id` FOREIGN KEY (`gerenteId`) REFERENCES `funcionario` (`idFunc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (3,'Informatica','Manutenção',2,'ativo'),(4,'Novo','teste',3,'ativo');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `func_id` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`func_id`),
  CONSTRAINT `endereco_id` FOREIGN KEY (`func_id`) REFERENCES `funcionario` (`idFunc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (2,'pi','pii','centro','Casa','64255 - 000'),(3,'pi','pii','centro','casa','33333 - 333'),(4,'Piauí','Piripiri','centro','Casa','64288 - 000');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `idFunc` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `dataNasc` date DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `numCelular` varchar(255) DEFAULT NULL,
  `id_depart` bigint(20) DEFAULT NULL,
  `estado_func` varchar(45) NOT NULL,
  PRIMARY KEY (`idFunc`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `id_depart_idx` (`id_depart`),
  CONSTRAINT `id_depart` FOREIGN KEY (`id_depart`) REFERENCES `departamento` (`idDepart`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (2,'Marcos Soares','555 . 555 . 555 - 55','1993-12-21','MASCULINO','(11) 1 . 1111 - 1111',3,'ativo'),(3,'Marcos Soares','111 . 111 . 111 - 11','2223-10-22','MASCULINO','(44) 4 . 4444 - 4444',4,'inativo'),(4,'João','333 . 333 . 333 - 33','1998-12-21','MASCULINO','(85) 9 . 8598 - 8900',NULL,'ativo');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarefa`
--

DROP TABLE IF EXISTS `tarefa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefa` (
  `idTarefa` bigint(20) NOT NULL AUTO_INCREMENT,
  `func_id` bigint(20) NOT NULL,
  `assunto` longtext,
  `descricao` longtext,
  `dataInicio` date DEFAULT NULL,
  `dataFinal` date DEFAULT NULL,
  `depart` bigint(20) NOT NULL,
  `estado_tarefa` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`idTarefa`),
  KEY `funcionario_id` (`func_id`),
  KEY `depart_idx` (`depart`),
  CONSTRAINT `depart_id` FOREIGN KEY (`depart`) REFERENCES `departamento` (`idDepart`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `funcionario_id` FOREIGN KEY (`func_id`) REFERENCES `funcionario` (`idFunc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarefa`
--

LOCK TABLES `tarefa` WRITE;
/*!40000 ALTER TABLE `tarefa` DISABLE KEYS */;
INSERT INTO `tarefa` VALUES (1,2,'Manutenção','Atualização','2016-08-29','2016-08-30',3,'Ativa'),(2,2,'Limpeza','Limpeza','2016-08-29','2016-08-30',3,'Ativa');
/*!40000 ALTER TABLE `tarefa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-29 18:33:48
