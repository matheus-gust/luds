create table venda (
    id uuid primary key not null,
    boletim varchar(20),
    data varchar(50),
    origem varchar(15),
    valor numeric(10,2)
);

create table venda_item_cardapio (
    id uuid primary key not null,
    venda_id uuid not null,
    item_cardapio_id uuid not null,
    variacao_cardapio_id uuid not null,
    quantidade numeric(10),
    valor_total numeric(10,2),
    constraint venda_item_cardapio_venda_fk foreign key (venda_id) references venda(id),
    constraint venda_item_cardapio_item_cardapio_fk foreign key (item_cardapio_id) references venda(id),
    constraint venda_item_cardapio_variacao_fk foreign key (variacao_cardapio_id) references venda(id)
)