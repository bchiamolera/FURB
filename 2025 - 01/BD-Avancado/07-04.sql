-- DROP TABLE ItemNotaFiscal;
-- DROP TABLE Medicamento;
-- DROP TABLE NotaFiscal;
-- DROP TABLE Cliente
 
CREATE TABLE cliente (
    cd_cliente integer  NOT NULL AUTO_INCREMENT,
    nm_cliente VARCHAR(255) NOT NULL,
    nr_telefone VARCHAR(15) NULL,
	dt_nascimento DATE NULL,
	primary key (cd_cliente)
);
 
CREATE TABLE Medicamento (
	cd_medicamento integer AUTO_INCREMENT,
	nm_medicamento varchar(50) ,
	ds_medicamento varchar(200) ,
	vl_custo decimal(8,2) default 0,
	vl_venda decimal(8,2) default 0,
	qt_estoque integer  default 0,
	PRIMARY KEY (cd_medicamento)
);
 
CREATE TABLE NotaFiscal (
	nr_notafiscal integer AUTO_INCREMENT ,
	cd_cliente integer references cliente(cd_cliente),
	dt_emissao date ,
	vl_total decimal(8,2) default 0 ,
	PRIMARY KEY (nr_notafiscal)
);
 
CREATE TABLE ItemNotaFiscal (
	nr_notafiscal integer,
	cd_medicamento integer,
	qt_vendida integer default 0,
	vl_venda decimal(8,2) default 0,
    PRIMARY KEY (nr_notafiscal, cd_medicamento),
	FOREIGN KEY (nr_notafiscal) REFERENCES Notafiscal(nr_notafiscal),
	FOREIGN KEY (cd_medicamento) REFERENCES Medicamento(cd_medicamento)
);
 
INSERT INTO cliente (nm_cliente, nr_telefone, dt_nascimento) VALUES('Ana Clara Mendes', '(11) 91234-5678', '1995-04-12');
INSERT INTO cliente (nm_cliente, nr_telefone, dt_nascimento) VALUES('Bruno Alves', '(21) 99876-5432', '1988-11-03');
INSERT INTO cliente (nm_cliente, nr_telefone, dt_nascimento) VALUES('Carlos Eduardo', NULL, '1979-07-22');
INSERT INTO cliente (nm_cliente, nr_telefone, dt_nascimento) VALUES('Daniela Souza', '(31) 98765-4321', NULL);
INSERT INTO cliente (nm_cliente, nr_telefone, dt_nascimento) VALUES('Eduarda Lima', '(41) 99123-4567', '2000-01-15');
 
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Benegripe', 'Remédio pra gripe', 5.0, 10.0, 11);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Aspirina C', 'Remédio pra aumentar a resistência', 7.0, 11.0, 22);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Dermatos', 'Remédio pra dores', 20.0, 30.0, 33);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Cataflan', 'Remédio pra dor de garganta', 10.0, 15.0, 44);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Remédio 5', 'Remédio pra dores na barriga', 35.0, 50.0, 55);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Benegripe Genérico', 'Remédio pra gripe genérico', 9.0, 15.0, 66);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Dermatos Genérico', 'Remédio pra dores genérico', 50.0, 70.0, 77);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Vodol 50mg','Remédio para micose',21.20, 28.90, 30);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Vick' ,'Pastilha para garganta',11.50, 17.50, 80);
INSERT INTO Medicamento (nm_medicamento,ds_medicamento,vl_custo,vl_venda,qt_estoque) VALUES ('Doralgina','Remédio para dor de cabeça',9.90, 15, 10);

-- exibir as rotinas da base de dados
SELECT tgr.TRIGGER_SCHEMA, tgr.TRIGGER_NAME, tgr.EVENT_MANIPULATION, tgr.ACTION_STATEMENT, tgr.CREATED
FROM information_schema.`TRIGGERS` tgr
WHERE tgr.TRIGGER_SCHEMA = "base_testes_pl";

DESC cliente

-- criando tabela de logs
CREATE TABLE registro_logs (
	nm_tabela		VARCHAR(30),
	nm_campo		VARCHAR(30),
	vl_antigo		VARCHAR(100),
	vl_novo			VARCHAR(100),
	dt_alteracao	TIMESTAMP
);

-- criando trigger
DELIMITER $$
CREATE OR REPLACE TRIGGER tg_cliente_update_log
	AFTER UPDATE ON cliente
FOR EACH ROW
BEGIN
	-- verificando se houve alteração do nome
	IF OLD.nm_cliente <> NEW.nm_cliente THEN
		INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao)
		VALUES('cliente', 'nome', OLD.nm_cliente, NEW.nm_cliente, CURRENT_TIMESTAMP());
	END IF;
END $$

SELECT * FROM cliente;
-- testando execução da trigger por meio de um update na tabela
UPDATE cliente SET nm_cliente = 'Bruno Alves - alterado!'
WHERE cd_cliente = 2;

-- verificando o conteúdo da tabela "registro_logs"
SELECT * FROM registro_logs;

-- trigger cliente log completo
DELIMITER $$
CREATE OR REPLACE TRIGGER tg_cliente_update_log
	AFTER UPDATE ON cliente
FOR EACH ROW
BEGIN
	-- verificando se houve alteração do nome
	IF OLD.nm_cliente <> NEW.nm_cliente THEN
		INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao)
		VALUES('cliente', 'nm_cliente', OLD.nm_cliente, NEW.nm_cliente, CURRENT_TIMESTAMP());
	END IF;
	IF OLD.nr_telefone <> NEW.nr_telefone THEN
		INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao)
		VALUES('cliente', 'nr_telefone', OLD.nr_telefone, NEW.nr_telefone, CURRENT_TIMESTAMP());
	END IF;
	IF OLD.dt_nascimento <> NEW.dt_nascimento THEN
		INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao)
		VALUES('cliente', 'dt_nascimento', OLD.dt_nascimento, NEW.dt_nascimento, CURRENT_TIMESTAMP());
	END IF;
END $$

-- testando execução da trigger por meio de um update na tabela
UPDATE cliente SET dt_nascimento = '2000-01-01'
WHERE cd_cliente = 4;

UPDATE cliente SET nr_telefone = '(47) 98888-5555'
WHERE cd_cliente = 3;

-- verificando o conteúdo da tabela "registro_logs"
SELECT * FROM registro_logs;


-- criando trigger para insercao de novo registro
DELIMITER $$
CREATE OR REPLACE TRIGGER tg_cliente_insert_log
	AFTER INSERT ON cliente
FOR EACH ROW
BEGIN
	INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao)
	VALUES('cliente', 'nm_cliente', NULL, NEW.nm_cliente, CURRENT_TIMESTAMP());
END $$

-- testando execução da trigger por meio de um insert na tabela
INSERT INTO cliente (nm_cliente, nr_telefone, dt_nascimento)
VALUES ('Cliente novo', 'sem fone', '1990-04-07');

-- verificando o conteúdo da tabela "registro_logs"
SELECT *
FROM registro_logs;


-- criando trigger para delete de um registro
DELIMITER $$
CREATE OR REPLACE TRIGGER tg_cliente_delete_log
	AFTER DELETE ON cliente
FOR EACH ROW
BEGIN
	INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao)
	VALUES('cliente', 'nm_cliente', OLD.nm_cliente, NULL, CURRENT_TIMESTAMP());
END $$

-- testando execução da trigger por meio de um insert na tabela
DELETE FROM cliente
WHERE cd_cliente = 6;

-- verificando o conteúdo da tabela "registro_logs"
SELECT *
FROM registro_logs;


-- Alterando tabela e triggers para adicionar tipo de operacao
ALTER TABLE registro_logs      
ADD COLUMN tp_operacao CHAR(1);

DELIMITER $$
CREATE OR REPLACE TRIGGER tg_cliente_update_log
	AFTER UPDATE ON cliente
FOR EACH ROW
BEGIN
	-- verificando se houve alteração do nome
	IF OLD.nm_cliente <> NEW.nm_cliente THEN
		INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao, tp_operacao)
		VALUES('cliente', 'nm_cliente', OLD.nm_cliente, NEW.nm_cliente, CURRENT_TIMESTAMP(), 'U');
	END IF;
	IF OLD.nr_telefone <> NEW.nr_telefone THEN
		INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao, tp_operacao)
		VALUES('cliente', 'nr_telefone', OLD.nr_telefone, NEW.nr_telefone, CURRENT_TIMESTAMP(), 'U');
	END IF;
	IF OLD.dt_nascimento <> NEW.dt_nascimento THEN
		INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao, tp_operacao)
		VALUES('cliente', 'dt_nascimento', OLD.dt_nascimento, NEW.dt_nascimento, CURRENT_TIMESTAMP(), 'U');
	END IF;
END $$

DELIMITER $$
CREATE OR REPLACE TRIGGER tg_cliente_insert_log
	AFTER INSERT ON cliente
FOR EACH ROW
BEGIN
	INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao, tp_operacao)
	VALUES('cliente', 'nm_cliente', NULL, NEW.nm_cliente, CURRENT_TIMESTAMP(), 'I');
END $$

DELIMITER $$
CREATE OR REPLACE TRIGGER tg_cliente_delete_log
	AFTER DELETE ON cliente
FOR EACH ROW
BEGIN
	INSERT INTO registro_logs (nm_tabela, nm_campo, vl_antigo, vl_novo, dt_alteracao, tp_operacao)
	VALUES('cliente', 'nm_cliente', OLD.nm_cliente, NULL, CURRENT_TIMESTAMP(), 'D');
END $$

-- testando mudanças
INSERT INTO cliente (nm_cliente, nr_telefone, dt_nascimento)
VALUES ('Cliente novo', 'sem fone', '1990-04-07');

UPDATE cliente SET dt_nascimento = '2000-01-01'
WHERE cd_cliente = 7;

DELETE FROM cliente
WHERE cd_cliente = 7;

SELECT *
FROM registro_logs;


-- Criação de um trigger para atualizar o valor de estoque de medicamento quando ocorre uma venda (itemnotafiscal)
DELIMITER $$
CREATE TRIGGER tg_venda_medicamento AFTER INSERT
	ON itemnotafiscal FOR EACH ROW
BEGIN
	UPDATE medicamento SET qt_estoque = qt_estoque - NEW.qt_vendida
		WHERE cd_medicamento = NEW.cd_medicamento;
END $$

-- testando
-- Criando uma notafiscal
INSERT INTO notafiscal (cd_cliente, dt_emissao)
VALUES (1, CURDATE());

-- qt_estoque = 11
SELECT *
FROM medicamento
WHERE cd_medicamento = 1;
-- inserindo um medicamento na notafiscal = 1
INSERT INTO itemnotafiscal (nr_notafiscal, cd_medicamento, qt_vendida, vl_venda)
VALUES (1, 1, 1, 10); -- cliente=1, med=1(benegripe), qt=1, vl=10
-- verificando qt_estoque (10)
SELECT *
FROM medicamento
WHERE cd_medicamento = 1;

-- alterando a trigger para calcular vl_total
DELIMITER $$
CREATE OR REPLACE TRIGGER tg_venda_medicamento AFTER INSERT
	ON itemnotafiscal FOR EACH ROW
BEGIN
	UPDATE medicamento SET qt_estoque = qt_estoque - NEW.qt_vendida
		WHERE cd_medicamento = NEW.cd_medicamento;
	UPDATE notafiscal SET vl_total = vl_total + (NEW.vl_venda * NEW.qt_vendida)
		WHERE nr_notafiscal = NEW.nr_notafiscal;
END $$

DELETE FROM itemnotafiscal
WHERE nr_notafiscal = 1;

INSERT INTO itemnotafiscal (nr_notafiscal, cd_medicamento, qt_vendida, vl_venda)
VALUES (1, 1, 1, 10); -- cliente=1, med=1(benegripe), qt=1, vl=10
-- verificando medicamento -> qt_estoque (9)
SELECT *
FROM medicamento
WHERE cd_medicamento = 1;
-- verificando notafiscal -> vl_total (10,0)
SELECT *
FROM notafiscal;


INSERT INTO itemnotafiscal (nr_notafiscal, cd_medicamento, qt_vendida, vl_venda)
VALUES (1, 2, 2, 11); -- cliente=1, med=2(aspirina c), qt=2, vl=11
-- verificando medicamento -> qt_estoque (20)
SELECT *
FROM medicamento
WHERE cd_medicamento = 2;
-- verificando notafiscal -> vl_total (32,0)
SELECT *
FROM notafiscal;


-- criando trigger para buscar valor de venda do medicamento
DELIMITER $$
CREATE OR REPLACE TRIGGER tg_venda_medicamento_preco BEFORE INSERT
	ON itemnotafiscal FOR EACH ROW
BEGIN
	DECLARE var_vl_venda_medicamento DECIMAL(8,2) DEFAULT 0;
	SET var_vl_venda_medicamento = (SELECT vl_venda FROM medicamento WHERE cd_medicamento = NEW.cd_medicamento);
	SET NEW.vl_venda = var_vl_venda_medicamento;
END $$
-- OU
DELIMITER $$
CREATE OR REPLACE TRIGGER tg_venda_medicamento_preco BEFORE INSERT
	ON itemnotafiscal FOR EACH ROW
BEGIN
	DECLARE var_vl_venda_medicamento DECIMAL(8,2) DEFAULT 0;
	SELECT vl_venda INTO var_vl_venda_medicamento FROM medicamento WHERE cd_medicamento = NEW.cd_medicamento;
	SET NEW.vl_venda = var_vl_venda_medicamento;
END $$

-- verificando medicamento -> qt_estoque (33)
SELECT *
FROM medicamento
WHERE cd_medicamento = 3;

INSERT INTO itemnotafiscal (nr_notafiscal, cd_medicamento, qt_vendida)
VALUES (1, 3, 3);

-- verificando medicamento -> qt_estoque (30)
SELECT *
FROM medicamento
WHERE cd_medicamento = 3;
-- verificando notafiscal -> vl_total (122,0)
SELECT *
FROM notafiscal;


-- Trigger baixa de estoque
DELIMITER $$
CREATE OR REPLACE TRIGGER tg_venda_medicamento_preco BEFORE INSERT
	ON itemnotafiscal FOR EACH ROW
BEGIN
	DECLARE var_vl_venda_medicamento DECIMAL(8,2) DEFAULT 0.0;
	DECLARE var_qtde_estoque INT DEFAULT 0;
		
	SET var_vl_venda_medicamento = (SELECT vl_venda FROM medicamento WHERE cd_medicamento = NEW.cd_medicamento);
	SET NEW.vl_venda = var_vl_venda_medicamento;
	
	SET var_qtde_estoque = (SELECT qt_estoque FROM medicamento WHERE cd_medicamento - NEW.cd_medicamento);
	IF var_qtde_estoque < NEW.qt_vendida THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erro! Estoque insuficiente.';
	END IF;
END $$

-- teste
INSERT INTO itemnotafiscal (nr_notafiscal, cd_medicamento, qt_vendida)
VALUES (1, 1, 100);