create database Musicallife;
	use Musicallife;
	
create table artista(
	id_artista int not null,
	nombre varchar(30),
	apellido varchar(30),
	nombre_artistico varchar(30),
	fecha_nacimiento date,
	nacionalidad varchar(30),
primary key (id_artista)
);

create table disquera(
	id_disquera int not null,
	nombre varchar(30),
	direccion varchar(30),
	clave varchar(30),
	telefono varchar(30),
	correo varchar(30),
	fecha_creacion date,
	primary key (id_disquera)
);

create table album(
	id_album int not null,
	nombre varchar(30),
	tipo varchar(30),
	artista int,
	disquera int,
	genero varchar(30),
	duracion float,
	fecha_lanzamiento date,
	imagen varchar(50),
primary key (id_album)
);

alter table album add foreign key (artista) references artista(id_artista);
alter table album add foreign key (disquera) references disquera(id_disquera);

select * from album;

insert into artista values(1,'roberto','gonzales','hotspanish','1998-07-15','mexicano');
insert into disquera values(1,'trapcarnales','gdl jalisco','2490x','5510727166','correo','2008-07-15');

insert into album values(1,'hilda','trap',1,1,
						 'trap',45.02,'2019-09-30','imagen');
						 
select * from artista;
select * from disquera;
select * from album;