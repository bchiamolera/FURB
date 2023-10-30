CREATE TABLE pessoa (
	cd_pessoa INTEGER,
	nm_pessoa VARCHAR(20),
	ds_email VARCHAR(50)
	dt_nascimento DATE DEFAULT '2023/10/30',
	PRIMARY KEY (cd_pessoa),
	UNIQUE KEY (nm_pessoa)
);

INSERT INTO pessoa
VALUES (0, '', '', '');

INSERT INTO pessoa
VALUES (1, 'Pessoa 1', 'pessoa1@gmail.com', '2020/01/01');

INSERT INTO pessoa (cd_pessoa, nm_pessoa, dt_nascimento)
VALUES (2, 'Pessoa 2', '2020/01/01');

INSERT INTO pessoa (cd_pessoa, nm_pessoa)
VALUES (3, 'Pessoa 3');

DESC pessoa;

UPDATE pessoa
SET ds_email = 'pessoa2@gmail.com'
WHERE cd_pessoa = 2;

UPDATE pessoa
SET ds_email = 'pessoa3@gmail.com'
WHERE cd_pessoa = 3;

ALTER TABLE pessoa
MODIFY ds_email VARCHAR(50) NOT NULL;

DELETE FROM pessoa;

ALTER TABLE pessoa
MODIFY COLUMN cd_pessoa INTEGER NOT NULL AUTO_INCREMENT;

INSERT INTO pessoa (nm_pessoa, ds_email)
VALUES ('Pessoa N', 'pessoaN@gmail.com');

TRUNCATE TABLE pessoa;

INSERT INTO pessoa (nm_pessoa, ds_email, dt_nascimento)
VALUES ('Pessoa 1', 'pessoa1@gmail.com', '2020/01/01');

INSERT INTO pessoa (nm_pessoa, ds_email, dt_nascimento)
VALUES ('Pessoa 2', 'pessoa2@gmail.com', '2020/01/01');

INSERT INTO pessoa (nm_pessoa, ds_email, dt_nascimento)
VALUES ('José Carlos', 'jc@gmail.com', '2023/01/01');

INSERT INTO pessoa (nm_pessoa, ds_email, dt_nascimento)
VALUES ('Marina Sell', 'msell@gmail.com', '2022/10/01');

INSERT INTO pessoa (nm_pessoa, ds_email, dt_nascimento)
VALUES ('José Buy', 'jbuy@gmail.com', '1999/12/31');

-- SELECTS

SELECT 	nm_pessoa, 
		dt_nascimento
FROM pessoa;

SELECT 	nm_pessoa, 
		dt_nascimento
FROM pessoa
WHERE cd_pessoa = 1;

SELECT 	nm_pessoa, 
		dt_nascimento
FROM pessoa
WHERE cd_pessoa = 1
   OR cd_pessoa = 3;
   
SELECT 	nm_pessoa, 
		dt_nascimento
FROM pessoa
WHERE cd_pessoa IN (1, 3); -- SE cd_pessoa = 1 OU 3;

SELECT 	nm_pessoa, 
		dt_nascimento
FROM pessoa
WHERE nm_pessoa LIKE 'Pessoa%';

SELECT 	nm_pessoa, 
		dt_nascimento
FROM pessoa
WHERE nm_pessoa LIKE '%Jose%';

INSERT INTO pessoa (ds_email)
VALUES ('pessoanull@gmail.com');