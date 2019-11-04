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
	artista int,
	disquera int,
	genero varchar(30),
	duracion time,
	fecha_lanzamiento date,
	on update cascade on delete cascade
);

alter table album add foreign key (artista) references artista(id_artista);
alter table album add foreign key (disquera) references disquera(id_disquera);


-- Registros de nacionalidad --




insert into disquera (nombre, direccion, telefono, correo, fecha_creacion) 
	values('trapcarnales','gdl jalisco','5510725285','robertomx@gmail.com','2008-07-15');
insert into disquera (nombre, direccion, telefono, correo, fecha_creacion)
 values('alonsomusic','cdmx','5510727166','antoniomc159807@gmail.com','2008-07-15');
insert into disquera (nombre, direccion, telefono, correo, fecha_creacion) values('lizetmusic','san bartolo','5510727521','lizet123@gmail.com','2008-07-15');

select * from artista;
select * from disquera;
select * from album;



insert into album values(1,'hilda','trap',1,1,
						 'trap',45.02,'2019-09-30','imagen');
						 





