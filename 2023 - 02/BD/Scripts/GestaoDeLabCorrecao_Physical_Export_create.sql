-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-04 11:38:57.604

-- tables
-- Table: categoria_software
CREATE TABLE categoria_software (
    id_categoria_software int  NOT NULL,
    nm_categoria_software varchar(30)  NOT NULL,
    CONSTRAINT categoria_software_pk PRIMARY KEY (id_categoria_software)
);

-- Table: equipamento
CREATE TABLE equipamento (
    id_equipamento int  NOT NULL,
    nm_equipamento varchar(30)  NOT NULL,
    ds_equipamento varchar(50)  NOT NULL,
    dt_aquisicao date  NOT NULL,
    ds_configuracao varchar(100)  NOT NULL,
    id_sala int  NOT NULL,
    id_tipo_equipamento int  NOT NULL,
    CONSTRAINT equipamento_pk PRIMARY KEY (id_equipamento)
);

-- Table: equipamento_software
CREATE TABLE equipamento_software (
    id_equipamento int  NOT NULL,
    id_software int  NOT NULL,
    CONSTRAINT equipamento_software_pk PRIMARY KEY (id_equipamento,id_software)
);

-- Table: sala
CREATE TABLE sala (
    id_sala int  NOT NULL,
    nm_sala varchar(30)  NOT NULL,
    qt_capacidade int  NOT NULL,
    vl_metragem decimal(4,1)  NOT NULL,
    CONSTRAINT sala_pk PRIMARY KEY (id_sala)
);

-- Table: software
CREATE TABLE software (
    id_software int  NOT NULL,
    nm_software varchar(30)  NOT NULL,
    ds_software varchar(50)  NOT NULL,
    id_categoria_software int  NOT NULL,
    CONSTRAINT software_pk PRIMARY KEY (id_software)
);

-- Table: tipo_equipamento
CREATE TABLE tipo_equipamento (
    id_tipo_equipamento int  NOT NULL,
    nm_tipo_equipamento varchar(30)  NOT NULL,
    CONSTRAINT tipo_equipamento_pk PRIMARY KEY (id_tipo_equipamento)
);

-- foreign keys
-- Reference: equipamento_sala (table: equipamento)
ALTER TABLE equipamento ADD CONSTRAINT equipamento_sala FOREIGN KEY equipamento_sala (id_sala)
    REFERENCES sala (id_sala);

-- Reference: equipamento_software_equipamento (table: equipamento_software)
ALTER TABLE equipamento_software ADD CONSTRAINT equipamento_software_equipamento FOREIGN KEY equipamento_software_equipamento (id_equipamento)
    REFERENCES equipamento (id_equipamento);

-- Reference: equipamento_software_software (table: equipamento_software)
ALTER TABLE equipamento_software ADD CONSTRAINT equipamento_software_software FOREIGN KEY equipamento_software_software (id_software)
    REFERENCES software (id_software);

-- Reference: equipamento_tipo_equipamento (table: equipamento)
ALTER TABLE equipamento ADD CONSTRAINT equipamento_tipo_equipamento FOREIGN KEY equipamento_tipo_equipamento (id_tipo_equipamento)
    REFERENCES tipo_equipamento (id_tipo_equipamento);

-- Reference: software_categoria_software (table: software)
ALTER TABLE software ADD CONSTRAINT software_categoria_software FOREIGN KEY software_categoria_software (id_categoria_software)
    REFERENCES categoria_software (id_categoria_software);

-- End of file.

