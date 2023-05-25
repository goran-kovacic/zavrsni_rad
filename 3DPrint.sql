# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\AMD\Documents\GitHub\zavrsni_rad\3DPrint.sql

drop database if exists 3DPrint;
create database 3DPrint;
use 3DPrint;

create table project(
    id int not null primary key auto_increment,
    project_name varchar(50) not null,
    creation_date date,
    completion_date date,
    project_status varchar(50),
    total_print_time time,
    total_print_count int,
    project_description text,
    user int
);

create table user(
    id int not null primary key auto_increment,
    user_name varchar(50) not null,
    last_name varchar(50),
    password varchar(50)
);

