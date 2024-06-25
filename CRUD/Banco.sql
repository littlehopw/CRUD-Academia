CREATE DATABASE IF NOT EXISTS academia_db;
USE academia_db;

-- ACADEMIA
CREATE TABLE academia (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE academia AUTO_INCREMENT = 1;

-- ALUNO PAGAMENTO MENSALIDADE
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
ALTER TABLE registros_academia AUTO_INCREMENT = 1;