create table categoria_cardapio (
    id uuid primary key not null,
    codigo varchar(60),
    nome varchar(50)
);

create table adicional_cardapio (
    id uuid primary key not null,
    codigo varchar(60),
    nome varchar(50),
    categoria_cardapio_id uuid not null,
    constraint adicional_cardapio_categoria_cardapio_fk foreign key (categoria_cardapio_id) references categoria_cardapio(id)
);

create table variacao_cardapio (
    id uuid primary key not null,
    nome varchar(50),
    variacao_cardapio_id uuid not null,
    constraint variacao_cardapio_categoria_cardapio_fk foreign key (variacao_cardapio_id) references categoria_cardapio(id));

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

create table item_cardapio_adicional_cardapio (
    id uuid primary key not null,
    item_cardapio_id uuid not null,
    adicional_cardapio_id uuid not null,
    constraint item_cardapio_adicional_cardapio_id_fk foreign key (item_cardapio_id) references item_cardapio(id),
    constraint adicional_cardapio_item_cardapio_id_fk foreign key (adicional_cardapio_id) references adicional_cardapio(id)
);

create table item_cardapio_variacao_cardapio (
    id uuid primary key not null,
    item_cardapio_id uuid not null,
    variacao_cardapio_id uuid not null,
    constraint item_cardapio_variacao_cardapio_id_fk foreign key (item_cardapio_id) references item_cardapio(id),
    constraint variacao_cardapio_item_cardapio_id_fk foreign key (variacao_cardapio_id) references variacao_cardapio(id)
);