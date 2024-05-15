-- a)     Listar a média de km rodados entre os veículos cadastrados;
SELECT AVG(qt_km_rodado) AS 'Média Km'
FROM Veiculo;

-- b)     Listar o ano de fabricação do(s) veículo(s) mais novo e ano de fabricação do(s) veículo(s) mais antigo cadastrado na base de dados;
SELECT MIN(nr_ano_fab) AS 'Mais Antigo', MAX(nr_ano_fab) AS 'Mais Novo'
FROM Veiculo;

-- c)     Listar o ano modelo do veículo com a respectiva quantidade de veículos correspondente ao ano listado;
SELECT nr_ano_mod 'Ano Modelo', COUNT(nr_ano_mod) AS 'Qtd Veiculo'
FROM Veiculo v
GROUP BY nr_ano_mod;

-- d)     Listar a descrição do combustível com a respectiva quantidade de veículos que apresentam o combustível, ordenando pelo maior número de veículos descendente;
SELECT c.ds_combustivel Combustivel, COUNT(v.nr_placa) AS 'Qtd Veiculo'
FROM Veiculo v
JOIN Veiculo_Combustivel vc ON v.nr_placa = vc.nr_placa
JOIN Combustivel c ON c.cd_combustivel = vc.cd_combustivel
GROUP BY c.ds_combustivel
ORDER BY COUNT(c.ds_combustivel) DESC;

-- e)     Listar a descrição do modelo com a respectiva quantidade de veículo(s) correspondente ao modelo listado;
SELECT m.ds_modelo Modelo, COUNT(m.ds_modelo) AS 'Qtd Modelo'
FROM Veiculo v
JOIN Modelo m ON v.cd_modelo = m.cd_modelo
GROUP BY m.ds_modelo;

-- f)      Listar todas as marcas (descrição) disponíveis com o respectivo modelo (descrição), bem como a quantidade de veículo associada a marca e modelo listado;
SELECT ma.ds_marca Marca, mo.ds_modelo Modelo, COUNT(v.nr_placa) AS 'Qtd Veículos'
FROM Marca ma
JOIN Modelo mo ON mo.cd_marca = ma.cd_marca
JOIN Veiculo v ON v.cd_modelo = mo.cd_modelo
GROUP BY ma.ds_marca, mo.ds_modelo;

-- g)     Listar a descrição do acessório com a respectiva quantidade de veículo que possuem o referido acessório listado.
SELECT a.ds_acessorio Acessorio, COUNT(v.nr_placa) AS 'Qtd Veículos'
FROM Acessorio a
JOIN Veiculo_Acessorio va ON va.cd_acessorio = a.cd_acessorio
JOIN Veiculo v ON v.nr_placa = va.nr_placa
GROUP BY a.ds_acessorio;

-- h)     Listar o nome da localidade com a respectiva quantidade de proprietários vinculado(s) a cada localidade, restringindo ao estado de "SC";
SELECT l.nm_localidade Localidade, COUNT(p.cd_proprietario) AS 'Qtd Proprietários'
FROM Localidade l
JOIN Proprietario p ON p.cd_localidade = l.cd_localidade
WHERE p.sg_uf = 'SC'
GROUP BY l.nm_localidade;

-- i)      Listar dados dos veículos: placa, descrição da marca, descrição do modelo e quantidade de acessórios associado a cada veículo listado, sendo que os veículos devem apresentar dois ou mais acessórios.
SELECT v.nr_placa Placa, ma.ds_marca Marca, mo.ds_modelo Modelo, COUNT(a.cd_acessorio) AS 'Qtd Acessório'
FROM Veiculo v
JOIN Modelo mo ON v.cd_modelo = mo.cd_modelo
JOIN Marca ma ON mo.cd_marca = ma.cd_marca
JOIN Veiculo_Acessorio va ON v.nr_placa = va.nr_placa
JOIN Acessorio a ON va.cd_acessorio = a.cd_acessorio
GROUP BY v.nr_placa
HAVING COUNT(va.cd_acessorio) >= 2;

-- j)     Listar dados dos veículos: placa, descrição da marca, descrição do modelo e quantidade de combustíveis associados a cada veículo listado.
SELECT v.nr_placa Placa, ma.ds_marca Marca, mo.ds_modelo Modelo, COUNT(c.cd_combustivel) AS 'Qtd Combustivel'
FROM Veiculo v
JOIN Modelo mo ON v.cd_modelo = mo.cd_modelo
JOIN Marca ma ON mo.cd_marca = ma.cd_marca
JOIN Veiculo_Combustivel vc ON v.nr_placa = vc.nr_placa
JOIN Combustivel c ON c.cd_combustivel = vc.cd_combustivel
GROUP BY v.nr_placa;