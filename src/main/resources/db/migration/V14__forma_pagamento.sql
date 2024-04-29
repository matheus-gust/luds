create table forma_pagamento (
    id uuid primary key not null,
    nome varchar(50) not null,
    tipo_pagamento_id uuid not null,
    constraint tipo_pagamento_forma_pagamento_fk foreign key (tipo_pagamento_id) references tipo_pagamento(id)
);