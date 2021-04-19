/*
Proyecto Aviones - Diseño y Programacion de Plataformas Moviles
Alumnos: 
	Natalia Solano Azofeifa
	Joy Bonilla Fley
Grupo:
	10am
	
	-----  Script de datos de prueba -----
*/

conn system/root

insert into usuario values ('Loria666', 'Carlos', 'Loria', '123', 'CarlosLoria666@gmail.com', to_date('03-02-1970', 'dd-mm-yyyy'), 0, 22686666, 88888666, '100m norte de mas x menos Heredia', 0);
insert into usuario values ('NicoNicoNii', 'Nicolas', 'Maduro', '123', 'NicoNicoNii@gmail.com', to_date('24-09-1986', 'dd-mm-yyyy'), 0, 22680876, 88667733, 'Venezuela', 1);

insert into ruta values (ruta_seq.nextval, 'Costa Rica', 'Japon', 20);
insert into ruta values (ruta_seq.nextval, 'Costa Rica', 'Estados Unidos', 5);
insert into ruta values (ruta_seq.nextval, 'Costa Rica', 'España', 12);
insert into ruta values (ruta_seq.nextval, 'Costa Rica', 'Inglaterra', 13);

insert into tipo_avion values (tipo_avion_seq.nextval, 6, 11);
insert into tipo_avion values (tipo_avion_seq.nextval, 9, 11);


insert into avion values (avion_seq.nextval, 1960, '747-400','Boeing',1);
insert into avion values (avion_seq.nextval, 1995, '777-200','Boeing',1);
insert into avion values (avion_seq.nextval, 1993, 'A340-300','Airbus Industrie',2);
insert into avion values (avion_seq.nextval, 2000, '767-300ER','Boeing',2);
insert into avion values (avion_seq.nextval, 1992, 'A330-300','Airbus Industrie',2);
insert into avion values (avion_seq.nextval, 1983, '757-200 ','Boeing',1);


insert into horario values (horario_seq.nextval, 'Lunes', to_date('17:00', 'HH24:MI'), 650000, 5, 1, 1);
insert into horario values (horario_seq.nextval, 'Martes', to_date('14:30', 'HH24:MI'), 200000, 0, 2, 2);
insert into horario values (horario_seq.nextval, 'Miercoles', to_date('10:00', 'HH24:MI'), 500000, 3, 1, 3);
insert into horario values (horario_seq.nextval, 'Jueves', to_date('6:00', 'HH24:MI'), 600000, 0, 4, 3);
insert into horario values (horario_seq.nextval, 'Viernes', to_date('9:00', 'HH24:MI'), 685000, 0, 5, 4);


insert into vuelo values (vuelo_seq.nextval, to_date('25-06-2021', 'dd-mm-yyyy'), null, 1);
insert into vuelo values (vuelo_seq.nextval, to_date('02-06-2021','dd-mm-yyyy'), to_date('07-06-2021','dd-mm-yyyy'), 2);
insert into vuelo values (vuelo_seq.nextval, to_date('13-06-2021','dd-mm-yyyy'), to_date('03-07-2021','dd-mm-yyyy'), 3);
insert into vuelo values (vuelo_seq.nextval, to_date('28-05-2021','dd-mm-yyyy'), to_date('10-06-2021','dd-mm-yyyy'), 5);
insert into vuelo values (vuelo_seq.nextval, to_date('22-07-2021','dd-mm-yyyy'), to_date('29-07-2021','dd-mm-yyyy'), 4);
insert into vuelo values (vuelo_seq.nextval, to_date('25-06-2021','dd-mm-yyyy'), null, 4);
commit;