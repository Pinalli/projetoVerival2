--liquibase formatted sql
--changeset cassio:1
--comment Script para criação das primeiras tabelas do projeto.
/***
* Scripts para criacao e insersao de dados
* Base Dados template
* Luis Santana
* 09 / 2016
***/

USE ficha_e;

drop table TB_INGREDIENTES;

CREATE TABLE `TB_INGREDIENTES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EMPRESA` int(11) DEFAULT NULL COMMENT 'Será necessário para quando tiver empresas',
  `COD` int(11) NOT NULL,
  `DESCRICAO` varchar(140) NOT NULL,
  `CARBOIDRATOS` decimal(10,2) DEFAULT NULL,
  `KCAL_CARBOIDRATOS` decimal(10,2) DEFAULT NULL,
  `PROTEINAS` decimal(10,2) DEFAULT NULL,
  `KCAL_PROTEINAS` decimal(10,2) DEFAULT NULL,
  `LIPIDIOS` decimal(10,2) DEFAULT NULL,
  `KCAL_LIPIDIOS` decimal(10,2) DEFAULT NULL,
  `FATOR_CORRECAO` decimal(10,2) DEFAULT NULL,
  `INDICE_COCCAO` decimal(10,2) DEFAULT NULL,
  `CUSTO` decimal(10,2) DEFAULT NULL,
  `UNIDADE_MEDIDA` varchar(140) NOT NULL,
  `DATA_INSERCAO` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `COD_UNIQUE` (`COD`),
  KEY `IX_IDS` (`ID_EMPRESA`,`COD`),
  KEY `IX_DATA` (`DATA_INSERCAO`,`COD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

