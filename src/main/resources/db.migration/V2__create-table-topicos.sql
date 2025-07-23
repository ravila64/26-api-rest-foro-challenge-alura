create table topicos(
    id bigint not null auto_increment,
    titulo varchar(80) not null  unique,
    mensaje varchar(100) not null unique,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    curso varchar(80) not null,
    autor_id bigint not null,
    primary key(id),
    constraint fk_topicos_autores_id foreign key(autor_id) references autores(id)
);