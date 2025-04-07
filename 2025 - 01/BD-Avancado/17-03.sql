-- listar todos os produtos e as quantidades vendidas de cada produto no ano de 2024
SELECT p.nm_produto, SUM(i.qt_produto) AS 'qtde_vendida'
FROM produto p
JOIN item_nota_fiscal i
	ON p.cd_produto = i.cd_produto
JOIN nota_fiscal nf
	ON i.nr_notal_fiscal = nf.nr_notal_fiscal
WHERE nf.dt_emissao BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY p.nm_produto
ORDER BY 2 DESC;

EXPLAIN -- excibe o plano de execução do comando (internamente)
SELECT p.nm_produto, SUM(i.qt_produto) AS 'qtde_vendida'
FROM produto p
JOIN item_nota_fiscal i
	ON p.cd_produto = i.cd_produto
JOIN nota_fiscal nf
	ON i.nr_notal_fiscal = nf.nr_notal_fiscal
WHERE nf.dt_emissao BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY p.nm_produto
ORDER BY 2 DESC;

-- criando um indice para a data de emissão (dt_emissao) na nota_fiscal
CREATE INDEX idx_nota_fiscal_dt_emissao ON nota_fiscal(dt_emissao);
-- cuidado com o tamanho do nome, pois o limite é 30 caracteres


-- criando um indice para o nome do animal
EXPLAIN
SELECT *
FROM animal
WHERE nm_animal = "Rex";

CREATE INDEX idx_animal_nm_animal ON animal(nm_animal);

EXPLAIN
SELECT *
FROM animal
WHERE nm_animal = "R%";

-- eliminando um índice criado (ex.: idx_animal_nm_animal tab: animal)
DROP INDEX idx_animal_nm_animal ON animal;

EXPLAIN
SELECT *
FROM animal
WHERE nm_animal = "R%";


-- criando um indíce indiretamente
ALTER TABLE produto
ADD CONSTRAINT UNIQUE KEY(nm_produto);

EXPLAIN
SELECT *
FROM produto
WHERE nm_produto LIKE "Ração%"