create table topicos(
    id bigint not null auto_increment,
    mensaje varchar(100) not null,
    curso varchar(80) not null,
    titulo varchar(80) not null,
    usuario_id bigint not null,;
    primary key(id),
    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id)
);