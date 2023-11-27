alter table insumo rename column fornecedor to fornecedor_id;
alter table insumo alter column fornecedor_id TYPE uuid USING fornecedor_id::uuid;
alter table insumo add constraint insumo_fornecedor_fk foreign key (fornecedor_id) references fornecedor(id);


