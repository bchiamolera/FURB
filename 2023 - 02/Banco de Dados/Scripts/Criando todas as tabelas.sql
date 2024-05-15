-- Criando as tabelas do modelo
CREATE TABLE Marca (
	cd_marca 		int PRIMARY KEY,
	ds_marca 		varchar(30)
);

CREATE TABLE Localidade (
	cd_localidade 	int PRIMARY KEY,
	nm_localidade 	varchar(50)
);

CREATE TABLE Modelo (
	cd_modelo 		int PRIMARY KEY,
	cd_marca 		int REFERENCES Marca (cd_marca),
	ds_modelo 		varchar(50)
);

CREATE TABLE Combustivel (
	cd_combustivel 	int PRIMARY KEY,
	ds_combustivel 	varchar(30)
);

CREATE TABLE Proprietario (
	cd_proprietario int PRIMARY KEY,
	cd_localidade 	int REFERENCES Localidade (cd_localidade),
	nm_proprietario varchar(50),
	ds_logradouro 	varchar(50),
	ds_complemento 	varchar(50),
	ds_bairro 		varchar(50),
	nr_telefone 	varchar(15),
	ds_email 		varchar(50),
	sg_uf 			char(2)
);

CREATE TABLE Cor (
	cd_cor 			int PRIMARY KEY,
	ds_cor 			VARCHAR(30)
);

CREATE TABLE Acessorio (
	cd_acessorio	int PRIMARY KEY,
	ds_acessorio 	varchar(50)
);

CREATE TABLE Veiculo (
	nr_placa 		char(7) PRIMARY KEY,
	cd_cor			int REFERENCES Cor (cd_cor),
	cd_proprietario int REFERENCES Proprietario (cd_proprietario),
	cd_modelo 		int REFERENCES Modelo (cd_modelo),
	nr_ano_fab 		int,
	nr_ano_mod 		int,
	qt_km_rodado 	int,
	qt_portas 		int,
	ds_observacao 	varchar(100)
);

CREATE TABLE Veiculo_Combustivel (
	cd_combustivel 	int REFERENCES Combustivel (cd_combustivel),
	nr_placa 		char(7) REFERENCES Veiculo (nr_placa),
	PRIMARY KEY (cd_combustivel,nr_placa)
);

CREATE TABLE Veiculo_Acessorio (
	nr_placa 		char(7) REFERENCES Veiculo (nr_placa),
	cd_acessorio 	int REFERENCES Acessorio (cd_acessorio),
	PRIMARY KEY (nr_placa,cd_acessorio)
);