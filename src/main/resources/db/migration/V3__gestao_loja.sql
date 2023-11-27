create table fornecedor (
    id uuid primary key not null,
    codigo varchar(60),
    nome varchar(50),
    fornecedor varchar(60),
    dia_entrega_prev numeric(5),
    dia_entrega_semana varchar(10),
    endereco varchar(255)
);