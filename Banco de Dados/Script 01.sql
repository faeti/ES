create database voceviu;

create table voceviu.usuario (
	id_usuario int auto_increment,
	nm_usuario varchar(20) not null,
	ds_senha varchar(10) not null,
	primary key (id_usuario)
);

create table voceviu.localidade (
	id_localidade int auto_increment,
	nr_exibicao_minima int,
	nr_publico_mensal int,
	qt_pontos int,
	nr_tempo_spot double,
	tp_publico char(1),
	dt_horario_funcionamento datetime,
	primary key (id_localidade)
);

create table voceviu.ponto (
	id_ponto int auto_increment,
	ds_ip varchar(20),
	ds_mac varchar(20),
	id_localidade int,
	primary key (id_ponto),
	constraint fk__ponto__localidade foreign key (id_localidade) references voceviu.localidade(id_localidade)
);

create table voceviu.anuncio (
	id_anuncio int auto_increment,
	ds_anuncio varchar(500),
	id_localidade int,
	ob_arquivo blob,
	fl_aprovado boolean,
	ds_observacao varchar(200),
	primary key (id_anuncio),
	constraint fk__anuncio__localidade foreign key (id_localidade) references voceviu.localidade(id_localidade)
);