-- Criar o banco de dados se ele não existir
CREATE DATABASE IF NOT EXISTS academia_db;

-- Selecionar o banco de dados
USE academia_db;

-- Remover a tabela se ela já existir
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

-- Remover a tabela se ela já existir
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

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS avaliacao_fisica;

CREATE TABLE avaliacao_fisica (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    pessoa VARCHAR(255) NOT NULL,
    ultimo_treino VARCHAR(255) NOT NULL,
    peso VARCHAR(255) NOT NULL,
    altura VARCHAR(255) NOT NULL,
    imc VARCHAR(255) NOT NULL,
    satisfacao VARCHAR(255) NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE avaliacao_fisica AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS divisao_treino;

CREATE TABLE divisao_treino (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE divisao_treino AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS divisao_treino_musculo;

CREATE TABLE divisao_treino_musculo (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    divisao_treino TEXT NOT NULL,
    descricao TEXT NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE divisao_treino_musculo AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS entrada_aluno;

CREATE TABLE entrada_aluno (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    data DATETIME NOT NULL,
    nascimento VARCHAR(255) NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE entrada_aluno AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS exercicio;

CREATE TABLE exercicio (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao_foto VARCHAR(255) NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE exercicio AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS exercicio_aplicacao;

CREATE TABLE exercicio_aplicacao (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE exercicio_aplicacao AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS mensalidade_vigente;

CREATE TABLE mensalidade_vigente (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10, 2) NOT NULL,
    inicio DATE NOT NULL,
    termino DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE mensalidade_vigente AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS movimentacao_financeira;

CREATE TABLE movimentacao_financeira (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10, 2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    descricao VARCHAR(255) NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE movimentacao_financeira AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS pagamento_recorrente;

CREATE TABLE pagamento_recorrente (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    pessoa VARCHAR(100) NOT NULL,
    data DATE NOT NULL,
    cartao_de_credito VARCHAR(100),
    valor DECIMAL(10, 2) NOT NULL,
    meses_autorizados INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE pagamento_recorrente AUTO_INCREMENT = 1;

-- Remover a tabela se ela já existir
DROP TABLE IF EXISTS pessoa;

CREATE TABLE pessoa (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    nascimento DATE NOT NULL,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    tipo_usuario VARCHAR(50) NOT NULL,
    data_criacao DATE NOT NULL,
    data_modificacao DATE NOT NULL
);

-- Inicializar serial (auto_increment) para id
ALTER TABLE pessoa AUTO_INCREMENT = 1;