create table unidade (
    id uuid primary key not null,
    codigo varchar(60),
    localidade varchar(50),
    nome varchar(50),
    cnpj varchar(60)
);

create table insumo (
    id uuid primary key not null,
    codigo varchar(60),
    nome varchar(50),
    fornecedor varchar(60),
    custo_compra numeric(10,2),
    valor_venda numeric(10,2),
    unidade_medida varchar(50)
);

create table solicitacao_insumo (
    id uuid primary key not null,
    quantidade_solicitada numeric(10,2),
    unidade_id uuid not null,
    insumo_id uuid not null,
    constraint solicitacao_insumo_unidade_id_fk foreign key (unidade_id) references unidade(id),
    constraint solicitacao_insumo_insumo_id_fk foreign key (insumo_id) references insumo(id)
)