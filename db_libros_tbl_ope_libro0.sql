CREATE DATABASE  IF NOT EXISTS `db_libros` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_libros`;
-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: db_libros
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

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
-- Table structure for table `tbl_ope_libro`
--

DROP TABLE IF EXISTS `tbl_ope_libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_ope_libro` (
  `LibroId` int(11) NOT NULL AUTO_INCREMENT,
  `Libro_Nombre` varchar(60) DEFAULT NULL,
  `Libro_Costo` int(11) DEFAULT NULL,
  `Libro_Cantidad` int(11) DEFAULT NULL,
  `Libro_GeneroId` int(11) DEFAULT NULL,
  `Libro_EditorialId` int(11) DEFAULT NULL,
  `Libro_IdiomaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`LibroId`),
  KEY `Libro_GeneroId_idx` (`Libro_GeneroId`),
  KEY `Libro_EditorialId_idx` (`Libro_EditorialId`),
  KEY `Libro_IdiomaId_idx` (`Libro_IdiomaId`),
  CONSTRAINT `Libro_EditorialId` FOREIGN KEY (`Libro_EditorialId`) REFERENCES `tbl_cat_editorial` (`EditorialId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Libro_GeneroId` FOREIGN KEY (`Libro_GeneroId`) REFERENCES `tbl_cat_genero` (`GeneroId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Libro_IdiomaId` FOREIGN KEY (`Libro_IdiomaId`) REFERENCES `tbl_cat_idioma` (`IdiomaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_ope_libro`
--

LOCK TABLES `tbl_ope_libro` WRITE;
/*!40000 ALTER TABLE `tbl_ope_libro` DISABLE KEYS */;
INSERT INTO `tbl_ope_libro` VALUES (1,'El Equipo de los Sueños',864,31,3,1,1),(2,'Dos Años de Vacaciones',1320,20,2,3,1),(3,'El Resplandor',1150,25,1,2,2),(5,'Harry Potter',1430,28,2,4,2),(6,'Viaje al Centro de la Tierra',1480,18,2,1,2),(7,'Cementerio de Mascotas',1250,20,1,2,4),(8,'Crepusculo',980,22,4,2,4);
/*!40000 ALTER TABLE `tbl_ope_libro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-07  3:56:01
