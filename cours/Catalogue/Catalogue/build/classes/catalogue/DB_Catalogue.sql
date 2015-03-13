
drop database if exists db_catalogue; 
create database db_catalogue;
drop user administrator;
create user administrator with login password 'administrator';

\c db_catalogue

drop table if exists listecode;
create table listecode(
    titre varchar(20),
    code varchar(200),
    tag1 varchar(30),
    tag2 varchar(30),
    tag3 varchar(30),
    tag4 varchar(30),

    primary key(titre)
);

grant all on database db_catalogue to administrator;
grant all on table listecode to administrator;

insert into listecode values('testcode', 'testtesttesttesttesttesttesttesttesttest', 'php', 'tag2', 'tag3', 'tag4');
insert into listecode values('Test', 'NomDuCodeNomDuCodeNomDuCodeNomDuCodeNomDuCode', 'php', 'tag2', 'tag3', 'tag4');
insert into listecode values('Code', 'testtesttesttesttesttesttesttest', 'php', 'tag2', 'tag3', 'tag4');
insert into listecode values('Code2', 'CodeCodeCodeCodeCodeCodeCodeCodeCodeCode', 'tag2', 'tag2', 'tag3', 'tag4');
insert into listecode values('NomDuCode', 'testtestCodetesttesttesttesttesttest', 'php', 'tag2', 'tag3', 'tag4');
insert into listecode values('titre', 'testcodetestcodetestcodetestcodetestcode', 'php', 'tag2', 'tag3', 'tag4');
insert into listecode values('Boucle', 'codecodecodecodecodecodecodecodecode', 'tag2', 'tag2', 'tag3', 'tag4');
