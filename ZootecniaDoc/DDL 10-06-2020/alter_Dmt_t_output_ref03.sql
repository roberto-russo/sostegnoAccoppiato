ALTER TABLE dmt_t_output_ref03 RENAME COLUMN importo_pagato TO imp_pagato_lordo_decurt;
ALTER TABLE dmt_t_output_ref03 ADD imp_pagato_netto_decurt NUMBER(10,2);
ALTER TABLE dmt_t_output_ref03 ADD percentuale_decurtazione NUMBER(5,2);
