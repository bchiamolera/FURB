-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-18 13:53:26.126

-- tables
-- Table: aluno
CREATE TABLE aluno (
    id_aluno int  NOT NULL,
    nm_aluno varchar(50)  NOT NULL,
    ds_genero char(1)  NOT NULL,
    id_grau_instrucao int  NOT NULL,
    id_profissao int  NOT NULL,
    nr_telefone varchar(15)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    vl_peso decimal(4,1)  NOT NULL,
    vl_altura decimal(3,2)  NOT NULL,
    id_endereco int  NOT NULL,
    id_plano int  NOT NULL,
    CONSTRAINT aluno_pk PRIMARY KEY (id_aluno)
);

-- Table: atividade_profissional
CREATE TABLE atividade_profissional (
    id_profissao int  NOT NULL,
    nm_profissao varchar(50)  NOT NULL,
    CONSTRAINT atividade_profissional_pk PRIMARY KEY (id_profissao)
);

-- Table: endereco
CREATE TABLE endereco (
    id_endereco int  NOT NULL,
    nm_logradouro varchar(50)  NOT NULL,
    ds_complemento varchar(30)  NOT NULL,
    nm_bairro varchar(30)  NOT NULL,
    id_localidade int  NOT NULL,
    num_cep int  NOT NULL,
    CONSTRAINT endereco_pk PRIMARY KEY (id_endereco)
);

-- Table: grau_de_instrucao
CREATE TABLE grau_de_instrucao (
    id_grau_instrucao int  NOT NULL,
    nv_grau varchar(50)  NOT NULL,
    CONSTRAINT grau_de_instrucao_pk PRIMARY KEY (id_grau_instrucao)
);

-- Table: instrutor
CREATE TABLE instrutor (
    id_instrutor int  NOT NULL,
    nm_instrutor varchar(50)  NOT NULL,
    nr_telefone varchar(15)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    id_endereco int  NOT NULL,
    CONSTRAINT instrutor_pk PRIMARY KEY (id_instrutor)
);

-- Table: localidade
CREATE TABLE localidade (
    id_localidade int  NOT NULL,
    nm_localidade varchar(50)  NOT NULL,
    nm_uf char(2)  NOT NULL,
    CONSTRAINT localidade_pk PRIMARY KEY (id_localidade)
);

-- Table: matricula
CREATE TABLE matricula (
    id_aluno int  NOT NULL,
    id_turma int  NOT NULL,
    CONSTRAINT matricula_pk PRIMARY KEY (id_aluno,id_turma)
);

-- Table: modalidade
CREATE TABLE modalidade (
    id_modalidade int  NOT NULL,
    nm_modalidade varchar(50)  NOT NULL,
    ds_modalidade varchar(100)  NOT NULL,
    CONSTRAINT modalidade_pk PRIMARY KEY (id_modalidade)
);

-- Table: modalidade_instrutor
CREATE TABLE modalidade_instrutor (
    id_instrutor int  NOT NULL,
    id_modalidade int  NOT NULL,
    CONSTRAINT modalidade_instrutor_pk PRIMARY KEY (id_instrutor,id_modalidade)
);

-- Table: plano
CREATE TABLE plano (
    id_plano int  NOT NULL,
    ds_plano varchar(50)  NOT NULL,
    vl_mensal decimal(8,2)  NOT NULL,
    vl_trimestral decimal(8,2)  NOT NULL,
    vl_semestral decimal(8,2)  NOT NULL,
    vl_anual decimal(8,2)  NOT NULL,
    qt_turmas int  NOT NULL,
    CONSTRAINT plano_pk PRIMARY KEY (id_plano)
);

-- Table: presenca
CREATE TABLE presenca (
    id_presenca int  NOT NULL,
    dt_presenca date  NOT NULL,
    id_aluno int  NOT NULL,
    id_turma int  NOT NULL,
    CONSTRAINT presenca_pk PRIMARY KEY (id_presenca)
);

-- Table: turma
CREATE TABLE turma (
    id_turma int  NOT NULL,
    hr_inicio time  NOT NULL,
    ds_duracao time  NOT NULL,
    nr_limite_vagas int  NOT NULL,
    ds_turma varchar(50)  NOT NULL,
    id_instrutor int  NOT NULL,
    id_modalidade int  NOT NULL,
    CONSTRAINT turma_pk PRIMARY KEY (id_turma)
);

-- foreign keys
-- Reference: Aluno_Endereco (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT Aluno_Endereco FOREIGN KEY Aluno_Endereco (id_endereco)
    REFERENCES endereco (id_endereco);

-- Reference: Aluno_Plano (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT Aluno_Plano FOREIGN KEY Aluno_Plano (id_plano)
    REFERENCES plano (id_plano);

-- Reference: Endereco_localidade (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT Endereco_localidade FOREIGN KEY Endereco_localidade (id_localidade)
    REFERENCES localidade (id_localidade);

-- Reference: Instrutor_Endereco (table: instrutor)
ALTER TABLE instrutor ADD CONSTRAINT Instrutor_Endereco FOREIGN KEY Instrutor_Endereco (id_endereco)
    REFERENCES endereco (id_endereco);

-- Reference: Matricula_Aluno (table: matricula)
ALTER TABLE matricula ADD CONSTRAINT Matricula_Aluno FOREIGN KEY Matricula_Aluno (id_aluno)
    REFERENCES aluno (id_aluno);

-- Reference: Matricula_Turma (table: matricula)
ALTER TABLE matricula ADD CONSTRAINT Matricula_Turma FOREIGN KEY Matricula_Turma (id_turma)
    REFERENCES turma (id_turma);

-- Reference: Modalidade_Instrutor_Instrutor (table: modalidade_instrutor)
ALTER TABLE modalidade_instrutor ADD CONSTRAINT Modalidade_Instrutor_Instrutor FOREIGN KEY Modalidade_Instrutor_Instrutor (id_instrutor)
    REFERENCES instrutor (id_instrutor);

-- Reference: Modalidade_Instrutor_Modalidade (table: modalidade_instrutor)
ALTER TABLE modalidade_instrutor ADD CONSTRAINT Modalidade_Instrutor_Modalidade FOREIGN KEY Modalidade_Instrutor_Modalidade (id_modalidade)
    REFERENCES modalidade (id_modalidade);

-- Reference: Turma_Modalidade_Instrutor (table: turma)
ALTER TABLE turma ADD CONSTRAINT Turma_Modalidade_Instrutor FOREIGN KEY Turma_Modalidade_Instrutor (id_instrutor,id_modalidade)
    REFERENCES modalidade_instrutor (id_instrutor,id_modalidade);

-- Reference: aluno_atividade_profissional (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT aluno_atividade_profissional FOREIGN KEY aluno_atividade_profissional (id_profissao)
    REFERENCES atividade_profissional (id_profissao);

-- Reference: aluno_grau_de_instrucao (table: aluno)
ALTER TABLE aluno ADD CONSTRAINT aluno_grau_de_instrucao FOREIGN KEY aluno_grau_de_instrucao (id_grau_instrucao)
    REFERENCES grau_de_instrucao (id_grau_instrucao);

-- Reference: presenca_matricula (table: presenca)
ALTER TABLE presenca ADD CONSTRAINT presenca_matricula FOREIGN KEY presenca_matricula (id_aluno,id_turma)
    REFERENCES matricula (id_aluno,id_turma);

-- End of file.

