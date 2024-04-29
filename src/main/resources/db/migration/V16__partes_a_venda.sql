create table parte (
    id uuid primary key not null,
    nome varchar(50) not null,
    venda_id uuid not null,
    valor_parte numeric(10,2),
    constraint parte_venda_fk foreign key (venda_id) references venda(id)
);

ALTER TABLE venda_item_cardapio DROP CONSTRAINT IF EXISTS venda_item_cardapio_venda_fk, DROP COLUMN IF EXISTS venda_id;

TRUNCATE TABLE venda CASCADE;
TRUNCATE TABLE venda_item_cardapio CASCADE;

ALTER TABLE venda_item_cardapio ADD COLUMN IF NOT EXISTS parte_id uuid not null;
ALTER TABLE venda_item_cardapio DROP CONSTRAINT IF EXISTS venda_item_cardapio_parte_fk;
ALTER TABLE venda_item_cardapio ADD CONSTRAINT venda_item_cardapio_parte_fk foreign key (parte_id) references parte(id);