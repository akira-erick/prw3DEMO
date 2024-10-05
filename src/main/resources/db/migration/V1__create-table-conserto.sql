create table consertos(
    id bigint not null auto_increment,
    entrada varchar(20) not null,
    saida varchar(20) not null,
    nome varchar(100) not null,
    experiencia varchar(10) not null,
    marca varchar(30) not null,
    modelo varchar(30) not null,
    ano varchar(20) not null,

    primary key(id)
)