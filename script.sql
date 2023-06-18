CREATE EXTENSION postgis;
create table ranking(
id serial ,
puntos integer,
id_voluntario integer,
id_tarea integer
);

create table institucion(
id serial,
nombre varchar(100),
direccion varchar(100)
);

create table emergencia(
id serial,
nombre varchar(100),
estado varchar(100),
id_institucion integer
);
SELECT AddGeometryColumn('emergencia','location','4326','POINT',2);

create table voluntario(
id serial ,
nombre varchar(50),
apellido varchar(50),
fecha_nacimiento date,
edad integer,
rut integer,
num_contacto integer
);

create table vol_habilidad(
id serial,
id_voluntario integer,
id_habilidad integer
);

create table emergencia_habilidad(
id serial,
id_emergencia integer, 
id_habilidad integer
);



create table habilidad(
id serial unique,
nombre varchar(50)
);

create table tarea_habilidad(
id serial,
id_eme_habilidad integer,
id_tarea integer
);

create table tarea(
id serial,
nombre varchar (50),
descripcion varchar(200),
cantd_voluntarios integer,
id_eme integer,
id_estado_tarea integer
);
SELECT AddGeometryColumn('tarea','location','4326','POINT',2);


create table estado_tarea(
id serial,
estado varchar(100)
);


CREATE TABLE "division_regional" (gid serial,
"nom_reg" varchar(50),
"nom_prov" varchar(20),
"cod_com" varchar(5),
"nom_com" varchar(30),
"cod_regi" numeric,
"superficie" numeric,
"poblac02" int4,
"pobl2010" int4,
"shape_leng" numeric,
"shape_area" numeric);
ALTER TABLE "division_regional" ADD PRIMARY KEY (gid);
SELECT AddGeometryColumn('','division_regional','geom','0','MULTIPOLYGON',2);
SELECT UpdateGeometrySRID('public', 'division_regional', 'geom', 4326);