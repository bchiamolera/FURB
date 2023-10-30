-- a)     Listar todos os dados dos modelos disponíveis ordenados pela descrição;
SELECT *
FROM modelo
ORDER BY ds_modelo;

-- b)     Listar a descrição de todas as marcas disponíveis;
SELECT ds_marca
FROM marca;

-- c)     Listar qual(is) proprietário(s) residem nos estados de "SC" ou "PR";
SELECT *
FROM proprietario
WHERE sg_uf = 'SC' OR sg_uf = 'PR';
-- WHERE sg_uf IN ('SC', 'PR');

-- d)     Listar qual(is) proprietário(s) não possuem e-mail, mas que possuem número de telefone cadastrado;
SELECT *
FROM proprietario
WHERE nr_telefone IS NOT NULL AND ds_email IS NULL;


-- e)     Listar qual(is) proprietário(s) apresentam "Silva" no nome;
SELECT *
FROM proprietario
WHERE nm_proprietario LIKE '%Silva%';


-- f)      Listar as informações do(s) veículo(s) que apresenta(m) ano de fabricação diferente do ano modelo;
SELECT *
FROM veiculo
WHERE nr_ano_fab <> nr_ano_mod;

-- g)     Listar o número da placa, o ano do modelo, a quantidade de km rodados e a quantidade de portas dos veículos fabricados após ano de 2000, inclusive ano 2000;
SELECT nr_placa, nr_ano_mod, qt_km_rodado, qt_portas
FROM veiculo
WHERE nr_ano_fab >= 2000;

-- h)     Listar o número da placa do(s) veículo(s) que não possui(em) uma informação adicional cadastrada (coluna observação);
SELECT nr_placa
FROM veiculo
WHERE ds_observacao IS NULL;

-- i)      Listar os dados do(s) veículo(s) que apresenta(m) quatro portas ou mais, ordenados pelo ano do modelo descendente;
SELECT *
FROM veiculo
WHERE qt_portas >= 4
ORDER BY nr_ano_mod DESC;

-- j)      Listar todos os acessórios ordenados pela descrição;
SELECT *
FROM acessorio
ORDER BY ds_acessorio;

-- k)     Listar o número da placa do veículo, ano de fabricação e modelo do(s) veículos fabricados a partir de 2015, com km rodada menor de 50000, com 4 portas ou mais e que não possui(am) observações;
SELECT nr_placa, nr_ano_fab, nr_ano_mod
FROM veiculo
WHERE nr_ano_fab >= 2015 AND qt_km_rodado < 50000 AND qt_portas >= 4 AND ds_observacao IS NULL;

-- l)      Listar o nome do(s) proprietário(s) que residem em um bairro em que o nome tenha a palavra "Novo" ou "Nova" e que a UF seja de "SC";
SELECT nm_proprietario
FROM proprietario
WHERE sg_uf = "SC" AND (ds_bairro LIKE "%Novo%" OR ds_bairro LIKE "%Nova%");