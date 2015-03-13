
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

insert into listecode values('testcode', 'testtesttesttesttesttesttesttest', 'php', 'tag2', 'tag3', 'tag4');
