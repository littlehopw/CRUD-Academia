-- Criar o banco de dados se ele não existir
CREATE DATABASE IF NOT EXISTS academia_db;

-- Selecionar o banco de dados
USE academia_db;

-- Remover a tabela academia se ela já existir
DROP TABLE IF EXISTS academia;

-- Criar a tabela academia
CREATE TABLE academia (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE academia AUTO_INCREMENT = 1;

-- Verificar a tabela academia
SHOW TABLES;

-- Remover a tabela aluno_pagamento_mensalidade se ela já existir
DROP TABLE IF EXISTS aluno_pagamento_mensalidade;

-- Criar a tabela aluno_pagamento_mensalidade
CREATE TABLE aluno_pagamento_mensalidade (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    pessoa VARCHAR(255) NOT NULL,
    modalidade VARCHAR(255) NOT NULL,
    mensalidade_vigente VARCHAR(255) NOT NULL,
    valor_pago DOUBLE NOT NULL,
    data DATE NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE aluno_pagamento_mensalidade AUTO_INCREMENT = 1;

-- Verificar a tabela aluno_pagamento_mensalidade
SHOW TABLES;
