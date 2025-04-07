-- atividade prática 10/03

-- inserindo dados tabela memória
INSERT INTO pessoa_memory VALUES (1, "Pessoa 1", "1980-01-01", 500);
INSERT INTO pessoa_memory VALUES (2, "Pessoa 2", "1985-10-10", 600);
INSERT INTO pessoa_memory VALUES (3, "Pessoa 3", "1980-01-01", 500);
INSERT INTO pessoa_memory VALUES (4, "Pessoa 4", "1985-10-10", 600);
INSERT INTO pessoa_memory VALUES (5, "Pessoa 5", "1980-01-01", 500);

-- criando tabela tipo CSV
-- NAO ACEITA PK, TODOS OS CAMPOS PRECISVAM SER NOT NULL
CREATE TABLE pessoa_csv (
cd_pessoa INT NOT NULL,
nm_pessoa VARCHAR(50) NOT NULL,
ds_email VARCHAR(40) NOT NULL
) ENGINE = CSV;

INSERT INTO pessoa_csv VALUES (1, "Pessoa 1", "pessoa1@email.com");
INSERT INTO pessoa_csv VALUES (2, "Pessoa 2", "pessoa2@email.com");
INSERT INTO pessoa_csv VALUES (3, "Pessoa 3", "pessoa3@email.com");
INSERT INTO pessoa_csv VALUES (4, "Pessoa 4", "pessoa4@email.com");
INSERT INTO pessoa_csv VALUES (5, "Pessoa 5", "pessoa5@email.com");

SELECT * FROM pessoa_csv;

-- VIEWS
-- Atividade prática petshop

-- Selecione os nomes dos clientes e os respectivos nomes dos animais cadastrados
SELECT cli.nm_cliente, pet.nm_animal
FROM cliente cli, animal pet
WHERE cli.cd_cliente = pet.cd_cliente;
-- OU
SELECT cli.nm_cliente, pet.nm_animal
FROM animal pet
JOIN cliente cli ON (pet.cd_cliente = cli.cd_cliente);

-- Criando tabela através de um SELECT
CREATE TABLE cliente_animal_exp
AS
	SELECT cli.nm_cliente, pet.nm_animal
	FROM animal pet
	JOIN cliente cli ON (pet.cd_cliente = cli.cd_cliente);
	
ALTER TABLE cliente_animal_exp
	ENGINE = CSV;
	
DESC cliente_animal_exp;

-- Criando uma VIEW
CREATE VIEW vw_cliente_com_animal
AS
	SELECT cli.nm_cliente, pet.nm_animal
	FROM animal pet
	JOIN cliente cli ON (pet.cd_cliente = cli.cd_cliente);
	
DESC vw_cliente_com_animal;

SELECT vw.TABLE_NAME, vw.VIEW_DEFINITION
FROM information_schema.VIEWS vw
WHERE vw.TABLE_SCHEMA = 'bd_petshop';

-- Visualizando uma VIEW
SELECT * FROM vw_cliente_com_animal;

-- Alterando uma VIEW (adicionando apelidos)
CREATE OR REPLACE VIEW vw_cliente_com_animal (dono,nome_do_pet)
AS
	SELECT cli.nm_cliente, pet.nm_animal
	FROM animal pet
	JOIN cliente cli ON (pet.cd_cliente = cli.cd_cliente);
	
-- Criar uma view para calcular e listar o valor total de vendas
-- para cada cliente em notas fiscais
CREATE VIEW vw_total_vendas_cliente
AS
	SELECT cli.nm_cliente, SUM(nf.vl_total) AS total_vendas
	FROM nota_fiscal nf
	JOIN cliente cli ON (nf.cd_cliente = cli.cd_cliente)
	GROUP BY cli.nm_cliente
	
SELECT * FROM vw_total_vendas_cliente
ORDER BY 1;

EXPLAIN
SELECT * FROM vw_cliente_com_animal;