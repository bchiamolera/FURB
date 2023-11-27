-- listar quantos filmes há na base
SELECT COUNT(*), COUNT(fl_dublado)
FROM filme;

-- listar filmes
SELECT *
FROM filme;

-- alterando "NULL" para o filme cd = 4
UPDATE filme
SET fl_dublado = NULL
WHERE cd_filme = 4;

-- listar quantos atores cada filme possui
SELECT f.nm_filme, COUNT(fa.cd_ator)
FROM filme f
JOIN filme_ator fa ON fa.cd_filme = f.cd_filme
GROUP BY f.nm_filme
ORDER BY 2 DESC;

-- listar filmes com mais de um ator
SELECT f.nm_filme, COUNT(*) AS qtd_atores
FROM filme f
JOIN filme_ator fa ON fa.cd_filme = f.cd_filme
GROUP BY f.nm_filme
HAVING COUNT(*) > 1
ORDER BY 2 DESC;

-- contar, somar e tirar a média dos códigos dos filmes
SELECT COUNT(f.cd_filme), SUM(f.cd_filme), AVG(f.cd_filme)
FROM filme f;

-- exemplo usando MIN() e MAX()
SELECT MIN(f.dt_lancamento), MAX(f.dt_lancamento), MIN(f.nm_filme), MAX(f.cd_genero)
FROM filme f;

-- contar qtd de filmes pra cada censura
SELECT c.ds_censura, COUNT(*) AS qtd_filmes
FROM filme f
JOIN censura c ON c.cd_censura = f.cd_censura
GROUP BY f.cd_censura
ORDER BY 2 DESC;

-- contar qtd de filmes pra cada gênero
SELECT g.ds_genero, COUNT(*) AS qtd_filmes
FROM filme f
JOIN genero g ON g.cd_genero = f.cd_genero
GROUP BY f.cd_censura
ORDER BY 2 DESC;

-- listar qtd de filmes pra cada ator
SELECT a.nm_ator, COUNT(*) AS qtd_filmes
FROM filme f
JOIN filme_ator fa ON fa.cd_filme = f.cd_filme
JOIN ator a ON a.cd_ator = fa.cd_ator
GROUP BY a.cd_ator
ORDER BY 2 DESC;