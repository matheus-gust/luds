create table categoria_cardapio (
    id uuid primary key not null,
    codigo varchar(60),
    nome varchar(50)
);

create table item_cardapio (
    id uuid primary key not null,
    codigo varchar(60),
    nome varchar(50),
    descricao text,
    valor numeric(10,2),
    tamanho varchar(20),
    imagem bytea,
    categoria_cardapio_id uuid not null,
    constraint item_cardapio_categoria_cardapio_id_fk foreign key (categoria_cardapio_id) references categoria_cardapio(id)
);