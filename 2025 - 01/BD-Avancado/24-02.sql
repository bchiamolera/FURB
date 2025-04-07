-- atividade prática 24/02

-- criando tabela pessoa
CREATE TABLE pessoa (
cd_pessoa 		INT,
nm_pessoa 		VARCHAR(50),
dt_nascimento 	DATE,
sal 			DECIMAL(8,2),
PRIMARY KEY (cd_pessoa)
);
-- ou
CREATE TABLE pessoa (
cd_pessoa 		INT PRIMARY KEY,
nm_pessoa 		VARCHAR(50),
dt_nascimento 	DATE,
sal 			DECIMAL(8,2)
);

-- selecionando dados sobre as tabelas do db_tipos_dados
SELECT tabs.TABLE_SCHEMA, tabs.TABLE_NAME, tabs.TABLE_TYPE, tabs.`ENGINE`, tabs.`ROW_FORMAT`
FROM information_schema.`TABLES` tabs
WHERE tabs.TABLE_SCHEMA = "bd_tipos_tabelas";

-- selecionar dados sobre uma tabela específica
SELECT cols.TABLE_NAME, cols.COLUMN_NAME, cols.ORDINAL_POSITION, cols.COLUMN_DEFAULT, cols.IS_NULLABLE, cols.DATA_TYPE,
cols.NUMERIC_PRECISION, cols.COLUMN_TYPE
FROM information_schema.`COLUMNS` cols
WHERE cols.TABLE_NAME = "pessoa" AND cols.TABLE_SCHEMA = "bd_tipos_tabelas";

-- inserindo dados
INSERT INTO pessoa VALUES (1, "José", "1980-01-01", 500);
INSERT INTO pessoa VALUES (2, "Maria", "1985-10-10", 600);
SELECT * FROM pessoa;

-- criando tabela exemplo 2
CREATE TABLE projeto (
cd_projeto INT PRIMARY KEY,
nm_projeto CHAR(100),
cd_responsavel INT REFERENCES pessoa(cd_pessoa)
);

INSERT INTO projeto VALUES (1, "Projeto 1", 1);
SELECT * FROM projeto;

-- selects
SELECT prj.nm_projeto, p.nm_pessoa
FROM projeto prj, pessoa p
WHERE prj.cd_responsavel = p.cd_pessoa;
-- ou
SELECT prj.nm_projeto, p.nm_pessoa
FROM projeto prj
JOIN pessoa p ON (prj.cd_responsavel = p.cd_pessoa);

-- erro de inserção
INSERT INTO projeto VALUES (2, "Projeto 2", 3);

-- criando tabelas com outra engine (MyISAM)
CREATE TABLE pessoa_myisam (
cd_pessoa 		INT PRIMARY KEY,
nm_pessoa 		VARCHAR(50),
dt_nascimento 	DATE,
sal 			DECIMAL(8,2)
) ENGINE = MyISAM;
INSERT INTO pessoa_myisam VALUES (1, "José", "1980-01-01", 500);
INSERT INTO pessoa_myisam VALUES (2, "Maria", "1985-10-10", 600);

CREATE TABLE projeto_myisam (
cd_projeto INT PRIMARY KEY,
nm_projeto CHAR(100),
cd_responsavel INT REFERENCES pessoa(cd_pessoa)
) ENGINE = MyISAM;
INSERT INTO projeto_myisam VALUES (1, "Projeto 1", 1);
INSERT INTO projeto_myisam VALUES (2, "Projeto 2", 3);
-- MyISAM não verifica se FK existe

SELECT * FROM projeto_myisam;

SELECT prj.nm_projeto, p.nm_pessoa
FROM projeto_myisam prj
LEFT JOIN pessoa_myisam p ON (prj.cd_responsavel = p.cd_pessoa);

-- criando tabelas com engine MEMORY (Cria na memória temporariamente, some ao fechar o MariaDB)
CREATE TABLE pessoa_memory (
cd_pessoa 		INT PRIMARY KEY,
nm_pessoa 		VARCHAR(50),
dt_nascimento 	DATE,
sal 			DECIMAL(8,2)
) ENGINE = MEMORY;
INSERT INTO pessoa_memory VALUES (1, "José", "1980-01-01", 500);
INSERT INTO pessoa_memory VALUES (2, "Maria", "1985-10-10", 600);

CREATE TABLE projeto_memory (
cd_projeto INT PRIMARY KEY,
nm_projeto CHAR(100),
cd_responsavel INT REFERENCES pessoa(cd_pessoa)
) ENGINE = MEMORY;
INSERT INTO projeto_memory VALUES (1, "Projeto 1", 1);
INSERT INTO projeto_memory VALUES (2, "Projeto 2", 3);
-- também não verifica se FK existe

SELECT * FROM projeto_memory;

SELECT prj.nm_projeto, p.nm_pessoa
FROM projeto_memory prj
LEFT JOIN pessoa_memory p ON (prj.cd_responsavel = p.cd_pessoa);