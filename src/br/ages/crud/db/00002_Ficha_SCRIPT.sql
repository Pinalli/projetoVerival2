--liquibase formatted sql
--changeset cassio:2
--comment Script para criação das primeiras tabelas do projeto.
/***
* Scripts para criacao e insersao de dados
* Base Dados template
* Homero Oliveira
* 08 / 2016
***/

USE ficha_e;

--Tabela Unidade Medida Caseira
CREATE TABLE `TB_UNIDADE_MEDIDA_CASEIRA` (
  `ID_UNIDADE_MEDIDA_CASEIRA` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(120) NULL ,
  `SIGLA` VARCHAR(10) NULL ,
  PRIMARY KEY (`ID_UNIDADE_MEDIDA_CASEIRA`)  );

 --Tabela Unidade Medida 
CREATE TABLE `TB_UNIDADE_MEDIDA` (
  `ID_UNIDADE_MEDIDA` INT NOT NULL AUTO_INCREMENT ,
  `DESCRICAO_ORIGEM` VARCHAR(60) NULL ,
  `DESCRICAO_CONVERSAO` VARCHAR(60) NULL ,
  `SIGLA` VARCHAR(10) NULL ,
  `MEDIDA_CONVERSAO` DOUBLE NULL  ,
  PRIMARY KEY (`ID_UNIDADE_MEDIDA`) );