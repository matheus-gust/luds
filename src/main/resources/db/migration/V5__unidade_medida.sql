create table unidade_medida (
    id uuid primary key not null,
    nome varchar(50)
);

alter table insumo rename column unidade_medida to unidade_medida_id;
alter table insumo alter column unidade_medida_id TYPE uuid USING unidade_medida_id::uuid;
alter table insumo add constraint insumo_unidade_medida_fk foreign key (unidade_medida_id) references unidade_medida(id);

