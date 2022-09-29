-- MySQL dump 10.13  Distrib 5.6.20, for Win64 (x86_64)
--
-- Host: localhost    Database: ventas
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `idcategorias` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(60) DEFAULT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`idcategorias`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'MUEBLESs','INACTIVO'),(2,'MUEBLES','ACTIVO'),(3,'AAA','INACTIVO'),(4,'PINTURAS','ACTIVO'),(5,'TIRANTES','ACTIVO'),(6,'SERVICIOS','ACTIVO'),(7,'FERRETERIA','ACTIVO'),(8,'PRUEBA','INACTIVO'),(9,'AAA','INACTIVO'),(10,'ELECTRONICOS','ACTIVO'),(11,'MUEBLES2','INACTIVO'),(12,'CATEGORIA','ACTIVO');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `idcompra` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `total` bigint(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `nro_factura` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `idmovimiento` int(11) NOT NULL,
  PRIMARY KEY (`idcompra`),
  KEY `fk_venta_usuarios1_idx` (`idusuarios`),
  KEY `fk_venta_movimiento_caja1_idx` (`idmovimiento`),
  CONSTRAINT `fk_venta_movimiento_caja10` FOREIGN KEY (`idmovimiento`) REFERENCES `movimiento_caja` (`idmovimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_usuarios10` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (59,24,111000,'2022-07-20','0000028','CONTADO','FINALIZADO',111),(60,24,200000,'2022-08-02','0000002','CONTADO','FINALIZADO',114),(61,24,2015000,'2022-08-12','0000003','CONTADO','FINALIZADO',118),(62,24,30000,'2022-08-12','0000012','PRESUPUESTO','PRESUPUESTO',118),(63,24,30000,'2022-08-12','0000012','PRESUPUESTO','PRESUPUESTO',118),(64,24,30000,'2022-08-12','0','PRESUPUESTO','PRESUPUESTO',118),(65,24,30000,'2022-08-12','0','PRESUPUESTO','PRESUPUESTO',118),(66,24,85000,'2022-08-12','0','PRESUPUESTO','PRESUPUESTO',118),(67,24,3000,'2022-08-16','0000009','CONTADO','FINALIZADO',118),(68,24,35000,'2022-08-16','0000010','CONTADO','FINALIZADO',118),(69,24,40000,'2022-08-16','0000011','CONTADO','FINALIZADO',118),(70,24,3000,'2022-08-16','0000012','CONTADO','FINALIZADO',118),(71,24,3000,'2022-08-16','0000013','CONTADO','FINALIZADO',118),(72,24,25000,'2022-08-16','0000014','CONTADO','FINALIZADO',118),(73,24,80000,'2022-08-18','0000015','CONTADO','FINALIZADO',118),(74,24,5000,'2022-08-18','0','PRESUPUESTO','PRESUPUESTO',118),(75,24,30000,'2022-08-18','0','PRESUPUESTO','PRESUPUESTO',118),(76,24,175000,'2022-08-18','0000018','CONTADO','FINALIZADO',118),(77,24,30000,'2022-08-18','0000019','CONTADO','FINALIZADO',118);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_compra` (
  `iddetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idservicios` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` bigint(20) NOT NULL,
  `sub_total` bigint(20) NOT NULL,
  `pulgadas` bigint(20) DEFAULT NULL,
  `idcompra` int(11) NOT NULL,
  `idproveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddetalle`),
  KEY `fk_detalle_venta_servicios1_idx` (`idservicios`),
  KEY `fk_detalle_compra_compras1_idx` (`idcompra`),
  CONSTRAINT `fk_detalle_compra_compras1` FOREIGN KEY (`idcompra`) REFERENCES `compras` (`idcompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_venta_servicios0` FOREIGN KEY (`idservicios`) REFERENCES `productos` (`idservicios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
INSERT INTO `detalle_compra` VALUES (116,18,1,3000,3000,0,59,1),(117,21,1,8000,8000,0,59,2),(118,11,1,100000,100000,0,59,1),(119,14,10,20000,200000,0,60,1),(120,21,10,8000,80000,0,61,2),(121,18,10,3000,30000,0,61,1),(122,14,10,20000,200000,0,61,1),(123,13,16,30000,480000,0,61,1),(124,12,9,25000,225000,0,61,1),(125,11,10,100000,1000000,0,61,1),(126,18,1,3000,3000,0,67,1),(127,23,1,35000,35000,0,68,1),(128,14,2,20000,40000,0,69,1),(129,18,1,3000,3000,0,70,1),(130,18,1,3000,3000,0,71,1),(131,12,1,25000,25000,0,72,1),(132,21,10,8000,80000,0,73,2),(133,23,5,35000,175000,0,76,1),(134,15,1,30000,30000,0,77,1);
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_venta` (
  `iddetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idventa` int(11) NOT NULL,
  `idservicios` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` bigint(20) NOT NULL,
  `sub_total` bigint(20) NOT NULL,
  `pulgadas` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`iddetalle`),
  KEY `fk_detalle_venta_venta1_idx` (`idventa`),
  KEY `fk_detalle_venta_servicios1_idx` (`idservicios`),
  CONSTRAINT `fk_detalle_venta_servicios` FOREIGN KEY (`idservicios`) REFERENCES `productos` (`idservicios`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idventa` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=471 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (420,290,15,1,30000,30000,0),(421,291,15,3,30000,90000,0),(422,292,21,1,10000,10000,0),(423,292,18,1,5000,5000,0),(424,292,18,1,5000,5000,0),(425,292,23,1,50000,50000,0),(426,292,14,1,30000,30000,0),(427,293,18,3,5000,15000,0),(428,294,14,1,30000,30000,0),(429,294,23,1,50000,50000,0),(430,294,15,1,30000,30000,0),(431,295,14,1,30000,30000,0),(432,295,11,1,150000,150000,0),(433,296,12,1,35000,35000,0),(434,296,13,1,50000,50000,0),(435,297,12,1,35000,35000,0),(436,297,11,1,150000,150000,0),(437,298,15,1,30000,30000,0),(438,299,15,1,30000,30000,0),(439,300,15,1,30000,30000,0),(440,303,18,1,5000,5000,0),(441,303,18,1,5000,5000,0),(442,303,14,1,30000,30000,0),(443,310,14,1,30000,30000,0),(444,311,15,1,30000,30000,0),(445,312,18,1,5000,5000,0),(446,313,14,1,30000,30000,0),(447,314,15,1,30000,30000,0),(448,315,12,1,35000,35000,0),(449,316,21,4,10000,40000,0),(450,317,11,1,150000,150000,0),(451,319,15,1,30000,30000,0),(452,320,18,1,5000,5000,0),(453,320,14,1,30000,30000,0),(454,320,13,1,50000,50000,0),(455,321,24,1,800000,800000,0),(456,321,18,1,5000,5000,0),(457,321,13,1,50000,50000,0),(458,322,18,1,5000,5000,0),(459,322,23,1,50000,50000,0),(460,323,21,1,10000,10000,0),(461,323,13,1,50000,50000,0),(462,325,15,1,30000,30000,0),(463,326,23,3,50000,50000,0),(464,326,13,4,50000,50000,0),(465,327,24,2,800000,800000,0),(466,327,21,1,10000,10000,0),(467,328,24,1,800000,800000,0),(468,328,13,1,50000,50000,0),(469,328,18,4,5000,5000,0),(470,328,24,1,800000,800000,0);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deudas`
--

DROP TABLE IF EXISTS `deudas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deudas` (
  `iddeuda` int(11) NOT NULL AUTO_INCREMENT,
  `total_deuda` bigint(20) NOT NULL,
  `total_pagado` bigint(20) DEFAULT '0',
  `saldo` bigint(20) DEFAULT '0',
  `estado` varchar(45) NOT NULL,
  `fecha_deuda` date DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL,
  `idcliente` int(11) NOT NULL,
  PRIMARY KEY (`iddeuda`),
  KEY `fk_deudas_venta1_idx` (`iddeuda`),
  KEY `fk_deudas_paciente1_idx` (`idcliente`),
  CONSTRAINT `fk_deudas_paciente1` FOREIGN KEY (`idcliente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deudas`
--

LOCK TABLES `deudas` WRITE;
/*!40000 ALTER TABLE `deudas` DISABLE KEYS */;
INSERT INTO `deudas` VALUES (15,145000,0,0,'PENDIENTE','2022-08-03','2022-08-19',25),(16,50000,0,0,'PENDIENTE','2022-08-12','2022-08-18',28),(17,35000,0,0,'PENDIENTE','2022-08-18',NULL,40),(18,100000,0,0,'PENDIENTE','2022-08-18','2022-08-18',42),(19,60000,0,0,'PENDIENTE','2022-08-19',NULL,46);
/*!40000 ALTER TABLE `deudas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egresos`
--

DROP TABLE IF EXISTS `egresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `egresos` (
  `idegresos` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `monto` bigint(10) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `idusuarios` int(11) NOT NULL,
  `idmovimiento` int(11) NOT NULL,
  PRIMARY KEY (`idegresos`),
  KEY `fk_egresos_usuarios1_idx` (`idusuarios`),
  KEY `fk_egresos_movimiento_caja1_idx` (`idmovimiento`),
  CONSTRAINT `fk_egresos_movimiento_caja1` FOREIGN KEY (`idmovimiento`) REFERENCES `movimiento_caja` (`idmovimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_egresos_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresos`
--

LOCK TABLES `egresos` WRITE;
/*!40000 ALTER TABLE `egresos` DISABLE KEYS */;
INSERT INTO `egresos` VALUES (37,'FLETE',50000,'2022-08-01','16:48','EGRESO',24,114),(38,'NAFTA',30000,'2022-08-01','16:49','EGRESO',24,114),(39,'VENTA',100000,'2022-08-01','16:49','INGRESO',24,114),(40,'FLETE',50000,'2022-08-01','16:50','INGRESO',24,114),(41,'VENTA',20000,'2022-08-04','10:53','INGRESO',24,116),(42,'MADERA',120000,'2022-08-04','10:54','INGRESO',24,116),(43,'A',25000,'2022-08-04','16:04','INGRESO',24,116),(44,'ASA',50000,'2022-08-04','16:04','EGRESO',24,116),(45,'FFF',50000,'2022-08-04','16:04','EGRESO',24,116),(46,'GGGG',80000,'2022-08-04','16:04','EGRESO',24,116),(47,'JJ',120000,'2022-08-04','16:04','EGRESO',24,116),(48,'FLETES VARIOS',250000,'2022-08-09','08:57','INGRESO',24,116),(49,'VENTA AFUERA',2000000,'2022-08-12','09:08','INGRESO',24,118),(50,'VENTA',2000,'2022-08-16','08:17','INGRESO',24,118),(51,'VENTA',5000,'2022-08-04','08:20','INGRESO',24,118),(52,'PRUEBA',10000,'2022-08-04','08:20','INGRESO',24,118),(53,'A',20000,'2022-08-04','08:21','EGRESO',24,118),(54,'NAFTRA',150000,'2022-08-16','08:27','EGRESO',24,118),(55,'DESCUENTO',20000,'2022-08-04','15:57','INGRESO',24,118),(56,'VENTA',50000,'2022-08-19','16:49','INGRESO',24,121),(57,'NAFTA',20000,'2022-08-19','16:49','EGRESO',24,121);
/*!40000 ALTER TABLE `egresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `nrofactura` int(11) NOT NULL,
  `monto` bigint(20) DEFAULT NULL,
  `efectivo` bigint(20) DEFAULT NULL,
  `vuelto` bigint(20) DEFAULT NULL,
  `idventa` int(11) NOT NULL,
  PRIMARY KEY (`nrofactura`),
  KEY `fk_factura_venta1_idx` (`idventa`),
  CONSTRAINT `fk_factura_venta1` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,30000,30000,0,290),(2,90000,90000,0,291),(3,15000,15000,0,292),(4,15000,15000,0,293),(5,110000,110000,0,294),(6,180000,180000,0,295),(7,85000,85000,0,296),(8,185000,185000,0,297),(9,30000,30000,0,298),(10,30000,30000,0,299),(11,30000,30000,0,300),(12,5000,5000,0,303),(13,30000,30000,0,310),(17,30000,50000,20000,314),(18,35000,50000,15000,315),(19,40000,50000,10000,316),(20,150000,200000,50000,317),(21,30000,30000,0,319),(22,85000,850000,765000,320),(23,855000,900000,45000,321),(24,55000,55000,0,322),(25,60000,60000,0,323),(26,30000,30000,0,325),(27,100000,100000,0,326),(28,810000,900000,90000,327),(29,1655000,1660000,5000,328);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento_caja`
--

DROP TABLE IF EXISTS `movimiento_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento_caja` (
  `idmovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `num_Caja` varchar(45) DEFAULT NULL,
  `fecha_apertura` date NOT NULL,
  `fecha_cierre` date DEFAULT NULL,
  `monto_apertura` bigint(20) NOT NULL,
  `monto_cierre` bigint(20) DEFAULT '0',
  `credito` bigint(20) DEFAULT '0',
  `gastos` bigint(20) DEFAULT '0',
  `cobrado` bigint(20) DEFAULT '0',
  `contado` bigint(20) DEFAULT '0',
  `ingresos` bigint(20) DEFAULT '0',
  `compras` bigint(20) DEFAULT '0',
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idmovimiento`),
  KEY `fk_movimiento_caja_usuarios1_idx` (`idusuarios`),
  CONSTRAINT `fk_movimiento_caja_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_caja`
--

LOCK TABLES `movimiento_caja` WRITE;
/*!40000 ALTER TABLE `movimiento_caja` DISABLE KEYS */;
INSERT INTO `movimiento_caja` VALUES (67,24,'1','2021-12-27','2021-12-30',199999,99999,0,0,0,0,0,0,'CERRADO'),(68,24,'3','2021-12-30','2021-12-30',100000,100000,0,0,0,0,0,0,'CERRADO'),(69,24,'1','2021-12-30','2021-12-30',200000,0,0,0,0,0,0,0,'CERRADO'),(70,24,'1','2021-12-30','2021-12-30',100000,0,0,0,0,0,0,0,'CERRADO'),(71,24,'1','2021-12-30','2021-12-30',100000,550000,0,0,0,0,0,0,'CERRADO'),(72,24,'1','2022-01-02','2022-01-02',100000,250000,0,0,0,0,0,0,'CERRADO'),(73,27,'1','2022-01-02','2022-01-02',100000,0,0,0,0,0,0,0,'CERRADO'),(74,26,'1','2022-01-04','2022-01-04',100000,0,0,0,0,0,0,0,'CERRADO'),(75,24,'1','2022-01-14','2022-01-14',100000,100000,0,0,0,0,0,0,'CERRADO'),(77,26,'1','2022-01-14','2022-01-31',90000,90000,0,0,0,0,0,0,'CERRADO'),(78,24,'1','2022-01-14','2022-01-14',90000,150000,0,0,0,0,0,0,'CERRADO'),(79,24,'1','2022-01-14','2022-01-16',150000,127745,0,0,0,0,0,0,'CERRADO'),(80,24,'1','2022-01-16','2022-01-31',200000,5901653,0,0,0,0,0,0,'CERRADO'),(81,24,'1','2022-02-01','2022-02-02',200000,1655000,0,0,0,0,0,0,'CERRADO'),(82,24,'1','2022-02-02','2022-02-02',100000,130000,0,0,0,0,0,0,'CERRADO'),(83,24,'1','2022-02-02','2022-02-02',130000,132000,0,0,0,0,0,0,'CERRADO'),(84,24,'1','2022-02-02','2022-02-02',100000,130000,0,0,0,0,0,0,'CERRADO'),(85,24,'1','2022-02-02','2022-02-02',180000,360000,0,0,0,0,0,0,'CERRADO'),(86,24,'1','2022-02-02','2022-02-02',100000,130000,0,0,0,0,0,0,'CERRADO'),(87,24,'1','2022-03-25','2022-03-28',100000,0,0,0,0,0,0,0,'CERRADO'),(88,24,'1','2022-03-28','2022-03-28',100000,200000,0,0,0,0,0,0,'CERRADO'),(89,24,'1','2022-03-28','2022-03-28',100000,130000,0,0,0,0,0,0,'CERRADO'),(90,24,'1','2022-03-28','2022-04-07',100000,475000,0,0,0,0,0,0,'CERRADO'),(91,27,'1','2022-03-29','2022-03-29',100000,0,0,0,0,0,0,0,'CERRADO'),(92,24,'1','2022-04-11','2022-04-20',100000,485000,0,0,0,0,0,0,'CERRADO'),(93,24,'1','2022-04-26','2022-05-03',1000000,1310000,0,0,0,0,0,0,'CERRADO'),(94,24,'1','2022-05-03','2022-05-03',100000,100000,0,0,0,0,0,0,'CERRADO'),(95,24,'1','2022-05-05','2022-05-05',100000,70000,0,0,0,0,0,0,'CERRADO'),(96,24,'1','2022-05-05','2022-05-05',100000,100000,0,0,0,0,0,0,'CERRADO'),(97,24,'1','2022-05-06','2022-07-20',10000,800000,0,0,0,0,0,0,'CERRADO'),(98,24,'1','2022-07-20','2022-07-20',80000,600000,0,0,0,0,0,0,'CERRADO'),(99,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(100,24,'1','2022-07-20','2022-07-20',50000,30000,0,0,0,0,0,0,'CERRADO'),(101,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(102,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(103,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(104,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(105,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(106,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(107,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(108,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(109,24,'1','2022-07-20','2022-07-20',50000,50000,0,0,0,0,0,0,'CERRADO'),(110,24,'1','2022-07-20','2022-07-25',50000,50000,0,0,0,0,0,0,'CERRADO'),(111,24,'1','2022-07-20','2022-07-25',100000,227000,0,0,0,0,0,0,'CERRADO'),(112,24,'1','2022-07-25','2022-07-26',50000,50000,0,0,0,0,0,0,'CERRADO'),(113,24,'1','2022-07-26','2022-08-01',50000,1151000,0,0,0,0,0,0,'CERRADO'),(114,24,'1','2022-08-01','2022-08-02',50000,270000,0,0,0,0,0,0,'CERRADO'),(115,24,'1','2022-08-03','2022-08-03',270000,835000,0,0,0,0,0,0,'CERRADO'),(116,24,'1','2022-08-03','2022-08-03',835000,835000,0,0,0,0,0,0,'CERRADO'),(117,39,'1','2022-08-09','2022-08-09',50000,50000,0,0,0,0,0,0,'CERRADO'),(118,24,'1','2022-08-10','2022-08-18',835000,1418000,0,0,0,0,0,0,'CERRADO'),(119,39,'1','2022-08-10','2022-08-10',50000,0,0,0,0,0,0,0,'ACTIVO'),(120,24,'1','2022-08-19','2022-08-19',1418000,2358000,0,0,0,0,0,0,'CERRADO'),(121,24,'1','2022-08-19','2022-08-19',2358000,2443000,0,0,0,0,0,0,'CERRADO'),(122,24,'1','2022-08-21','2022-08-21',2443000,0,0,0,0,0,0,0,'ACTIVO');
/*!40000 ALTER TABLE `movimiento_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `idpaciente` int(11) NOT NULL,
  `fechanac` date DEFAULT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idpaciente`),
  KEY `fk_paciente_persona_idx` (`idpaciente`),
  CONSTRAINT `fk_paciente_persona` FOREIGN KEY (`idpaciente`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (25,NULL,'ACTIVO'),(28,NULL,'ACTIVO'),(40,NULL,'ACTIVO'),(42,NULL,'ACTIVO'),(44,NULL,'ACTIVO'),(46,NULL,'ACTIVO');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `idpermiso` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `venta` tinyint(1) DEFAULT '0',
  `compras` tinyint(1) DEFAULT '0',
  `apertura_caja` tinyint(1) DEFAULT '0',
  `cierre_caja` tinyint(1) DEFAULT '0',
  `pago_deudas` tinyint(1) DEFAULT '0',
  `ing_egre` tinyint(1) DEFAULT '0',
  `historial_ven` tinyint(1) DEFAULT '0',
  `ventas_dia` tinyint(1) DEFAULT '0',
  `venta_cliente` tinyint(1) DEFAULT '0',
  `historial_compras` tinyint(1) DEFAULT '0',
  `historial_ingre_egre` tinyint(1) DEFAULT '0',
  `resumen_ingre_egre` tinyint(1) DEFAULT '0',
  `usuarios` tinyint(1) DEFAULT '0',
  `respaldo` tinyint(1) DEFAULT '0',
  `rptusuarios` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idpermiso`),
  KEY `fk_permisos_usuarios_idx` (`idusuarios`),
  CONSTRAINT `fk_permisos_usuarios` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (10,24,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1),(11,39,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0),(12,41,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0),(13,43,1,1,0,0,1,1,0,0,1,1,0,0,0,0,0),(14,45,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0);
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `numDocumento` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (24,'JOSE','AYALA','4419747','0699','CALLE','MASCULINO	','ACTIVO'),(25,'JOSE L','AYALA','4419747','0982568965','calle san roque','MASCULINO	','ACTIVO'),(26,'prueba','prueba','448548','0985554878','calle','MASCULINO	','ACTIVO'),(27,'JUAN','PEREZ','99992','999993','CALLE','MASCULINO	','ACTIVO'),(28,'PABLO','GIRALA','9999','99999','calle','MASCULINO	','ACTIVO'),(39,'USUARIO','CAJA',NULL,NULL,NULL,NULL,'ACTIVO'),(40,'JESUS','GARCETE','099090','00909','calle','MASCULINO	','ACTIVO'),(41,'prueba','3',NULL,NULL,NULL,NULL,'INACTIVO'),(42,'MARCELO','ARANDA','4444','4444','ca','MASCULINO	','ACTIVO'),(43,'PRUEBA33','PRUEBA22',NULL,NULL,NULL,NULL,'INACTIVO'),(44,'PAOLA','MOREL','900','09090','calle','FEMENINO','ACTIVO'),(45,'NUEVO','USUARIO',NULL,NULL,NULL,NULL,'ACTIVO'),(46,'USUARIO','PREDETERMINADO','000000','00000','00000','FEMENINO','ACTIVO');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `idservicios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(45) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `precio_unitario` bigint(20) NOT NULL,
  `precio_mayor` bigint(20) NOT NULL,
  `precio_costo` bigint(20) DEFAULT NULL,
  `stock` double NOT NULL,
  `estado` varchar(45) NOT NULL,
  `idcategorias` int(11) NOT NULL,
  `pulgadas` double DEFAULT NULL,
  `idproveedor` int(11) NOT NULL,
  PRIMARY KEY (`idservicios`),
  KEY `fk_productos_categorias1_idx` (`idcategorias`),
  KEY `fk_productos_proveedor1_idx` (`idproveedor`),
  CONSTRAINT `fk_productos_categorias1` FOREIGN KEY (`idcategorias`) REFERENCES `categorias` (`idcategorias`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_proveedor1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (9,'MESA','MESA 1X3 METROS',150000,130000,90000,15,'INACTIVO',2,0,1),(10,'SILLA','SILLA PEQUEÑA',50000,40000,30000,10,'INACTIVO',1,0,1),(11,'MESA REDONDA','MESA PARA PATIO REDONDO ',150000,130000,100000,13,'INACTIVO',2,0,1),(12,'PINTURA AL ACEITE','PINTURA AL ACEITE AMANECER DE 1 LTS',35000,30000,25000,14,'INACTIVO',4,0,1),(13,'SILLA','SILLA DE MADERA PARA JARDIN',50000,45000,30000,7,'ACTIVO',2,0,1),(14,'TIRANTE 2X5','TIRANTE',30000,28000,20000,12,'ACTIVO',5,1510,1),(15,'FLETE','FLETE DE PRODUCTOS VARIOS',30000,30000,30000,31,'ACTIVO',6,8,1),(16,'ADFA','AFAS',333,333,333,3333,'INACTIVO',6,333,1),(18,'CANILLA','CANILLA DE PLASTICO',5000,4500,3000,7,'ACTIVO',7,0,1),(19,'FLETE','FLETE DE MADERA',20000,20000,20000,0,'INACTIVO',6,0,2),(20,'AF','ADF',333,33,333,0,'INACTIVO',7,0,2),(21,'CERVEZA','CERVEZA MUNICH',10000,9000,8000,20,'ACTIVO',7,0,2),(22,'A','AAA',3,2,1,0,'INACTIVO',7,0,1),(23,'MOUSE SATE','MOUSE',50000,45000,35000,11,'ACTIVO',10,0,1),(24,'MONITOR GIGABYTE','MONITOR',800000,750000,650000,5,'ACTIVO',10,0,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(85) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(85) DEFAULT NULL,
  `ruc` varchar(45) DEFAULT NULL,
  `razon` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'NISSEI','343434','CDE','99999999','ELECTRONICOS','ACTIVO'),(2,'VISAO VIP','0988777','CDE','99809809','CASA ELECTRONICOS','ACTIVO'),(3,'CASA CHIN','0989855','CDE','4554989','ELECTRONICOS Y HOGAR','ACTIVO');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL,
  `acceso` varchar(45) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuarios`),
  CONSTRAINT `fk_usuarios_persona1` FOREIGN KEY (`idusuarios`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (24,'ADMINISTRADOR','admin','admin','ACTIVO'),(26,'ADMINISTRADOR','prueba','1','ACTIVO'),(27,'ADMINISTRADOR','ADMIN','1','ACTIVO'),(39,'CAJA','caja','1','ACTIVO'),(41,'CAJA','prueba','prueba','INACTIVO'),(43,'CAJA','CAJA2','12345','INACTIVO'),(45,'CAJA','usuario','12345','ACTIVO');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `total` bigint(20) NOT NULL,
  `fecha` date NOT NULL,
  `nro_factura` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `idmovimiento` int(11) NOT NULL,
  `descuento` bigint(20) DEFAULT NULL,
  `saldo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idventa`),
  KEY `fk_venta_usuarios1_idx` (`idusuarios`),
  KEY `fk_venta_paciente1_idx` (`idpaciente`),
  KEY `fk_venta_movimiento_caja1_idx` (`idmovimiento`),
  CONSTRAINT `fk_venta_movimiento_caja1` FOREIGN KEY (`idmovimiento`) REFERENCES `movimiento_caja` (`idmovimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=329 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (290,24,28,30000,'2022-08-12','0000001','CONTADO','FINALIZADO',118,0,0),(291,24,28,90000,'2022-08-12','0000002','CREDITO','PENDIENTE',118,0,90000),(292,24,25,15000,'2022-08-12','0000003','CONTADO','FINALIZADO',118,0,0),(293,24,25,15000,'2022-08-12','0000004','CONTADO','FINALIZADO',118,0,0),(294,24,25,110000,'2022-08-16','0000005','CONTADO','FINALIZADO',118,0,0),(295,24,25,180000,'2022-08-16','0000006','CONTADO','FINALIZADO',118,0,0),(296,24,25,85000,'2022-08-16','0000007','CONTADO','FINALIZADO',118,0,0),(297,24,25,185000,'2022-08-16','0000008','CONTADO','FINALIZADO',118,0,0),(298,24,25,30000,'2022-08-16','0000009','CONTADO','FINALIZADO',118,0,0),(299,24,25,30000,'2022-08-16','0000010','CONTADO','FINALIZADO',118,0,0),(300,24,25,30000,'2022-08-16','0000011','CONTADO','FINALIZADO',118,0,0),(301,24,28,80000,'2022-08-16','0000001','DEUDA','PAGADO',118,0,0),(302,24,28,50000,'2022-08-18','0000002','DEUDA','PAGADO',118,0,0),(303,24,40,5000,'2022-08-18','0000012','CONTADO','FINALIZADO',118,0,0),(304,24,25,25000,'2022-08-18','0000003','DEUDA','PAGADO',118,0,0),(305,24,28,50000,'2022-08-18','0000004','DEUDA','PAGADO',118,0,0),(306,24,25,5000,'2022-08-18','0000005','DEUDA','PAGADO',118,0,0),(307,24,28,2000,'2022-08-18','0000006','DEUDA','PAGADO',118,0,0),(308,24,28,8000,'2022-08-18','0000007','DEUDA','PAGADO',118,0,0),(309,24,28,40000,'2022-08-18','0000008','DEUDA','PAGADO',118,0,0),(310,24,40,30000,'2022-08-18','0000013','CONTADO','FINALIZADO',118,0,0),(311,24,40,30000,'2022-08-18','0000014','CREDITO','PENDIENTE',118,0,30000),(312,24,40,5000,'2022-08-18','0000015','CREDITO','PENDIENTE',118,0,5000),(313,24,40,30000,'2022-08-18','0000016','CREDITO','PENDIENTE',118,0,30000),(314,24,40,30000,'2022-08-18','0000017','CREDITO','PENDIENTE',118,0,30000),(315,24,40,35000,'2022-08-18','0000018','CREDITO','PENDIENTE',118,0,35000),(316,24,42,40000,'2022-08-18','0000019','CREDITO','PENDIENTE',118,0,40000),(317,24,42,150000,'2022-08-18','0000020','CREDITO','PENDIENTE',118,0,150000),(318,24,42,90000,'2022-08-18','0000009','DEUDA','PAGADO',118,0,0),(319,24,40,30000,'2022-08-18','0000021','CONTADO','FINALIZADO',118,0,0),(320,24,42,85000,'2022-08-19','0000022','CONTADO','FINALIZADO',120,0,0),(321,24,40,855000,'2022-08-19','0000023','CONTADO','FINALIZADO',120,0,0),(322,24,46,55000,'2022-08-19','0000024','CONTADO','FINALIZADO',121,0,0),(323,24,46,60000,'2022-08-19','0000025','CREDITO','PENDIENTE',121,0,60000),(324,24,25,50000,'2022-08-19','0000010','DEUDA','PAGADO',121,0,0),(325,24,44,30000,'2022-08-21','0000026','CONTADO','FINALIZADO',122,0,0),(326,24,46,100000,'2022-08-21','0000027','CONTADO','FINALIZADO',122,0,0),(327,24,40,810000,'2022-08-21','0000028','CONTADO','FINALIZADO',122,0,0),(328,24,40,1655000,'2022-08-21','0000029','CONTADO','FINALIZADO',122,0,0);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-21 23:13:00
