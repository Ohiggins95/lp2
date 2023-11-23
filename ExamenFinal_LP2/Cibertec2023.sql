CREATE DATABASE CIBERTEC2023;
use CIBERTEC2023;

CREATE TABLE habitaciones (
  id INT NOT NULL AUTO_INCREMENT,
  número INT NOT NULL,
  tipo VARCHAR(50) NOT NULL,
  precio DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE clientes (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  teléfono VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE reservas (
  id INT NOT NULL AUTO_INCREMENT,
  cliente_id INT NOT NULL,
  habitación_id INT NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_fin DATE NOT NULL,
  total DOUBLE NOT NULL,
  estado VARCHAR(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cliente_id) REFERENCES clientes (id),
  FOREIGN KEY (habitación_id) REFERENCES habitaciones (id)
);