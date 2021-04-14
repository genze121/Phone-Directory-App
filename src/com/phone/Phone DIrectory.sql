create database phone_app;
use phone_app;

create table register
(id int primary key not null auto_increment,
firstname varchar(15),
lastname varchar(15),
username varchar(30),
password varchar(10));


select * from register;


create table contact
(id int primary key not null auto_increment,
firstname varchar(15),
lastname varchar(15),
email varchar(20),
mob_no varchar(10),
about varchar(50),
userid int);


select * from contact;
