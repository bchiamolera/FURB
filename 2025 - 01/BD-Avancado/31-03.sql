SELECT *
FROM pessoa;

DESC pessoa;

explain
SELECT *
FROM pessoa p
WHERE p.atividade LIKE 'Auxiliar%';

CREATE INDEX idx_pessoa_atividade ON pessoa(atividade);

explain
SELECT *
FROM pessoa p
WHERE p.atividade LIKE '%Auxiliar%';

-- Criando um índice fulltext
CREATE FULLTEXT INDEX idx_pessoa_fulltext ON pessoa(nome,escolaridade,atividade,email,logradouro,cidade,regiao,pais,alimentos);

-- exemplo utilizando o modelo de busca em linguagem natural (IN NATURAL LANGUAGE MODE)
SELECT *
FROM pessoa p
WHERE
	MATCH(nome,escolaridade,atividade,email,logradouro,cidade,regiao,pais,alimentos)
	AGAINST('Avenue Graduação Jordan');
	
-- exemplo utilizando o modelo de busca em linguagem booleana (IN BOOLEAN LANGUAGE MODE)
SELECT p.nome, p.atividade, p.escolaridade, p.alimentos
FROM pessoa p
WHERE
	MATCH(atividade,alimentos)
	AGAINST('auxiliar sobremesas' IN BOOLEAN MODE);
	
SELECT p.nome, p.atividade, p.escolaridade, p.alimentos
FROM pessoa p
WHERE
	MATCH(atividade,alimentos)
	AGAINST('auxiliar +sobremesas -gerente' IN BOOLEAN MODE);
	
-- 'pós' muito curto, irá descartar
SELECT p.nome, p.atividade, p.escolaridade, p.alimentos
FROM pessoa p
WHERE
	MATCH(escolaridade,atividade,alimentos)
	AGAINST('-gerente +sobremesas +pós' IN BOOLEAN MODE);
	
SELECT p.nome, p.atividade, p.escolaridade, p.alimentos
FROM pessoa p
WHERE
	MATCH(atividade,alimentos,nome)
	AGAINST('-gerente +sobremesas +mark' IN BOOLEAN MODE);

SELECT p.nome, p.atividade, p.escolaridade, p.alimentos
FROM pessoa p
WHERE
	MATCH(atividade,alimentos)
	AGAINST('-gerente +(sobremesas | tortas)' IN BOOLEAN MODE);
	
SELECT p.nome, p.atividade, p.escolaridade, p.alimentos
FROM pessoa p
WHERE
	MATCH(atividade,pais)
	AGAINST('-gerente +brasil' IN BOOLEAN MODE);
	
SELECT p.escolaridade, COUNT(p.id) AS total
FROM pessoa p
GROUP BY p.escolaridade;

CREATE INDEX idx_pessoa_escolaridade ON pessoa(escolaridade);

-- Normalizando o BD
-- Escolaridade
CREATE TABLE escolaridade(
id INT AUTO_INCREMENT,
ds_escolaridade VARCHAR(50),
PRIMARY KEY(id)
);

DESC escolaridade;

SELECT distinct p.escolaridade
FROM pessoas p;

INSERT INTO escolaridade(ds_escolaridade)
	SELECT DISTINCT p.escolaridade
	FROM pessoas p;
	
UPDATE pessoas
	SET escolaridade = (
		SELECT id_escolaridade
		FROM escolaridade
		WHERE pessoas.escolaridade = escolaridade.ds_escolaridade
	);
	
ALTER TABLE pessoas
MODIFY COLUMN escolaridade INT;

ALTER TABLE pessoas
	ADD CONSTRAINT pessoas_escolaridade_fk FOREIGN KEY(escolaridade)
		REFERENCES escolaridade(id);