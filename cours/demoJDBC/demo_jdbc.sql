drop database if exists demo_jdbc;
create database demo_jdbc;

\c demo_jdbc

drop user if exists uti_demo;
create user uti_demo login password 'uti_demo';




/************************/
drop table if exists personne;
create table personne (
	id int,
	nom varchar(30) not null,
	prenom varchar(30) not null,
	dateNaissance date,
	
	primary key(id)
);


grant select, insert, update, delete on table personne to uti_demo;
