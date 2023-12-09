-- Buscar atores que não estão em nenhum filme
SELECT a.cd_ator, a.nm_ator
FROM ator a
WHERE a.cd_ator NOT IN (SELECT fa.cd_ator
						FROM filme_ator fa);

-- listar filmes lançados após o filme 2
SELECT *
FROM filme f
WHERE f.dt_lancamento > (SELECT f.dt_lancamento
						 FROM filme f
						 WHERE f.cd_filme = 2);

-- listar filmes lançados após filmes que começam com H
SELECT *
FROM filme f
WHERE f.dt_lancamento > ANY (SELECT f.dt_lancamento
							 FROM filme f
							 WHERE f.nm_filme LIKE "H%");

-- listar filmes lançados após TODOS os filmes que começam com H
SELECT *
FROM filme f
WHERE f.dt_lancamento > ALL (SELECT f.dt_lancamento
							 FROM filme f
							 WHERE f.nm_filme LIKE "H%");

-- Listar infos do fjlme mais atual						 
SELECT *
FROM filme f
WHERE f.dt_lancamento IN (SELECT MAX(f.dt_lancamento)
						  FROM filme f);