-- Criando tabela
CREATE TABLE tabela (
	coluna1 TIPO [restricao],
	coluna2 TIPO,
	...
	colunaN TIPO,
	[CONSTRAINT nome_restricao RESTRICAO(coluna)]
);

-- ALTERANDO TABELAS
ALTER TABLE tabela
MODIFY COLUMN coluna TIPO [RESTRICAO],
[DROP COLUMN col,
ADD CONSTRAINT nm_restricao RESTRICAO(coluna)
DROP CONSTRAINT nome_restricao,
DROP RESTRICAO];

-- DELETANDO TABELAS
DROP TABLE tabela;

-- RESTRIÇÕES
PRIMARY KEY (col)
FOREIGN KEY (col_dentro) REFERENCES (col_fora)
UNIQUE (col)
CHECK (col BETWEEN x AND y)
NOT NULL
DEFAULT vlr

-- ADICIONANDO LINHAS
INSERT INTO tabela [(col1, col2, ...)]
VALUES (vlr1, vlr2, vlr3, ...);

-- SELECT
SELECT [(col1, col2, ...)]
FROM tabela
[WHERE condicao];

-- ALTERANDO LINHAS
UPDATE tabela
SET col = vlr
[WHERE condicao];

-- DELETANDO LINHAS
DELETE FROM tabela
[WHERE coluna = condicao];

-- DELETAR TODOS OS DADOS;
TRUNCATE TABLE tabela;

-- COPIANDO UMA TABELA VAZIA (SEM RESTRICOES)
CREATE TABLE tabela2
AS
SELECT * FROM tabela
WHERE 1 = 0;
	
-- COPIANDO DADOS
INSERT INTO tabela2
SELECT * FROM tabela;

-- SELECTS CLAUSULAS
SELECT col [AS alias], col2 ["alias 2"]
FROM tabela
[WHERE col = val || UPPER/LOWER(col) LIKE "COND%" || col IN(vlr1, vlr2) || col LIKE '%vlr_' || col IS [NOT] NULL || col BETWEEN vlr1 AND vlr2]
[ORDER BY col/alias/posicaoColuna ASC/DESC,]
[GROUP BY ,]
[HAVING ];