-- create database granja_avicola;	

CREATE TABLE tipo_ave (
id_ave serial NOT NULL,
nombre_ave varchar (40) NOT NULL,
descripcion_ave varchar(255),
PRIMARY KEY (id_ave)
);

create table galpon (
id_galpon int not null,
id_ave  int not null,
fecha_apertura varchar(35) not null,
saldo_galpon int not null,
descripcion_galpon varchar (255),
estado_galpon varchar (35),
PRIMARY KEY (id_galpon),
FOREIGN KEY (id_ave) REFERENCES tipo_ave (id_ave)
);

CREATE TABLE entrada (
id_entrada serial NOT NULL,
id_galpon int NOT NULL,
fecha_entrada varchar(35),
saldo_aves int,
cantidad_entrada int,
descripcion_entrada varchar (255),
PRIMARY KEY (id_entrada),
FOREIGN KEY (id_galpon) REFERENCES galpon (id_galpon)
);

CREATE TABLE salida (
id_salida serial NOT NULL,
id_galpon int NOT NULL,
fecha_salida varchar(35),
saldo_aves int,
cantidad_salida int,
descripcion_salida varchar (255),
PRIMARY KEY (id_salida),
FOREIGN KEY (id_galpon) REFERENCES galpon (id_galpon)
);

create table stock_producto (
id_stock_producto serial not null,
cantidad_stock int,
PRIMARY KEY (id_stock_producto)
);

create table producto (
id_producto serial NOT NULL,
nombre_producto varchar (35),
uni_medida_producto varchar (35),
descripcion_producto varchar (255),
precio_uni_producto int,
id_stock_producto serial,
categoria_producto varchar(35),
PRIMARY KEY (id_producto),
FOREIGN KEY (id_stock_producto) REFERENCES stock_producto (id_stock_producto)
);

create table stock_historial (
id_stock_historial serial not null,
id_stock_producto int not null,
fecha_modificado varchar(20),
nombre_usuario varchar(35),
cantidad_previa int,
PRIMARY KEY (id_stock_historial),
FOREIGN KEY (id_stock_producto) REFERENCES stock_producto (id_stock_producto)
);

create table produccion (
id_produccion  SERIAL not null,
id_galpon int not null,
id_producto int not null,
cantidad_producto int not null,
fecha_produccion varchar (35),
PRIMARY KEY (id_produccion),
FOREIGN KEY (id_galpon) REFERENCES galpon (id_galpon),
FOREIGN Key (id_producto) REFERENCES producto (id_producto)

);

create table gasto(
id_gasto SERIAL NOT NULL,
nombre_gasto varchar(255),
valor_gasto int,
categoria_gasto varchar(125),
descripcion_gasto varchar(255),
PRIMARY KEY (id_gasto)
);

create table gasto_galpon(
id_gasto_galpon SERIAL NOT NULL,
id_galpon int,
id_gasto SERIAL,
fecha_gasto_galpon varchar(35),
cantidad_gasto_galpon int,
total_gasto_galpon int,
FOREIGN KEY (id_galpon) REFERENCES galpon (id_galpon),
FOREIGN KEY (id_gasto) REFERENCES gasto (id_gasto)
);

create table venta (
id_venta serial NOT NULL,
cantidad_venta int ,
descripcion_venta varchar(255),
valor_venta int,
fecha_venta varchar(30),
cod_usuario int,
cod_cliente int,
pago_venta varchar(255),
descuento int,
PRIMARY KEY (id_venta)
);

create table persona (
  
  cedula_persona varchar(20) not null,
  nombre_persona VARCHAR(50) NOT NULL,
  apellido_persona varchar(50) not null,
  direccion_persona VARCHAR(50) NOT NULL,
  celular_persona VARCHAR(35),
  email_persona VARCHAR(45),
  sexo_persona VARCHAR(25) not null ,
  primary key (cedula_persona)
);

create table usuario (
cod_usuario serial not null,
cedula_persona varchar(20) not null,
login varchar not null,
password varchar (45) not null,
estado_usuario varchar(45) not null,
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
id_detalle serial NOT NULL,
id_producto int NOT NULL,
id_venta serial NOT NULL,
cod_cliente int,
cod_usuario int not null,
cant_disponible int,
PRIMARY KEY (id_detalle),
FOREIGN KEY (id_producto) REFERENCES producto (id_producto),
FOREIGN KEY (id_venta) REFERENCES venta (id_venta) on update cascade,
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
drop table gasto cascade;
drop table gasto_galpon cascade;
drop table detalle_venta cascade;
drop table usuario cascade;
drop table persona cascade;
drop table cliente cascade;
drop table stock_producto cascade;
drop table stock_historial cascade;
-----------------------
*/

jhonharolde

/*
-- CONSULTAS 

select * from galpon order by idgalpon;
select * from tipo_ave
select * from entrada
select * from salida
select * from producto
select * from stock_historial;
select * from venta
select * from produccion
select * from detalle_venta
select * from persona;
--select * from detalle_venta
select * from stock_producto;


select id_producto from producto where nombre_producto like '%platano%';
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
insert into "stock_producto" ("cantidad_stock") values ('0');
insert into "producto" ("nombre_producto","uni_medida_producto","descripcion_producto","precio_uni_producto","categoria_producto") values ('Huevo','unidad','Huevos de produccion','500','consumo' );
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


---------------------------------------------------------
-- Consulta avanzada
select id_producto from producto where nombre_producto='huevo';

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
select "nombre_producto","cantidad_stock" from "producto" inner join "stock_producto" on stock_producto.id_stock_producto=producto.id_stock_producto;

select * from producto;
select id_stock_producto from producto where nombre_producto='huevo';

SELECT * from stock_producto;
*/

  
