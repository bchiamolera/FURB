-- Comentario de linha

/* 
 * comentario
 * de
 * bloco
 */

CREATE TABLE departamento
(cd_depto INTEGER,    
 nm_depto VARCHAR(50), 
 vl_orcto DECIMAL(8,2),
 PRIMARY KEY(cd_depto)
 );

CREATE TABLE funcionario
(cd_func INTEGER,
 cd_depto INTEGER,
 nm_func VARCHAR(50),
 PRIMARY KEY (cd_func),
 FOREIGN KEY (cd_depto) REFERENCES departamento(cd_depto)
 );