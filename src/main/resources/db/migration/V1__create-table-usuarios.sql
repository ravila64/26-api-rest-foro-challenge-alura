CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    clave VARCHAR(255) NOT NULL,
    activo BOOLEAN NOT NULL,
    primary key(id)
);
