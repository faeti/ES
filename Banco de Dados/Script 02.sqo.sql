create table voceviu.pessoa (
	id_pessoa int auto_increment,
	nm_pessoa varchar(60),
	ds_email varchar(30),
	ds_telefone varchar(10),
	dt_nascimento date,
	primary key (id_pessoa)
);

alter table voceviu.usuario add id_pessoa int;

alter table voceviu.usuario add constraint fk__usuario__pessoa foreign key (id_pessoa) references pessoa(id_pessoa);
