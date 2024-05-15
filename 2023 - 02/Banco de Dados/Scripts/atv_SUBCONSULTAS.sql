-- a)     Listar a descrição da(s) cor(es) cadastrada(s) na base e que não apresenta nenhum veículo cadastrado;
SELECT c.ds_cor
FROM cor c
WHERE c.cd_cor NOT IN (SELECT v.cd_cor
					   FROM veiculo v);

-- b)     Listar a placa e a descrição do modelo do(s) veículo(s) mais novo(s) cadastrado(s) - considerar o ano modelo. Atenção, pois poderá haver mais de um veículo;
SELECT v.nr_placa, mo.ds_modelo
FROM veiculo v
JOIN modelo mo ON mo.cd_modelo = v.cd_modelo
WHERE v.nr_ano_mod IN (SELECT MAX(nr_ano_mod)
					   FROM veiculo);

-- c)     Listar a descrição do(s) modelo(s) que possui(em) o maior número de veículos cadastrado;
SELECT mo.ds_modelo
FROM modelo mo
JOIN veiculo v ON v.cd_modelo = mo.cd_modelo
GROUP BY mo.ds_modelo
HAVING COUNT(*) >= ALL (SELECT COUNT(*)
							   FROM veiculo v
							   JOIN modelo mo ON mo.cd_modelo = v.cd_modelo
							   GROUP BY mo.ds_modelo);

-- d)     Listar a descrição da marca que possui o menor número de modelos cadastrados;
SELECT ma.ds_marca
FROM modelo mo
JOIN marca ma ON ma.cd_marca = mo.cd_marca
GROUP BY ma.ds_marca
HAVING COUNT(*) <= ALL (SELECT COUNT(mo.cd_marca)
								FROM marca ma
								JOIN modelo mo ON mo.cd_marca = ma.cd_marca
								GROUP BY ma.ds_marca);

-- e)      Listar a descrição do acessório mais popular (que mais é encontrado) entre os veículos fabricados. Atenção, pois poderá haver mais de um acessório ranqueado com mais...;
SELECT a.ds_acessorio
FROM acessorio a
JOIN veiculo_acessorio va ON va.cd_acessorio = a.cd_acessorio
GROUP BY a.ds_acessorio
HAVING COUNT(*) >= ALL (SELECT COUNT(*)
						FROM veiculo_acessorio va
						GROUP BY va.cd_acessorio);

-- f)     Listar qual(is) acessórios não estão associados a veículos fabricados anterior ao ano de 2017;
-- f)     Listar qual(is) acessórios não estão associados a veículos fabricados anterior ao ano de 2017;
SELECT a.ds_acessorio
FROM acessorio a
JOIN veiculo_acessorio va ON va.cd_acessorio = a.cd_acessorio
WHERE va.cd_acessorio NOT IN (SELECT nr_placa
										FROM veiculo v
										WHERE v.nr_ano_fab < 2017)
GROUP BY a.ds_acessorio;