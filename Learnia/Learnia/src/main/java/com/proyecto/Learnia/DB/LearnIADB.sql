drop database if exists Learnia_db;
create database Learnia_db;
use Learnia_db;

create table usuario(
	id_usuario bigint  auto_increment  primary key,
    nombre_usuario varchar(100) not null,
    apellido_usuario varchar(100) not null,
    correo_usuario varchar(100) not null unique,
    contrasena varchar(150) not null,
	fecha_registro datetime,
    rol enum("admin", "moderador", "estudiante") not null,
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
 