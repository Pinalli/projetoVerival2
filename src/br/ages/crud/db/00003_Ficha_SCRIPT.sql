
--liquibase formatted sql
--changeset cassio:3
--comment Script para criação das primeiras tabelas do projeto.
/***
* Scripts para criacao e insersao de dados
* Base Dados template
* iann muller
* 08 / 2016
***/

USE ficha_e;

DROP TABLE TB_TIPO_USUARIO;
DROP TABLE TB_USUARIO;

-- Tabela Usuario
--s

CREATE TABLE TB_USUARIO (
  ID_USUARIO int(11) NOT NULL AUTO_INCREMENT,
  USUARIO varchar(45) NOT NULL,
  SENHA varchar(45) NOT NULL,
  PERFIL_ACESSO varchar(20) NOT NULL,
  STATUS_USUARIO varchar(20) NOT NULL,
  ID_TIPO_USUARIO int(11) NOT NULL,
  CPF varchar(11) NOT NULL,
  ENDERECO varchar(120) NOT NULL,
  TELEFONE varchar(11) NOT NULL,
  NOME varchar(120) DEFAULT NULL,
  EMAIL varchar(120) DEFAULT NULL,
  DATA_INCLUSAO datetime DEFAULT NULL,
  PRIMARY KEY (ID_USUARIO,CPF),
  UNIQUE KEY CPF_UNIQUE  (CPF),
  CONSTRAINT U_USERNAME UNIQUE (USUARIO)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Tabela Tipo Usuario
CREATE TABLE TB_TIPO_USUARIO (
  ID_TIPO_USUARIO int(11) NOT NULL AUTO_INCREMENT,
  NOME varchar(20) NOT NULL,
  DESCRICAO varchar(120) DEFAULT NULL,
  DATA_INCLUSAO datetime DEFAULT NULL,
  PRIMARY KEY (ID_TIPO_USUARIO)
);

-- Inserts
INSERT INTO TB_TIPO_USUARIO VALUES
('1', 'Nutricionista', 'Responsavel pela parte tecnica', '2015-10-01 00:00:00');
INSERT INTO TB_TIPO_USUARIO VALUES
('2', 'Gerente', '', '2015-10-01 00:00:00');
INSERT INTO TB_TIPO_USUARIO VALUES
('3', 'Estagiario', '', '2015-10-01 00:00:00');
INSERT INTO TB_TIPO_USUARIO VALUES
('4', 'Funcionario', '', '2015-10-01 00:00:00');
INSERT INTO TB_TIPO_USUARIO VALUES
('5', 'Proprietario', '', '2015-10-01 00:00:00');

INSERT INTO TB_USUARIO
(ID_USUARIO,USUARIO,SENHA,PERFIL_ACESSO,STATUS_USUARIO,ID_TIPO_USUARIO, CPF,ENDERECO,TELEFONE,NOME,EMAIL,DATA_INCLUSAO)
VALUES
('10', 'admin', 'admin', 'ADMINISTRADOR', 'ATIVO', '1', '03380192000', 'r. pitangueiras, n88', '82828787','Nutricionista Default', 'email.bacana@gmail.com', '2015-10-01 00:00:00');

---select * from TB_USUARIO;
