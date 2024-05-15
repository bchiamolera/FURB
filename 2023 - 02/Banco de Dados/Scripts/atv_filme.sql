-- Criando tabelas
CREATE TABLE Censura (
	cd_censura INT PRIMARY KEY,
	ds_censura VARCHAR(30)
);

CREATE TABLE Genero (
	cd_genero INT PRIMARY KEY,
	ds_genero VARCHAR(30)
);

CREATE TABLE Ator (
	cd_ator INT PRIMARY KEY,
	nm_ator VARCHAR(50) UNIQUE
);

CREATE TABLE Filme (
	cd_filme INT PRIMARY KEY,
	cd_censura INT REFERENCES Censura(cd_censura),
	cd_genero INT REFERENCES Genero(cd_genero),
	nm_filme VARCHAR(50) UNIQUE,
	ds_sinopse VARCHAR(250),
	nr_duracao VARCHAR(20),
	dt_lancamento DATE,
	fl_dublado char(1)
);

CREATE TABLE Filme_Ator (
	cd_filme INT  REFERENCES Filme(cd_filme),
	cd_ator INT REFERENCES Ator(cd_ator),
	ON DELETE CASCADE
);


-- Povoando tabelas
INSERT INTO Censura
VALUES (1, "Livre"),
(2, "12 anos"),
(3, "18 anos");

INSERT INTO Genero
VALUES (1, "Comédia"),
(2, "Terror"),
(3, "Ação");

INSERT INTO Ator
VALUES (1, "Didi"),
(2, "Xuxa"),
(3, "Chris Evans"),
(4, "Robert Downey Jr"),
(5, "Jamie Lee Curtis");

INSERT INTO Filme
VALUES (1, 3, 2, "Halloween", "Um perigoso assassino foge do hospício onde era mantido, retornando ao bairro onde matou sua família quando criança. Lá ele passa a observar e perseguir os jovens moradores da rua, em especial a bela Laurie.", "91 min", "1978-10-25", 'N'),
(2, 2, 3, "Homem de Ferro", "Tony Stark é um industrial bilionário, e também um brilhante inventor. Ao ser sequestrado ele é obrigado por terroristas a construir uma arma devastadora mas, constrói uma armadura que permite que fuja. Então ele passa a usá-la para combater o crime.", "126 min", "2008-04-14", 'N'),
(3, 2, 3, "Vingadores", "O filme conta a história da equipe de super heróis idealizada e reunida por Nick Fury, agente da SHIELD. O time, formado por Homem de Ferro, Capitão América, Thor, Gavião Arqueiro, Hulk e Viúva Negra, é formada com o objetivo de deter Loki.", "143 min", "2012-04-27",'S'),
(4, 1, 1, "A Princesa Xuxa e os Trapalhões", "No planeta Antar, o diabólico Ratan toma o poder depois da morte do imperador, capturando as crianças. Dentro do palácio, a Princesa pensa que todos são felizes. Do lado de fora, os 3 príncipes se unem ao Cavaleiro Sem Nome para combater Ratan.", "112 min", "1989-06-22", 'S'),
(5, 1, 1, "Didi, o Caçador de Tesouros", "Didi é o mordomo do pai de Pedro. Ao achar um mapa entre duas folhas de um álbum de fotos, eles partem para um misterioso hotel abandonado, onde existem pistas sobre a história do avô de Pedro, que morreu no fim da Segunda Grande Guerra.", "85 min", "2006-01-06", 'S');

INSERT INTO Filme_Ator
VALUES (1, 5),
(2, 4),
(3, 3),
(3, 4),
(4, 1),
(4, 2),
(5, 1);


-- SELECTS
SELECT nm_filme, ds_sinopse, nr_duracao
FROM Filme
WHERE dt_lancamento >= "2022-01-01" AND dt_lancamento <= "2022-12-31";

SELECT nm_filme
FROM Filme
WHERE dt_lancamento IS NULL AND fl_dublado IS NOT NULL;


-- UPDATE
UPDATE Filme
SET fl_dublado = 'N'
WHERE nr_duracao IS NULL;


-- DELETE
DELETE FROM Filme
WHERE ds_sinopse IS NULL;

-- --------------------------------------------------------------------
-- --------------------------------------------------------------------

-- OUTROS EXEMPLOS AULA
-- Listar nome do filme e descrição da censura
SELECT f.nm_filme, c.ds_censura
FROM filme f
	JOIN censura c ON f.cd_censura = c.cd_censura;

-- --------------------------------------------------------------------

SELECT * FROM censura;

INSERT INTO censura (cd_censura, ds_censura) VALUES (4, "16 anos");

SELECT f.nm_filme, c.ds_censura
FROM filme f
	LEFT JOIN censura c ON f.cd_censura = c.cd_censura;

SELECT f.nm_filme, c.ds_censura
FROM filme f
	RIGHT JOIN censura c ON f.cd_censura = c.cd_censura;

-- --------------------------------------------------------------------

-- Listar nome do filme, descrição da censura e descrição do gênero
SELECT f.nm_filme, c.ds_censura, g.ds_genero
FROM filme f, censura c, genero g
WHERE f.cd_censura = c.cd_censura AND f.cd_genero = g.cd_genero;

SELECT f.nm_filme, c.ds_censura, g.ds_genero
FROM filme f
	JOIN censura c ON f.cd_censura = c.cd_censura
	JOIN genero g ON f.cd_genero = g.cd_genero;

-- --------------------------------------------------------------------

-- Com filtro
SELECT f.nm_filme, c.ds_censura, g.ds_genero
FROM filme f
	JOIN censura c ON f.cd_censura = c.cd_censura
	JOIN genero g ON f.cd_genero = g.cd_genero
WHERE f.dt_lancamento BETWEEN '2001-01-01' AND '2010-12-31';

-- Com filtro
SELECT f.nm_filme, c.ds_censura, g.ds_genero
FROM filme f
	JOIN censura c ON f.cd_censura = c.cd_censura
	JOIN genero g ON f.cd_genero = g.cd_genero
WHERE f.dt_lancamento BETWEEN '2001-01-01' AND '2010-12-31'
	AND g.ds_genero = "Comédia";
	
-- --------------------------------------------------------------------

-- Mostrar também atores e atrizes
SELECT f.nm_filme, c.ds_censura, g.ds_genero, a.nm_ator
FROM filme f
	JOIN censura c ON f.cd_censura = c.cd_censura
	JOIN genero g ON f.cd_genero = g.cd_genero
	JOIN filme_ator fa ON f.cd_filme = fa.cd_filme
	JOIN ator a ON fa.cd_ator = a.cd_ator;

SELECT f.nm_filme, c.ds_censura, g.ds_genero, a.nm_ator
FROM filme f
	JOIN censura c ON f.cd_censura = c.cd_censura
	JOIN genero g ON f.cd_genero = g.cd_genero
	JOIN filme_ator fa ON f.cd_filme = fa.cd_filme
	JOIN ator a ON fa.cd_ator = a.cd_ator
WHERE a.nm_ator = "Didi";