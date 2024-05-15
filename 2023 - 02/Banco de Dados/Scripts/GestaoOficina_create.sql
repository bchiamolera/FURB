-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-18 12:20:12.956

-- tables
-- Table: categoria
CREATE TABLE categoria (
    id_categoria int  NOT NULL,
    nm_categoria varchar(50)  NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (id_categoria)
);

-- Table: cliente
CREATE TABLE cliente (
    id_cliente int  NOT NULL,
    nm_cliente varchar(50)  NOT NULL,
    num_telefone varchar(11)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    id_endereco int  NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);

-- Table: endereco
CREATE TABLE endereco (
    id_endereco int  NOT NULL,
    nm_logradouro varchar(50)  NOT NULL,
    ds_complemento varchar(50)  NOT NULL,
    nm_bairro varchar(50)  NOT NULL,
    id_localidade int  NOT NULL,
    num_cep char(8)  NOT NULL,
    CONSTRAINT endereco_pk PRIMARY KEY (id_endereco)
);

-- Table: especialidade
CREATE TABLE especialidade (
    id_especialidade int  NOT NULL,
    nm_especialidade varchar(50)  NOT NULL,
    ds_especialidade varchar(50)  NOT NULL,
    CONSTRAINT especialidade_pk PRIMARY KEY (id_especialidade)
);

-- Table: item_nf_peca
CREATE TABLE item_nf_peca (
    num_nf int  NOT NULL,
    id_peca int  NOT NULL,
    qtd_peca_nota decimal(11,2)  NOT NULL,
    vlr_peca_nota decimal(11,2)  NOT NULL,
    vlr_total_item_nota decimal(11,2)  NOT NULL,
    CONSTRAINT item_nf_peca_pk PRIMARY KEY (num_nf,id_peca)
);

-- Table: item_nf_servico
CREATE TABLE item_nf_servico (
    num_nf int  NOT NULL,
    id_servico int  NOT NULL,
    vlr_servico_nota decimal(11,2)  NOT NULL,
    vlr_total_item_nota decimal(11,2)  NOT NULL,
    CONSTRAINT item_nf_servico_pk PRIMARY KEY (num_nf,id_servico)
);

-- Table: item_os_peca
CREATE TABLE item_os_peca (
    id_ordem_de_servico int  NOT NULL,
    id_peca int  NOT NULL,
    qt_peca decimal(11,2)  NOT NULL,
    vlr_peca decimal(11,2)  NOT NULL,
    CONSTRAINT item_os_peca_pk PRIMARY KEY (id_ordem_de_servico,id_peca)
);

-- Table: item_os_servico
CREATE TABLE item_os_servico (
    id_ordem_de_servico int  NOT NULL,
    id_servico int  NOT NULL,
    vlr_servico decimal(11,2)  NOT NULL,
    vlr_total_item decimal(11,2)  NOT NULL,
    CONSTRAINT item_os_servico_pk PRIMARY KEY (id_servico,id_ordem_de_servico)
);

-- Table: localidade
CREATE TABLE localidade (
    id_localidade int  NOT NULL,
    nm_localidade varchar(50)  NOT NULL,
    sg_uf char(2)  NOT NULL,
    CONSTRAINT localidade_pk PRIMARY KEY (id_localidade)
);

-- Table: marca
CREATE TABLE marca (
    id_marca int  NOT NULL,
    nm_marca varchar(50)  NOT NULL,
    CONSTRAINT marca_pk PRIMARY KEY (id_marca)
);

-- Table: modelo
CREATE TABLE modelo (
    id_modelo int  NOT NULL,
    nm_modelo varchar(50)  NOT NULL,
    id_marca int  NOT NULL,
    num_ano_modelo char(4)  NOT NULL,
    ds_detalhes varchar(50)  NOT NULL,
    CONSTRAINT modelo_pk PRIMARY KEY (id_modelo)
);

-- Table: nota_fiscal
CREATE TABLE nota_fiscal (
    num_nf int  NOT NULL,
    id_cliente int  NOT NULL,
    dt_emissao datetime  NOT NULL,
    vlr_total_nf decimal(11,2)  NOT NULL,
    CONSTRAINT nota_fiscal_pk PRIMARY KEY (num_nf)
);

-- Table: ordem_de_servico
CREATE TABLE ordem_de_servico (
    id_ordem_de_servico int  NOT NULL,
    id_cliente int  NOT NULL,
    veiculo_ds_placa char(8)  NOT NULL,
    dt_emissao datetime  NOT NULL,
    vlr_total decimal(11,2)  NOT NULL,
    fl_situacao char(1)  NOT NULL,
    CONSTRAINT ordem_de_servico_pk PRIMARY KEY (id_ordem_de_servico)
);

-- Table: peca
CREATE TABLE peca (
    id_peca int  NOT NULL,
    nm_peca varchar(50)  NOT NULL,
    id_categoria int  NOT NULL,
    ds_peca varchar(50)  NOT NULL,
    qtd_estoque int  NOT NULL,
    vlr_custo decimal(11,2)  NOT NULL,
    vlr_venda decimal(11,2)  NOT NULL,
    CONSTRAINT peca_pk PRIMARY KEY (id_peca)
);

-- Table: profissional
CREATE TABLE profissional (
    id_profissional int  NOT NULL,
    nm_profissonal varchar(50)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    num_telefone char(11)  NOT NULL,
    CONSTRAINT profissional_pk PRIMARY KEY (id_profissional)
);

-- Table: profissional_especialidade
CREATE TABLE profissional_especialidade (
    id_profissional int  NOT NULL,
    id_especialidade int  NOT NULL,
    CONSTRAINT profissional_especialidade_pk PRIMARY KEY (id_profissional,id_especialidade)
);

-- Table: profissional_os
CREATE TABLE profissional_os (
    id_profissional int  NOT NULL,
    id_servico int  NOT NULL,
    d_ordem_de_servico int  NOT NULL,
    CONSTRAINT profissional_os_pk PRIMARY KEY (id_profissional,id_servico,d_ordem_de_servico)
);

-- Table: servico
CREATE TABLE servico (
    id_servico int  NOT NULL,
    ds_servico varchar(50)  NOT NULL,
    vlr_servico decimal(11,2)  NOT NULL,
    CONSTRAINT servico_pk PRIMARY KEY (id_servico)
);

-- Table: veiculo
CREATE TABLE veiculo (
    ds_placa char(8)  NOT NULL,
    id_modelo int  NOT NULL,
    num_ano_fabricacao char(4)  NOT NULL,
    CONSTRAINT veiculo_pk PRIMARY KEY (ds_placa)
);

-- foreign keys
-- Reference: cliente_endereco (table: cliente)
ALTER TABLE cliente ADD CONSTRAINT cliente_endereco FOREIGN KEY cliente_endereco (id_endereco)
    REFERENCES endereco (id_endereco);

-- Reference: endereco_localidade (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_localidade FOREIGN KEY endereco_localidade (id_localidade)
    REFERENCES localidade (id_localidade);

-- Reference: item_nf_peca_nota_fiscal (table: item_nf_peca)
ALTER TABLE item_nf_peca ADD CONSTRAINT item_nf_peca_nota_fiscal FOREIGN KEY item_nf_peca_nota_fiscal (num_nf)
    REFERENCES nota_fiscal (num_nf);

-- Reference: item_nf_peca_peca (table: item_nf_peca)
ALTER TABLE item_nf_peca ADD CONSTRAINT item_nf_peca_peca FOREIGN KEY item_nf_peca_peca (id_peca)
    REFERENCES peca (id_peca);

-- Reference: item_nf_servico_nota_fiscal (table: item_nf_servico)
ALTER TABLE item_nf_servico ADD CONSTRAINT item_nf_servico_nota_fiscal FOREIGN KEY item_nf_servico_nota_fiscal (num_nf)
    REFERENCES nota_fiscal (num_nf);

-- Reference: item_nf_servico_servico (table: item_nf_servico)
ALTER TABLE item_nf_servico ADD CONSTRAINT item_nf_servico_servico FOREIGN KEY item_nf_servico_servico (id_servico)
    REFERENCES servico (id_servico);

-- Reference: item_os_peca_ordem_de_servico (table: item_os_peca)
ALTER TABLE item_os_peca ADD CONSTRAINT item_os_peca_ordem_de_servico FOREIGN KEY item_os_peca_ordem_de_servico (id_ordem_de_servico)
    REFERENCES ordem_de_servico (id_ordem_de_servico);

-- Reference: item_os_peca_pecas (table: item_os_peca)
ALTER TABLE item_os_peca ADD CONSTRAINT item_os_peca_pecas FOREIGN KEY item_os_peca_pecas (id_peca)
    REFERENCES peca (id_peca);

-- Reference: item_os_servico_ordem_de_servico (table: item_os_servico)
ALTER TABLE item_os_servico ADD CONSTRAINT item_os_servico_ordem_de_servico FOREIGN KEY item_os_servico_ordem_de_servico (id_ordem_de_servico)
    REFERENCES ordem_de_servico (id_ordem_de_servico);

-- Reference: item_os_servico_servico (table: item_os_servico)
ALTER TABLE item_os_servico ADD CONSTRAINT item_os_servico_servico FOREIGN KEY item_os_servico_servico (id_servico)
    REFERENCES servico (id_servico);

-- Reference: modelo_marca (table: modelo)
ALTER TABLE modelo ADD CONSTRAINT modelo_marca FOREIGN KEY modelo_marca (id_marca)
    REFERENCES marca (id_marca);

-- Reference: nota_fiscal_cliente (table: nota_fiscal)
ALTER TABLE nota_fiscal ADD CONSTRAINT nota_fiscal_cliente FOREIGN KEY nota_fiscal_cliente (id_cliente)
    REFERENCES cliente (id_cliente);

-- Reference: ordem_de_servico_cliente (table: ordem_de_servico)
ALTER TABLE ordem_de_servico ADD CONSTRAINT ordem_de_servico_cliente FOREIGN KEY ordem_de_servico_cliente (id_cliente)
    REFERENCES cliente (id_cliente);

-- Reference: ordem_de_servico_veiculo (table: ordem_de_servico)
ALTER TABLE ordem_de_servico ADD CONSTRAINT ordem_de_servico_veiculo FOREIGN KEY ordem_de_servico_veiculo (veiculo_ds_placa)
    REFERENCES veiculo (ds_placa);

-- Reference: pecas_categoria (table: peca)
ALTER TABLE peca ADD CONSTRAINT pecas_categoria FOREIGN KEY pecas_categoria (id_categoria)
    REFERENCES categoria (id_categoria);

-- Reference: profissional_especialidade_especialidade (table: profissional_especialidade)
ALTER TABLE profissional_especialidade ADD CONSTRAINT profissional_especialidade_especialidade FOREIGN KEY profissional_especialidade_especialidade (id_especialidade)
    REFERENCES especialidade (id_especialidade);

-- Reference: profissional_especialidade_profissional (table: profissional_especialidade)
ALTER TABLE profissional_especialidade ADD CONSTRAINT profissional_especialidade_profissional FOREIGN KEY profissional_especialidade_profissional (id_profissional)
    REFERENCES profissional (id_profissional);

-- Reference: profissional_os_item_os_servico (table: profissional_os)
ALTER TABLE profissional_os ADD CONSTRAINT profissional_os_item_os_servico FOREIGN KEY profissional_os_item_os_servico (id_servico,d_ordem_de_servico)
    REFERENCES item_os_servico (id_servico,id_ordem_de_servico);

-- Reference: profissional_os_profissional (table: profissional_os)
ALTER TABLE profissional_os ADD CONSTRAINT profissional_os_profissional FOREIGN KEY profissional_os_profissional (id_profissional)
    REFERENCES profissional (id_profissional);

-- Reference: veiculo_modelo (table: veiculo)
ALTER TABLE veiculo ADD CONSTRAINT veiculo_modelo FOREIGN KEY veiculo_modelo (id_modelo)
    REFERENCES modelo (id_modelo);

-- End of file.

