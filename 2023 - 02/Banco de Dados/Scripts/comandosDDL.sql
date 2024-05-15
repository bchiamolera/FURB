-- Criando uma tabela
CREATE TABLE pessoa (
	cd_pessoa INT,
	nm_pessoa VARCHAR(10),
	ds_email VARCHAR(50)
);

-- Inserindo dados
INSERT INTO pessoa VALUES (1, 'Pessoa 1', 'p1@email.com');

-- Modificando coluna
MODIFY COLUMN nm_pessoa VARCHAR(20);

-- Inserindo dados
INSERT INTO pessoa VALUES (3, 'Pessoa 3 sobrenome', 'p3@email.com');
-- Comandos DDL --

-- Adicionando coluna
ALTER TABLE pessoa
	ADD COLUMN dt_nascimento DATE;

-- Inserindo dados
INSERT INTO pessoa VALUES (4, 'Pessoa 4', 'p4@email.com', '2023/10/16');

-- Removendo coluna
ALTER TABLE pessoa
	DROP COLUMN ds_email;

-- Atualizando dados
UPDATE pessoa
	SET dt_nascimento = '2023/01/01'
	WHERE cd_pessoa = 1;
UPDATE pessoa
	SET dt_nascimento = '2023/02/01'
	WHERE cd_pessoa = 3;
	
-- Alterando estrutura de uma tabela para adicionar valor DEFAULT
ALTER TABLE pessoa
	MODIFY COLUMN nm_pessoa VARCHAR(20) DEFAULT 'Sem nome';
	
-- Inserindo dados
INSERT INTO pessoa (cd_pessoa, dt_nascimento) VALUES (5, '2023/03/01');

-- Mostrando estrutura da tabela
DESC pessoa;

-- Mostrando dados da tabela
SELECT * FROM pessoa;

-- Limpando a tabela
TRUNCATE TABLE pessoa;

-- eliminando tabela
DROP TABLE pessoa;