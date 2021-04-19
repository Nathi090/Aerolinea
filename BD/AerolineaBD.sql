/*
Proyecto Aviones - Diseño y Programacion de Plataformas Moviles
Alumnos: 
	Natalia Solano Azofeifa
	Joy Bonilla Fley
Grupo:
	10am
	
	-----  Script de estructura de la base de datos -----
*/

host cls;
conn system/root;


------------------------------ Drop de tablas ----------------------------------------

drop table tiquete;
drop table reserva;
drop table vuelo;
drop table horario;
drop table avion;
drop table tipo_avion;
drop table usuario;
drop table ruta;


------------------------------ Drop de secuencias -------------------------------------

drop sequence tiquete_seq;
drop sequence ruta_seq;
drop sequence tipo_avion_seq;
drop sequence avion_seq;
drop sequence horario_seq;
drop sequence reserva_seq;
drop sequence vuelo_seq;

------------------------------ Creacion de tablas -------------------------------------

create table usuario (username varchar(20) primary key, nombre varchar(50), apellidos varchar (50), clave varchar(20), correo varchar(30),
	fec_nacimiento date, sexo number(1), tel_trabajo number, tel_movil number, direccion varchar(100), tipo number(1) not null);
	
create table tiquete (id number primary key, fila number, columna number, reserva_id number);

create table ruta (id number primary key, origen varchar(30), destino varchar(30), duracion number);

create table tipo_avion (id number primary key, filas number not null, columnas number not null);

create table avion (id number primary key, anno number, modelo varchar(20), marca varchar(20), tipo_avion_id number not null);

create table horario (id number primary key, dia varchar(10), hora date, precio number, descuento number, avion_id number, ruta_id number not null);

create table reserva (id number primary key, precio number, cliente_id varchar(20), vuelo_id number);

create table vuelo (id number primary key, ida date not null, regreso date, horario_id number);

------------------------------ Creacion de sequences ------------------------------------

create sequence tiquete_seq start with 10 increment by 1 cache 2;
create sequence ruta_seq start with 1 increment by 1 cache 2;
create sequence tipo_avion_seq start with 1 increment by 1 cache 2;
create sequence avion_seq start with 1 increment by 1 cache 2;
create sequence horario_seq start with 1 increment by 1 cache 2;
create sequence reserva_seq start with 1 increment by 1 cache 2;
create sequence vuelo_seq start with 1 increment by 1 cache 2;

----------------------------- Creacion de foreign keys ----------------------------------

alter table tiquete add constraint tiquete_reserva_fk foreign key (reserva_id) references reserva;
alter table avion add constraint avion_tipo_fk foreign key (tipo_avion_id) references tipo_avion;
alter table horario add constraint avion_horario_fk foreign key (avion_id) references avion;
alter table horario add constraint ruta_horario_fk foreign key (ruta_id) references ruta;
alter table reserva add constraint cliente_reserva_fk foreign key (cliente_id) references usuario;
alter table reserva add constraint vuelo_reserva_fk foreign key (vuelo_id) references vuelo;
alter table vuelo add constraint horario_vuelo_fk foreign key (horario_id) references horario;

----------------------------- Creacion de Procedures ------------------------------------

---------------Usuario------------------
create or replace procedure prc_ins_usuario(Pusrname in varchar, Pname in varchar, Plname in varchar, Ppass in varchar, Pmail in varchar, Pbirth in date, Psex in number, Pwphone in number, Pphone in number, Paddress in varchar, Ptype in number) is
begin
    insert into usuario values (Pusrname, Pname, Plname, Ppass, Pmail, Pbirth, Psex, Pwphone, Pphone, Paddress, Ptype);
    commit;
end prc_ins_usuario;
/
show error

create or replace procedure prc_upd_usuario(Polduser in varchar, Pusrname in varchar, Pname in varchar, Plname in varchar, Ppass in varchar, Pmail in varchar, Pbirth in date, Psex in number, Pwphone in number, Pphone in number, Paddress in varchar, Ptype in number) is
begin
	update usuario set username = Pusrname, nombre = Pname, apellidos = Plname, clave = Ppass, correo = Pmail,
		fec_nacimiento = Pbirth, sexo = Psex, tel_trabajo = Pwphone, tel_movil = Pphone, direccion = Paddress, tipo = Ptype
		where username = Polduser;
	commit;
end prc_upd_usuario;
/
show error

--------------- Ruta ------------------
create or replace procedure prc_ins_ruta(Porigen in varchar, Pdestino in varchar, Pduracion in number) is
begin
	insert into ruta values (ruta_seq.nextval, Porigen, Pdestino, Pduracion);
	commit;
end prc_ins_ruta;
/
show error

create or replace procedure prc_upd_ruta(Poldruta in number, Porigen in varchar, Pdestino in varchar, Pduracion in number) is
begin
	update ruta set id = Poldruta, origen = Porigen, destino = Pdestino, duracion = Pduracion
		where id = Poldruta;
	commit;
end prc_upd_ruta;
/
show error

--------------- Tipo avion ------------------
create or replace procedure prc_ins_tipoavion(Prows in number, Pcolumns in number) is
begin
	insert into tipo_avion values (tipo_avion_seq.nextval, Prows, Pcolumns);
	commit;
end prc_ins_tipoavion;
/
show error

create or replace procedure prc_upd_tipoavion(Poldtipo in number, Prows in number, Pcolumns in number) is
begin
	update tipo_avion set filas = Prows, columnas = Pcolumns
		where id = Poldtipo;
	commit;
end prc_upd_tipoavion;
/
show error

--------------- Avion ------------------
create or replace procedure prc_ins_avion(Pyear in number, Pmodel in varchar, Pbrand in varchar, Ptplane in number) is
begin
	insert into avion values (avion_seq.nextval, Pyear, Pmodel, Pbrand, Ptplane);
	commit;
end prc_ins_avion;
/
show error

create or replace procedure prc_upd_avion(Poldplane in number, Pyear in number, Pmodel in varchar, Pbrand in varchar, Ptplane in number) is
begin
	update avion set anno = Pyear, modelo = Pmodel, marca = Pbrand, tipo_avion_id = Ptplane
		where id = Poldplane;
	commit;
end prc_upd_avion;
/
show error

--------------- Horario ------------------
create or replace procedure prc_ins_horario(Pday in varchar, Ptime in varchar, Pprice in number, Pdiscount in number,  Proute in number) is
begin
	insert into horario values (horario_seq.nextval, Pday, to_date(Ptime, 'HH24:MI'), Pprice, Pdiscount, null, Proute);
	commit;
end prc_ins_horario;
/
show error

create or replace procedure prc_upd_horario(Poldschedule in number, Pday in varchar, Ptime in date, Pprice in number, Pdiscount in number, Pplane in number, Proute in number) is
begin
	update horario set dia = Pday, hora = Ptime, precio = Pprice, descuento = Pdiscount, avion_id = Pplane, ruta_id = Proute
		where id = Poldschedule;
	commit;
end prc_upd_horario;
/
show error

--------------- Vuelo ------------------
create or replace procedure prc_ins_vuelo(Pdeparture in date, Preturn in date, Pschedule in number) is
begin
	insert into vuelo values (vuelo_seq.nextval, Pdeparture, Preturn, Pschedule);
	commit;
end prc_ins_vuelo;
/
show error

create or replace procedure prc_upd_vuelo(Poldflight in number, Pdeparture in date, Preturn in date, Pschedule in number) is
begin
	update vuelo set ida = Pdeparture, regreso = Preturn, horario_id = Pschedule
		where id = Poldflight;
	commit;
end prc_upd_vuelo;
/
show error

--------------- Reserva ------------------
create or replace procedure prc_ins_reserva(Pprice in number, Pcliente in varchar, Pvuelo in number) is
begin
	insert into reserva values (reserva_seq.nextval, Pprice, Pcliente, Pvuelo);
	commit;
end prc_ins_reserva;
/
show error

--------------- Tiquete ------------------
create or replace procedure prc_ins_tiquete(Prow in number, Pcolumn in number, Preservation in number) is
begin
	insert into tiquete values (tiquete_seq.nextval, Prow, Pcolumn, Preservation);
	commit;
end prc_ins_tiquete;
/
show error
