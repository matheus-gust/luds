create table contas_pagar (
    id uuid primary key not null,
    nome varchar(50) not null,
    valor numeric(10,2) not null,
    pago varchar(1) not null,
    data_vencimento varchar(50) not null,
    forma_pagamento_id uuid not null,
    constraint forma_pagamento_contas_pagar_fk foreign key (forma_pagamento_id) references forma_pagamento(id)
);