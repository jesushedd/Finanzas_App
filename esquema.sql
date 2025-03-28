CREATE DATABASE finanzas;

USE DATABASE finanzas;

CREATE TABLE categorias (
	id TINYINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(75) NOT NULL UNIQUE
);


CREATE TABLE movimientos (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	monto DECIMAL (16,4) NOT NULL,
	tipo ENUM('ingreso', 'egreso'),
	fecha DATE NOT NULL,
	categoria_id TINYINT NOT NULL,
	FOREIGN KEY (categoria_id) REFERENCES categorias (id)
);
	