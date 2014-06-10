insert into voceviu.pessoa(nm_pessoa, ds_email, ds_telefone, dt_nascimento)
values ("Rafael", "rafael@fae.com", "9988776655", current_date());

insert into voceviu.usuario(nm_usuario, ds_senha, id_pessoa)
values ("rafael", "rafael", 1);

commit