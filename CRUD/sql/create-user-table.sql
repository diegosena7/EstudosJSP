CREATE DATABASE crudUsuarios;
USE crudUsuarios;

create table usuarios (
	id  int(3) NOT NULL AUTO_INCREMENT,
	nome varchar(120) NOT NULL,
	email varchar(220) NOT NULL,
	pais varchar(120),
	PRIMARY KEY (id)
);

