ALTER TABLE compra ADD COLUMN IF NOT EXISTS forma_pagamento_id uuid;
ALTER TABLE compra ADD CONSTRAINT compra_forma_pagamento_fk foreign key (forma_pagamento_id) references forma_pagamento(id);