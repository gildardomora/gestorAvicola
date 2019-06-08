-- create database granja_avicola;	

CREATE TABLE tipo_ave (
IdAve serial NOT NULL,
Nombre varchar (35) NOT NULL,
PRIMARY KEY (IdAve)
);

create table galpon (
IdGalpon int not null,
IdAve  int not null,
F_Inicio varchar(35) not null,
saldo int not null,
Descripcion varchar (255),
Estado varchar (35),
PRIMARY KEY (IdGalpon),
FOREIGN KEY (IdAve) REFERENCES tipo_ave (IdAve)
);

CREATE TABLE entrada (
IdEntrada serial NOT NULL,
IdGalpon int NOT NULL,
Fecha varchar(35),
HSaldo int,
Cantidad int,
Descripcion varchar (255),
PRIMARY KEY (idEntrada),
FOREIGN KEY (IdGalpon) REFERENCES galpon (IdGalpon)
);

CREATE TABLE salida (
IdSalida serial NOT NULL,
IdGalpon int NOT NULL,
Fecha varchar(35),
HSaldo int,
Cantidad int,
Descripcion varchar (255),
PRIMARY KEY (IdSalida),
FOREIGN KEY (IdGalpon) REFERENCES galpon (IdGalpon)
);


create table producto (
IdProducto serial NOT NULL,
Nombre varchar (35),
UniMedida varchar (35),
descripcion varchar (255),
preciounimed int,
stock int,
PRIMARY KEY (IdProducto)
);

create table produccion (
IdProduccion  SERIAL not null,
IdGalpon int not null,
IdProducto int not null,
Cantidad int not null,
fecha varchar (35),
PRIMARY KEY (IdProduccion),
FOREIGN KEY (IdGalpon) REFERENCES galpon (IdGalpon),
FOREIGN Key (IdProducto) REFERENCES producto (IdProducto)

);

create table venta (
IdVenta serial NOT NULL,
Cantidad int ,
Descripcion varchar(255),
ValorVenta int,
fecha varchar(30),
PRIMARY KEY (IdVenta)
);

create table persona (
  
  cedula_persona varchar(20) not null,
  nombre_persona VARCHAR(35) NOT NULL,
  apellido_persona varchar(35) not null,
  direccion VARCHAR(45) NOT NULL,
  celular VARCHAR(35),
  email VARCHAR(45),
  sexo VARCHAR(25) not null ,
  primary key (cedula_persona)
);
create table usuario (
cod_usuario serial not null,
cedula_persona varchar(20) not null,
login varchar not null,
password varchar (45) not null,
estado varchar(45) not null,
tipo_usuario varchar (45),
primary key (cod_usuario),
FOREIGN KEY (cedula_persona) REFERENCES persona (cedula_persona) on update cascade
);
create table cliente (
  cod_cliente serial not null,
  cedula_persona varchar (20) not null,
  primary key  (cod_cliente),
  FOREIGN KEY (cedula_persona) REFERENCES persona (cedula_persona) on update cascade
 );
 
 create table detalle_venta (
IdDetalle serial NOT NULL,
IdProducto int NOT NULL,
IdVenta serial NOT NULL,
cod_cliente int,
cod_usuario int not null,
cant_disponible int,
PRIMARY KEY (IdDetalle),
FOREIGN KEY (IdProducto) REFERENCES producto (IdProducto),
FOREIGN KEY (IdVenta) REFERENCES venta (IdVenta) on update cascade,
FOREIGN KEY (cod_cliente) REFERENCES cliente (cod_cliente),
FOREIGN KEY (cod_usuario) REFERENCES usuario (cod_usuario)
);


-----------------------------------

--------------------------------------------------
-------------------------------------------------
--/*-- borrar tablas
drop table galpon cascade;
drop table entrada cascade;
drop table salida cascade;
drop table venta cascade;
drop table tipo_ave cascade;
drop table produccion cascade;
drop table producto cascade;

drop table detalle_venta cascade;
drop table usuario cascade;
drop table persona cascade;
drop table cliente cascade;
-----------------------
*/
/*
-- agregue campo descripcion que me faltaba // tabla producto
alter table "producto" add column "descripcion" varchar (30);

--agregue campo fecha que me faltaba  //tabla venta
alter table "venta" add column "fecha" varchar(30);

--agregue campo precio unidad de medida  //tabla producto
alter table "producto" add column "preciounimed" int;
--camopo agregado a detalle de venta
alter table "detalle_venta" add column "cant_disponible" int;

-- campo stock agregado a la tabla producto
alter table "producto" add column "stock" int;
------------------------------------

 --insertando datos 

--tabla tipo_ave--
insert into tipo_ave values ('1','Gallina Ponedora');
insert into tipo_ave values ('2','Pollita Ponedora');
insert into tipo_ave values ('3','Pollo blanco');
insert into tipo_ave values ('4','Gallina criolla');
insert into tipo_ave values ('5','Codorniz');

-- tabla galpon--
insert into galpon values ('1','1','2018-10-19','25','primer galpon','cerrado');
insert into galpon values ('2','3','2018-09-01','17','segundo galpon','activo');
insert into galpon values ('3','2','2018-09-01','16','tercer galpon','activo');
insert into galpon values ('4','1','2018-09-01','18','cuarto galpon','suspendido');
insert into galpon values ('5','4','2018-09-01','20','quinto galpon','mantenimiento');

-- tabla entrada --
insert into entrada values ('1','2018-10-19','35','aumento de gallinas');
insert into entrada values ('1','2018-10-19','35','aumento de gallinas');
insert into entrada values ('1','2018-10-19','14','aumento de gallinas');
insert into entrada values ('2','2018-10-19','22','aumento de gallinas');
insert into entrada values ('3','2018-10-19','25','ingreso de pollo blanco');
insert into entrada values ('1','2018-10-19','10','aumento de gallinas');
insert into entrada values ('1','2018-10-19','12','aumento de gallinas');
insert into entrada values ('1','2018-10-19','50','aumento de gallinas');

--tabla salida --
insert into salida (idgalpon,fecha,cantidad,descripcion) values ('1','2018-10-19','10','mortalidad');
insert into salida values ('1','2018-10-19','10','mortalidad');

-- tabla producto ---
insert into producto values ('1','Huevo','unidad','Huevos de produccion','500');
insert into producto values ('2','pollo','libra','carne de pollo blanco','4000');



--tabla venta --
insert into venta values ('1','1000','primer venta','500000','2018-10-19');
insert into venta values ('2','20','segunda venta','80000','2018-10-18');
insert into venta values ('3','10','tercer venta','5000','2018-10-18');
insert into venta values ('4','30','cuarta venta','15000','2018-10-19');
insert into venta values ('5','15','quinta venta','60000','2018-10-19');

-- tabla produccion --
insert into produccion (IdGalpon,IdProducto,cantidad,fecha) values ('1','1','25','2018-10-19');

--tabla detalle_venta
insert into detalle_venta values ('01','1','1')
------------------------------------
--VACIAR TABLAS 

-- Vaciar tabla tipo-ave --
truncate table tipo_ave cascade;

-- Vaciar tabla galpon--
truncate table galpon cascade;

-- vaciar tabla producto --
truncate table producto cascade;

-- vaciar tabla salida--
truncate table salida cascade;

-- vaciar tabla entrada--
truncate table entrada cascade;

-- vaciar tabla produccion---
truncate table produccion cascade;

-- vaciar tabla venta --
truncate table venta cascade;
--vaciar tabla detalle_venta
truncate table detalle_venta cascade;
 truncate table usuario cascade;
 truncate table persona cascade;
 truncate table cliente cascade;
  


------------------------------------

-- CONSULTAS 

select * from galpon order by idgalpon;
select * from tipo_ave
select * from entrada
select * from salida
select * from producto
select * from venta
select * from produccion
select * from detalle_venta
select * from persona;
--select * from detalle_venta
---------------------------------------------------------
-- Consulta avanzada

-- saldo mayor a 20
Select * from "galpon" where "saldo" >20;

-- saldo mayor a 10 y menor a 20
Select * from "galpon" where "saldo" >10 and "saldo" <20;

--( saldo mayor a 10 y menor a 20 ) o la fecha de inicio sea igual a 2018-09-01
Select * from "galpon" where ("saldo" >10 and "saldo" <20 )or "f_inicio"='2018-09-01';


-- nuestra fecha registros que no sean de la fecha 
Select * from "galpon" where Not "f_inicio"='2018-09-01';

--
SELECT sum("cantidad") AS "TOTAL Productos Vendidos " FROM "venta" ;

select "fecha", sum("cantidad") as "total producto" from "venta" group by "fecha";

select idgalpon, galpon.idave,tipo_ave.nombre as ave, f_inicio, saldo, descripcion from galpon inner join tipo_ave on galpon.idave=tipo_ave.idave  where tipo_ave.nombre like '%%' order by idgalpon;

select * from galpon
--
Select  * from "venta";
select "idproducto", "cantidad" from "venta" where "valorventa">5000 group by "idproducto", "cantidad" having "cantidad">10;

--

select idproducto, max(cantidad) from "venta" group by idproducto

-- contar registros de la tabla
select count (*) from venta;


----------------
insert into venta values  ('6','20','sexta venta','10000','2018-10-20');
update "galpon" set "descripcion"='Galpon iniciado' where "idgalpon"=1;




select "idgalpon","nombre","f_inicio","saldo" from "galpon" inner join "tipo_ave" on "galpon"."idave" = "tipo_ave"."idave";

update galpon set estado ='Activo';


insert into galpon (idgalpon,idave,f_inicio) values (9,(select idave from tipo_ave where nombre = 'Gallina Ponedora'),'2018-09-12') ;


select idave from tipo_ave where nombre = 'Gallina Ponedora'

select nombre,f_inicio,saldo,identrada,fecha,cantidad,entrada.descripcion from (galpon 
 inner join tipo_ave on galpon.idave=tipo_ave.idave inner join entrada on "entrada"."idgalpon"="galpon"."idgalpon") where ( "entrada"."idgalpon") = '2';
        
insert into entrada (idgalpon,fecha,cantidad,descripcion) values ( '1','2017-02-13','34','fr');


select * from venta

insert into venta (idventa,cantidad,descripcion,valorventa,fecha) values('1','5','',(select sum (preciounimed*'5') from producto where nombre like '%Huevo%'),'2018')


select saldo from galpon where idgalpon='1'

update galpon set saldo = 320 -5 where idgalpon ='1';


select idgalpon,tipo_ave.nombre, f_inicio, saldo, descripcion,estado from galpon inner join tipo_ave on galpon.idave=tipo_ave.idave  where saldo  convert varchar like '%8%' or descripcion like '%8%' order by idgalpon 

select * from galpon


select venta.idventa from detalle_venta inner join venta on detalle_venta.idventa = venta.idventa where idproducto=1


select count(stock) as cantidad from producto where nombre='*' 
*/
  
