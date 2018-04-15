-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: kanbagisi
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.17.10.1

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
-- Table structure for table `GuncellenmisUye`
--

DROP TABLE IF EXISTS `GuncellenmisUye`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GuncellenmisUye` (
  `id` int(11) DEFAULT NULL,
  `guncellemeTarihi` varchar(45) NOT NULL,
  `kullaniciAdi` varchar(20) DEFAULT NULL,
  `sifre` varchar(45) DEFAULT NULL,
  `adi` varchar(45) DEFAULT NULL,
  `soyadi` varchar(45) DEFAULT NULL,
  `kanGrubu` varchar(45) DEFAULT NULL,
  `telNo` varchar(10) DEFAULT NULL,
  `ePosta` varchar(45) DEFAULT NULL,
  `sehir` varchar(45) DEFAULT NULL,
  `ilce` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`guncellemeTarihi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GuncellenmisUye`
--

LOCK TABLES `GuncellenmisUye` WRITE;
/*!40000 ALTER TABLE `GuncellenmisUye` DISABLE KEYS */;
/*!40000 ALTER TABLE `GuncellenmisUye` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Uyeler`
--

DROP TABLE IF EXISTS `Uyeler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Uyeler` (
  `id` varchar(20) NOT NULL,
  `kullaniciAdi` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `sifre` varchar(45) DEFAULT NULL,
  `adi` varchar(45) DEFAULT NULL,
  `soyadi` varchar(45) DEFAULT NULL,
  `kanGrubu` varchar(3) DEFAULT NULL,
  `telNo` varchar(10) DEFAULT NULL,
  `ePosta` varchar(45) DEFAULT NULL,
  `sehir` varchar(45) DEFAULT NULL,
  `ilce` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Uyeler`
--

LOCK TABLES `Uyeler` WRITE;
/*!40000 ALTER TABLE `Uyeler` DISABLE KEYS */;
INSERT INTO `Uyeler` VALUES ('1000','deneme','deneme123','Deneme','Denemeoglu','0+','5303003030','deneme@deneme.com','Ankara','Çankaya');
/*!40000 ALTER TABLE `Uyeler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 23:08:23
