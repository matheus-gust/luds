create table compra (
    id uuid primary key not null,
    boletim varchar(20),
    data varchar(50),
    fornecedor_id uuid not null,
    constraint compra_fornecedor_fk foreign key (fornecedor_id) references fornecedor(id)
);

create table compra_insumo (
    id uuid primary key not null,
    compra_id uuid not null,
    insumo_id uuid not null,
    quantidade numeric(10),
    valor numeric(10,2),
    constraint compra_insumo_compra_fk foreign key (compra_id) references compra(id),
    constraint compra_insumo_insumo_fk foreign key (insumo_id) references insumo(id)

)