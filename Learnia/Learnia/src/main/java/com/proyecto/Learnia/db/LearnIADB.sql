drop database if exists Learnia_db_in5bm;
create database Learnia_db_in5bm;
use Learnia_db_in5bm;

create table usuario(
	id_usuario bigint  auto_increment  primary key,
    nombre_usuario varchar(100) not null,
    apellido_usuario varchar(100) not null,
    correo_usuario varchar(100) not null unique,
    contrasena varchar(150) not null,
	fecha_registro datetime,
    rol enum("ADMIN", "MODERADOR", "ESTUDIANTE") not null,
    foto varchar(255) null
);


create table categoria(
id_categoria bigint auto_increment primary key,
nombre varchar(100) ,
descripcion text
);

create table Recurso(
id_recurso bigint auto_increment primary key,
titulo_recurso varchar(200) not null,
descripcion_recurso text,
tipo_recurso enum("documento" , "presentacion" , "audio") not null,
url_archivo varchar(255) not null,
fecha_subida datetime default current_timestamp,
id_usuario bigint not null,
id_categoria bigint not null,
constraint fk_id_usuario
foreign key (id_usuario) 
references usuario(id_usuario),
constraint fk_id_categoria
foreign key (id_categoria) 
references categoria(id_categoria)
On delete cascade
);


create table pregunta(
id_pregunta bigint auto_increment primary key,
titulo varchar(200) not null,
descripcion text not null,
fecha_publicacion datetime default current_timestamp,
id_usuario bigint not null,
id_categoria bigint not null,
constraint fk_id_usuarios
foreign key (id_usuario) 
references usuario(id_usuario),
constraint fk_id_categorias
foreign key (id_categoria) 
references categoria(id_categoria)
on delete cascade
);

create table respuesta(
id_respuesta bigint auto_increment primary key,
contenido text not null,
fecha_respuesta datetime default current_timestamp,
id_usuario bigint not null,
id_pregunta bigint not null,
constraint fk_respuesta_usuario
foreign key (id_usuario)
references usuario(id_usuario)
on delete cascade,
constraint fk_respuesta_pregunta
foreign key (id_pregunta)
references pregunta(id_pregunta)
on delete cascade
);

Create table Comentario(
id_comentario bigint auto_increment primary key,
contenido text not null,
fecha datetime default current_timestamp,
id_usuario bigint not null,
id_recurso bigint null,
id_respuesta bigint null,
constraint fk_usuario
foreign key (id_usuario)
references usuario(id_usuario),
constraint fk_respuesta
foreign key (id_respuesta)
references respuesta(id_respuesta),
constraint fk_recurso
foreign key (id_recurso)
references recurso(id_recurso)
on delete cascade
);
 
Create table voto(
id_voto bigint auto_increment primary key,
tipo enum('like', 'dislike') not null,
id_usuario bigint not null,
id_respuesta bigint not null,
constraint fk_idusuario
foreign key (id_usuario)
references usuario(id_usuario),
constraint fk_id_respuesta
foreign key (id_respuesta)
references respuesta(id_respuesta)
on delete cascade
);

insert into Usuario(nombre_usuario, apellido_usuario, correo_usuario, contrasena, rol, foto) values("primer_usuarioO", "apellido_usuario", "correooO", "123", "MODERADOR", "foto");
insert into Categoria(nombre, descripcion) values("pdf", "archivo");
insert into Recurso(titulo_recurso, descripcion_recurso, tipo_recurso, url_archivo, fecha_subida, id_usuario, id_categoria) values("pdf", "archivo pdf", "documento", "url archivo", "2025-02-02",1, 1);
insert into Pregunta(id_pregunta, titulo, descripcion
, fecha_publicacion, id_usuario, id_categoria) values("1", "que es spring boot?", "Spring Boot es un framework", "2025-02-22", "1", "1");
insert into Respuesta(id_respuesta, contenido, fecha_respuesta, id_usuario, id_pregunta)values("1", "spring boot", "2025-02-23", "1", "1");
insert into Comentario(contenido, fecha, id_usuario, id_recurso, id_respuesta)values( "Excelente", "2025-10-12", "1", "1", "1"); 
insert into voto(tipo, id_usuario, id_respuesta)values("like", "1", "1");

 