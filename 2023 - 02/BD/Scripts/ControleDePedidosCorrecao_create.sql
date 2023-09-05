-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-04 13:56:08.507

-- tables
-- Table: categoria
CREATE TABLE categoria (
    id_categoria int  NOT NULL,
    nm_categoria varchar(30)  NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (id_categoria)
);

-- Table: cliente
CREATE TABLE cliente (
    id_cliente int  NOT NULL,
    nm_cliente varchar(50)  NOT NULL,
    id_endereco int  NOT NULL,
    nr_telefone varchar(15)  NOT NULL,
    ds_email varchar(50)  NOT NULL,
    vl_limite decimal(8,2)  NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
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

-- Table: item
CREATE TABLE item (
    id_pedido int  NOT NULL,
    id_produto int  NOT NULL,
    qtd_item int  NOT NULL,
    vl_produto decimal(8,2)  NOT NULL,
    CONSTRAINT item_pk PRIMARY KEY (id_pedido,id_produto)
);

-- Table: localidade
CREATE TABLE localidade (
    id_localidade int  NOT NULL,
    nm_localidade varchar(50)  NOT NULL,
    nm_uf char(2)  NOT NULL,
    CONSTRAINT localidade_pk PRIMARY KEY (id_localidade)
);

-- Table: pedido
CREATE TABLE pedido (
    id_pedido int  NOT NULL,
    id_cliente int  NOT NULL,
    dt_pedido date  NOT NULL,
    vl_total decimal(8,2)  NOT NULL,
    CONSTRAINT pedido_pk PRIMARY KEY (id_pedido)
);

-- Table: produto
CREATE TABLE produto (
    id_produto int  NOT NULL,
    id_categoria int  NOT NULL,
    ds_produto varchar(50)  NOT NULL,
    qt_estoque int  NOT NULL,
    vl_produto decimal(8,2)  NOT NULL,
    CONSTRAINT produto_pk PRIMARY KEY (id_produto)
);

-- foreign keys
-- Reference: cliente_endereco (table: cliente)
ALTER TABLE cliente ADD CONSTRAINT cliente_endereco FOREIGN KEY cliente_endereco (id_endereco)
    REFERENCES endereco (id_endereco);

-- Reference: endereco_localidade (table: endereco)
ALTER TABLE endereco ADD CONSTRAINT endereco_localidade FOREIGN KEY endereco_localidade (id_localidade)
    REFERENCES localidade (id_localidade);

-- Reference: item_pedido (table: item)
ALTER TABLE item ADD CONSTRAINT item_pedido FOREIGN KEY item_pedido (id_pedido)
    REFERENCES pedido (id_pedido);

-- Reference: item_produto (table: item)
ALTER TABLE item ADD CONSTRAINT item_produto FOREIGN KEY item_produto (id_produto)
    REFERENCES produto (id_produto);

-- Reference: pedido_cliente (table: pedido)
ALTER TABLE pedido ADD CONSTRAINT pedido_cliente FOREIGN KEY pedido_cliente (id_cliente)
    REFERENCES cliente (id_cliente);

-- Reference: produto_categoria (table: produto)
ALTER TABLE produto ADD CONSTRAINT produto_categoria FOREIGN KEY produto_categoria (id_categoria)
    REFERENCES categoria (id_categoria);

-- End of file.

