create table cliente (
    id uuid primary key not null,
    nome varchar(100),
    telefone varchar(20),
    telefone_alternativo varchar(20),
    endereco varchar(255),
    data_nascimento varchar(50)
);