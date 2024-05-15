CREATE TABLE autor (
	cd_autor INT PRIMARY KEY,
	nm_autor VARCHAR(100)
);

CREATE TABLE editora (
	cd_editora INT PRIMARY KEY,
	nm_editora VARCHAR(100)
);

CREATE TABLE tipo_obra (
	tp_obra INT PRIMARY KEY,
	ds_tipo VARCHAR(30)
);

CREATE TABLE obra (
	cd_obra INT PRIMARY KEY,