-- Alterando marca
ALTER TABLE Marca
	ADD CONSTRAINT PRIMARY KEY (cd_marca);
-- Alterando localidade
ALTER TABLE Localidade
	ADD CONSTRAINT PRIMARY KEY (cd_localidade);
-- Alterando modelo
ALTER TABLE Modelo
	ADD CONSTRAINT PRIMARY KEY (cd_modelo);
-- Alterando combustivel	
ALTER TABLE Combustivel
	ADD CONSTRAINT PRIMARY KEY (cd_combustivel);
-- Alterando proprietario
ALTER TABLE Proprietario
	ADD CONSTRAINT PRIMARY KEY (cd_proprietario);
ALTER TABLE Proprietario
	ADD CONSTRAINT proprietario_localidade_fk
		FOREIGN KEY (cd_localidade)
		REFERENCES Localidade (cd_localidade);
-- Alterando veiculo
ALTER TABLE Veiculo
	ADD CONSTRAINT PRIMARY KEY (nr_placa);
ALTER TABLE Veiculo
	ADD CONSTRAINT veiculo_proprietario_fk
	FOREIGN KEY (cd_proprietario)
		REFERENCES Proprietario (cd_proprietario);
ALTER TABLE Veiculo
	ADD CONSTRAINT veiculo_modelo_fk
	FOREIGN KEY (cd_modelo)
		REFERENCES Modelo (cd_modelo);
-- Alterando veiculo_combustivel	
ALTER TABLE Veiculo_Combustivel
	ADD CONSTRAINT PRIMARY KEY (cd_combustivel,nr_placa);
ALTER TABLE Veiculo_Combustivel
	ADD CONSTRAINT veiculo_combustivel_combustivel_fk
		FOREIGN KEY (cd_combustivel)
		REFERENCES Combustivel (cd_combustivel);
ALTER TABLE Veiculo_Combustivel
	ADD CONSTRAINT veiculo_combustivel_veiculo_fk
		FOREIGN KEY (nr_placa)
		REFERENCES Veiculo (nr_placa);
-- Adicionando tabela cor
CREATE TABLE Cor (
	cd_cor 			INT PRIMARY KEY,
	ds_cor 			VARCHAR(30)
);
-- Adicionando tabela acessorio
CREATE TABLE Acessorio (
	cd_acessorio	INT PRIMARY KEY,
	ds_acessorio 	VARCHAR(50)
);
-- Adicionando cor em veiculo
ALTER TABLE Veiculo
	ADD COLUMN cd_cor INT;
-- Adicionando fk cor
ALTER TABLE Veiculo
	ADD CONSTRAINT veiculo_cor_fk
		FOREIGN KEY (cd_cor)
		REFERENCES Cor (cd_cor);
-- Criando tabela veiculo_acessorio
CREATE TABLE Veiculo_Acessorio (
	nr_placa CHAR(7) REFERENCES Veiculo (nr_placa),
	cd_acessorio INT REFERENCES Acessorio (cd_acessorio),
	PRIMARY KEY (nr_placa,cd_acessorio)
);