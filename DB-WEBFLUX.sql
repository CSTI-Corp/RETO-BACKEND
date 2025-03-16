DROP DATABASE IF EXISTS retospringwebflux;

CREATE DATABASE retospringwebflux

CREATE TABLE solicitud (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(20) UNIQUE NOT NULL,
    marca VARCHAR(100) NOT NULL,
    tipo_solicitud VARCHAR(100) NOT NULL,
    fecha_envio TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    numero_contacto VARCHAR(15) NOT NULL,
    nombre_contacto VARCHAR(100) NOT NULL
);


CREATE TABLE contactos_solicitud (
    id SERIAL PRIMARY KEY,
    solicitud_id INT NOT NULL,
    nombre_contacto VARCHAR(100) NOT NULL,
    numero_contacto VARCHAR(15) NOT NULL,
    FOREIGN KEY (solicitud_id) REFERENCES solicitud(id) ON DELETE CASCADE
);