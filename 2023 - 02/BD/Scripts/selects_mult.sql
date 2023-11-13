-- a) Listar os nomes dos proprietários com a respectiva localidade (nome) em que residem;
SELECT p.nm_proprietario, l.nm_localidade
FROM proprietario p, localidade l
WHERE p.cd_localidade = l.cd_localidade;

-- b) Listar todos os modelos da marca "FIAT" ordenados pelo descrição do modelo;
SELECT ds_modelo
FROM modelo mo, marca ma
WHERE mo.cd_marca = ma.cd_marca AND ma.ds_marca = "FIAT"
ORDER BY mo.ds_modelo;

-- c) Listar todas as marcas (descrição) disponíveis com o respetivo modelo (descrição), em ordem crescente de marca, seguida de modelo;
SELECT ma.ds_marca, mo.ds_modelo
FROM marca ma, modelo mo
WHERE ma.cd_marca = mo.cd_marca
ORDER BY ma.ds_marca ASC, mo.ds_modelo ASC;

-- d) Listar a placa, o ano modelo e a descrição da cor de todos os veículos cadastrados, ordenando pelo ano modelo, seguido da descrição da cor;
SELECT v.nr_placa, v.nr_ano_mod, c.ds_cor
FROM veiculo v, cor c
WHERE v.cd_cor = c.cd_cor
ORDER BY v.nr_ano_mod, c.ds_cor;

-- e) Listar os seguintes dados do veículo: placa, nome do proprietário e nome da localidade que o mesmo reside, desde que sua UF seja "SC";
SELECT v.nr_placa, p.nm_proprietario, l.nm_localidade
FROM veiculo v, proprietario p, localidade l
WHERE v.cd_proprietario = p.cd_proprietario AND p.cd_localidade = l.cd_localidade AND p.sg_uf = 'SC';

-- f)  Listar os dados dos veículos com placa, descrição da marca, descrição do modelo, ano do modelo e a(s) respectiva(s) descrição(ões) do(s) combustível(is) que é movido;
SELECT v.nr_placa, ma.ds_marca, mo.ds_modelo, v.nr_ano_mod, c.ds_combustivel
FROM veiculo v, marca ma, modelo mo, combustivel c, veiculo_combustivel vc
WHERE v.cd_modelo = mo.cd_modelo AND mo.cd_marca = ma.cd_marca AND (vc.nr_placa = v.nr_placa AND vc.cd_combustivel = c.cd_combustivel);

-- g) Listar os veículos (com placa, descrição da marca, descrição do modelo) que possuem como acessório "Direção hidráulica";
SELECT v.nr_placa, mo.ds_modelo, ma.ds_marca
FROM veiculo v
JOIN veiculo_acessorio va ON v.nr_placa = va.nr_placa
JOIN acessorio a ON va.cd_acessorio = a.cd_acessorio
JOIN modelo mo ON v.cd_modelo = mo.cd_modelo
JOIN marca ma ON mo.cd_marca = ma.cd_marca
WHERE a.ds_acessorio = "Direção hidráulica";

-- h) Listar dados completos dos veículos: placa, descrição da marca, descrição do modelo, descrição da cor, ano modelo, ano fabricação, quantidade de km rodado, quantidade de portas, descrição dos acessórios e descrição do combustível que o move.
SELECT v.nr_placa, ma.ds_marca, mo.ds_modelo, c.ds_cor, v.nr_ano_mod, v.nr_ano_fab, v.qt_km_rodado, v.qt_portas, v.ds_observacao, a.ds_acessorio, co.ds_combustivel
FROM veiculo v
JOIN cor c ON v.cd_cor = c.cd_cor
JOIN veiculo_acessorio va ON v.nr_placa = va.nr_placa
JOIN acessorio a ON va.cd_acessorio = a.cd_acessorio
JOIN modelo mo ON v.cd_modelo = mo.cd_modelo
JOIN marca ma ON mo.cd_marca = ma.cd_marca
JOIN veiculo_combustivel vc ON v.nr_placa = vc.nr_placa
JOIN combustivel co ON vc.cd_combustivel = co.cd_combustivel;