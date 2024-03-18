ALTER TABLE compra_insumo ALTER COLUMN quantidade TYPE numeric(10,3);
ALTER TABLE compra_insumo ADD COLUMN desconto numeric(10,2) DEFAULT 0.00;