-- Questão 01
CREATE TABLE usuario (
	cd_usuario INT PRIMARY KEY,
	nm_usuario VARCHAR(50),
	ds_email VARCHAR(50),
	nr_telefone VARCHAR(15)
);

CREATE TABLE ordem_servico (
	nr_os INT PRIMARY KEY,
	cd_usuario INT REFERENCES usuario(cd_usuario),
	dt_registro DATE,
	ds_observacao VARCHAR(200)
);

CREATE TABLE situacao (
	cd_situacao INT PRIMARY KEY,
	ds_situacao VARCHAR(50)
);

CREATE TABLE servico (
	cd_servico INT PRIMARY KEY,
	ds_servico VARCHAR(50),
	ds_sugestao VARCHAR(200)
);

CREATE TABLE itens_ordem_servico (
	nr_os INT REFERENCES ordem_servico(nr_os),
	cd_servico INT REFERENCES servico(cd_servico),
	cd_situacao INT REFERENCES situacao(cd_situacao),
	dt_atendimento DATE,
	ds_atendimento VARCHAR(100)
);

ALTER TABLE itens_ordem_servico
	ADD CONSTRAINT PRIMARY KEY(nr_os),
	ADD CONSTRAINT PRIMARY KEY(cd_servico);

-- Questão 02
INSERT INTO usuario
VALUES (1, "Bernardo", "bernardo.ch@gmail.com", "047988189030"),
		 (2, "Joao", "joao@yahoo@gmail.com", "035989324750"),
		 (3, "Maria", "mariaz@outlook.com", "045998054604");

INSERT INTO servico
VALUES (1, "Instalar servidor", "Levar furadeira e parafusos"),
		 (2, "Manutenção de computador", ""),
		 (3, "Instalar Windows", ""),
		 (4, "Manutenção de rede Wi-Fi", "Levar notebook"),
		 (5, "Troca de monitor de vídeo", "");

INSERT INTO situacao
VALUES (1, "Em aberto"),
		 (2, "Aguardando peça de reposição"),
		 (3, "Concluído");
		 
INSERT INTO ordem_servico
VALUES (1, 1, "2023-11-01", "Chegar entre 15:30 e 17:00"),
		 (2, 2, "2023-11-28", ""),
		 (3, 3, "2023-11-16", "Tocar interfone"),
		 (4, 1, "2023-11-20", ""),
		 (5, 2, "2023-11-30", "");

INSERT INTO itens_ordem_servico
VALUES (1, 3, 3, "2023-11-04", ""),
		 (1, 1, 3, "2023-11-07", ""),
		 (2, 2, 3, "2023-11-29", ""),
		 (3, 5, 3, "2023-11-20", ""),
		 (4, 3, 3, "2023-11-25", "");
		 
INSERT INTO itens_ordem_servico(nr_os, cd_servico, cd_situacao, ds_atendimento)
VALUES (2, 4, 2, "Comprar roteador"),
		 (3, 2, 1, "Limpar computador"),
		 (4, 5, 2, "Comprar monitor"),
		 (5, 4, 1, ""),
		 (5, 1, 1, "");
		 
-- Questão 03
SELECT u.nm_usuario, os.nr_os, os.dt_registro
FROM usuario u
	JOIN ordem_servico os ON os.cd_usuario = u.cd_usuario;

-- Questao 04
SELECT os.dt_registro, u.nm_usuario, s.ds_servico
FROM ordem_servico os
	JOIN usuario u ON u.cd_usuario = os.cd_usuario
	JOIN itens_ordem_servico ios ON ios.nr_os = os.nr_os
	JOIN servico s ON s.cd_servico = ios.cd_servico
WHERE os.dt_registro >= "2023-11-10" AND os.dt_registro <= "2023-11-15";

-- Questão 05
SELECT os.nr_os, os.dt_registro, s.ds_servico
FROM ordem_servico os
	JOIN itens_ordem_servico ios ON ios.nr_os = os.nr_os
	JOIN servico s ON s.cd_servico = ios.cd_servico
	JOIN situacao si ON si.cd_situacao = ios.cd_situacao
WHERE si.ds_situacao != "Concluído";

-- Questão 06
SELECT s.ds_servico
FROM servico s
	JOIN itens_ordem_servico ios ON s.cd_servico = ios.cd_servico
	JOIN ordem_servico os ON ios.nr_os = os.nr_os
WHERE os.dt_registro >= "2023-11-01" AND os.dt_registro <= "2023-11-30" AND ios.dt_atendimento IS NULL;