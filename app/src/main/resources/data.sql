insert into address (id, city) values (1, 'Nancy');
insert into address (id, city) values (2, 'Dijon');
insert into address (id, city) values (3, 'Paris');
insert into address (id, city) values (4, 'Lyon');
insert into address (id, city) values (5, 'Rouen');

insert into person (id_person, id_address, first_name, last_name, removed) values (1,1, 'Bob', 'Dupont', 'N');
insert into person (id_person, id_address, first_name, last_name, removed) values (2,2, 'Jacques', 'Martin', 'N');
insert into person (id_person, id_address, first_name, last_name, removed) values (3,3, 'Julie', 'Rose', 'N');
insert into person (id_person, id_address, first_name, last_name, removed) values (4,4, 'Dr Hugues', 'Lebrun', 'N');
insert into person (id_person, id_address, first_name, last_name, removed) values (5,5, 'Dr Paul', 'Darum', 'N');

insert into doctor (id_person) values (4);
insert into doctor (id_person) values (5);

insert into patient (id_person, birth_date, mail) values (1, '08-04-1985', 'bob@free.fr');
insert into patient (id_person, birth_date, mail) values (2, '08-12-1995', 'jmartin@yahoo.fr');
insert into patient (id_person, birth_date, mail) values (3, '12-02-1975', 'jr@gmail.fr');


insert into doctor_patients(archived, id_person_doctor, id_person_patient) values (0, 4, 1);
insert into doctor_patients(archived, id_person_doctor, id_person_patient) values (0, 4, 2);
insert into doctor_patients(archived, id_person_doctor, id_person_patient) values (0, 5, 3);