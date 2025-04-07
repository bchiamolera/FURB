-- criando INDEXES
CREATE INDEX idx_localidade_nr_cep ON localidade(nr_cep);
CREATE INDEX idx_localidade_cd_localidade_sub ON localidade(cd_localidade_sub);

CREATE INDEX idx_logradouro_nr_cep ON logradouro(nr_cep);
CREATE INDEX idx_logradouro_cd_localidade ON logradouro(cd_localidade);
CREATE INDEX idx_logradouro_cd_bairro_inicio ON logradouro(cd_bairro_inicio);
CREATE INDEX idx_localidade_cd_bairro_fim ON logradouro(cd_bairro_fim);

CREATE INDEX idx_grande_usuario_nr_cep ON grande_usuario(nr_cep);
CREATE INDEX idx_grande_usuario_cd_logradouro ON grande_usuario(cd_logradouro);
CREATE INDEX idx_grande_usuario_cd_bairro ON grande_usuario(cd_bairro);
CREATE INDEX idx_grande_usuario_cd_localidade ON grande_usuario(cd_localidade);

-- a)
SELECT l.sg_uf AS UF, COUNT(*) AS qtd_cidades 
FROM localidade l
WHERE l.fl_tipo_localidade='M'
GROUP BY l.sg_uf;

-- b)
SELECT l.sg_uf AS UF, COUNT(*) AS qtd_cidades 
FROM localidade l
WHERE l.fl_tipo_localidade='M'
GROUP BY l.sg_uf
HAVING COUNT(l.fl_tipo_localidade='M') < 100
ORDER BY 2 ASC;

-- c)
SELECT l.nm_localidade, l.sg_uf AS UF, COUNT(*) AS qtd_ceps 
FROM localidade l
JOIN logradouro lg ON lg.cd_localidade = l.cd_localidade
WHERE l.fl_tipo_localidade='M'
GROUP BY l.cd_localidade
ORDER BY 3 DESC;

-- d)
SELECT lg.nm_logradouro AS logradouro, COUNT(*) AS nr_municipios
FROM localidade l
JOIN logradouro lg ON lg.cd_localidade = l.cd_localidade
WHERE l.fl_tipo_localidade='M'
GROUP BY lg.nm_logradouro
ORDER BY 2 DESC;

-- e)
SELECT l.nm_localidade AS localidade, l.sg_uf AS UF, l.fl_tipo_localidade AS tipo, COUNT(*) AS qtd_cep_especiais
FROM localidade l
JOIN grande_usuario u ON u.cd_localidade = l.cd_localidade
GROUP BY l.cd_localidade
ORDER BY 4 DESC;

-- f)
SELECT d.nm_localidade AS distrito, m.nm_localidade AS municipio
FROM localidade d
JOIN localidade m ON m.cd_localidade = d.cd_localidade_sub
WHERE d.fl_tipo_localidade = 'D'
AND d.sg_uf = 'SC';

-- g)
SELECT b.nm_bairro AS bairro, COUNT(lg.cd_logradouro)
FROM bairro b
JOIN logradouro lg ON lg.cd_bairro_inicio = b.cd_bairro
JOIN localidade l ON lg.cd_localidade = l.cd_localidade
WHERE l.nm_localidade LIKE "Florianópolis"
AND l.sg_uf = 'SC'
GROUP BY b.nm_bairro;

-- h)
SELECT m.nm_localidade AS municipio, m.sg_uf AS UF, COUNT(*) AS qtd_distritos
FROM localidade m
JOIN localidade d ON d.cd_localidade_sub = m.cd_localidade
WHERE d.fl_tipo_localidade = 'D'
GROUP BY m.cd_localidade
ORDER BY 3 DESC;

-- i)
SELECT l.nm_localidade, COUNT(*) AS qtd_UF
FROM localidade l
WHERE l.fl_tipo_localidade='M'
GROUP BY l.nm_localidade
HAVING COUNT(*) > 1
ORDER BY 2 DESC;

-- j)
SELECT b.nm_bairro AS bairro, COUNT(*) AS qtd_cep
FROM bairro b
JOIN logradouro lg ON lg.cd_bairro_inicio = b.cd_bairro
JOIN localidade l ON lg.cd_localidade = l.cd_localidade
WHERE l.nm_localidade LIKE "Blumenau"
AND l.sg_uf = 'SC'
GROUP BY b.nm_bairro
ORDER BY 2 DESC;

-- k)
CREATE VIEW vw_municipios_ceps
AS
	SELECT l.nm_localidade AS municipio, l.sg_uf AS UF, COUNT(*) AS qtd_CEPs
	FROM localidade l
	JOIN logradouro lg ON l.cd_localidade = lg.cd_localidade
	WHERE l.fl_tipo_localidade = 'M'
	GROUP BY l.cd_localidade, l.sg_uf;

-- l)
CREATE VIEW vw_municipios_qtd_bairros
AS
	SELECT l.nm_localidade, COUNT(DISTINCT lg.cd_bairro_inicio)
	FROM localidade l, logradouro lg
	WHERE lg.cd_localidade = l.cd_localidade
		AND l.fl_tipo_localidade = 'M'
	GROUP BY l.nm_localidade
	ORDER BY 2 DESC;

-- m)
CREATE VIEW vw_localidade_praca
AS
	SELECT p.nm_localidade AS praca, m.nm_localidade AS municipio, m.sg_uf AS UF, p.nr_cep AS CEP
	FROM localidade p
	JOIN localidade m ON p.cd_localidade_sub = m.cd_localidade
	WHERE p.fl_tipo_localidade = 'P'
	ORDER BY UF, praca;

-- n)
CREATE VIEW vw_grande_usuario_completo
AS
	SELECT u.nm_grande_usuario AS nome, lg.nm_logradouro_comp AS logradouro, b.nm_bairro AS bairro, l.nm_localidade_comp AS localidade, l.sg_uf AS UF, u.nr_cep AS CEP
	FROM grande_usuario u
	LEFT JOIN logradouro lg ON u.cd_logradouro = lg.cd_logradouro
	LEFT JOIN localidade l ON lg.cd_localidade = l.cd_localidade
	LEFT JOIN bairro b ON lg.cd_bairro_inicio = b.cd_bairro
	ORDER BY nome;

-- o)
CREATE OR VIEW vw_todos_ceps
AS
	SELECT lg.nr_cep, lg.tp_logradouro, lg.nm_logradouro, b.nm_bairro, l.nm_localidade, l.sg_uf
	FROM logradouro lg
	JOIN localidade l ON (lg.cd_localidade = l.cd_localidade)
	JOIN bairro b ON (lg.cd_bairro_inicio = b.cd_bairro)
	UNION ALL
	SELECT u.nr_cep, lg.tp_logradouro, lg.nm_logradouro, b.nm_bairro, l.nm_localidade, u.sg_uf
	FROM grande_usuario u
	JOIN localidade l ON (u.cd_localidade = l.cd_localidade)
	JOIN bairro b ON (u.cd_bairro = b.cd_bairro)
	JOIN logradouro lg ON (lg.cd_logradouro = u.cd_logradouro)
	UNION ALL
	SELECT l.nr_cep, NULL, NULL, NULL, l.nm_localidade, l.sg_uf
	FROM localidade l
	WHERE l.nr_cep IS NOT NULL;