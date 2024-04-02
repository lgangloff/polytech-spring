insert into address (id, city) values (1, 'Nancy');
insert into address (id, city) values (2, 'Dijon');
insert into address (id, city) values (3, 'Paris');
insert into address (id, city) values (4, 'Lyon');
insert into address (id, city) values (5, 'Rouen');

insert into doctor (id_doctor, id_address, name) values (1,4, 'Dr Lebrun');
insert into doctor (id_doctor, id_address, name) values (2,5, 'Dr Darum');

insert into patient (id_patient, id_address, first_name, last_name, birth_date, mail, removed) values (1,1, 'Bob', 'Dupont', '08-04-1985', 'bob@free.fr', 'N');
insert into patient (id_patient, id_address, first_name, last_name, birth_date, mail, removed) values (2,2, 'Jacques', 'Martin', '08-12-1995', 'jmartin@yahoo.fr', 'N');
insert into patient (id_patient, id_address, first_name, last_name, birth_date, mail, removed) values (3,3, 'Julie', 'Rose', '12-02-1975', 'jr@gmail.fr', 'N');


insert into doctor_patients(archived, id_doctor, id_patient) values (0, 1, 1);
insert into doctor_patients(archived, id_doctor, id_patient) values (0, 1, 2);
insert into doctor_patients(archived, id_doctor, id_patient) values (0, 2, 3);