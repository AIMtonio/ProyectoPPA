create database Musicallife;
	use Musicallife;

create type sexo_ar as enum('F', 'M');

create table artista(
	id_artista serial primary key not null,
	nombre varchar(30),
	apellido varchar(30),
	nombre_artistico varchar(30),
	sexo_artista sexo_ar,
	fecha_nacimiento date,
	nacionalidad varchar(30)
);

create table disquera(
	id_disquera serial primary key not null,
	nombre varchar(30),
	direccion varchar(30),
	telefono bigint,
	correo varchar(40),
	fecha_creacion date
);

create table album(
	id_album serial primary key not null,
	nombre varchar(30),
	artista int references artista ON DELETE CASCADE ON UPDATE CASCADE,
	disquera int references disquera ON DELETE CASCADE ON UPDATE CASCADE,
	genero varchar(30),
	duracion float,
	fecha_lanzamiento date
);

alter table album add foreign key (artista) references artista(id_artista);
alter table album add foreign key (disquera) references disquera(id_disquera);





select * from artista;
select * from disquera;
select * from album;







