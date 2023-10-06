# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\AMD\Documents\GitHub\zavrsni_rad\printApp.sql

drop database if exists printApp;
create database printApp;
use printApp;

create table project(
    id int not null primary key auto_increment,
    project_name varchar(50) not null,
    creation_date date,
    completion_date date,
    is_completed boolean,
    total_print_time time,
    total_print_count int,
    total_cost decimal(18,2),
    project_description text,
    user int
);

create table user(
    id int not null primary key auto_increment,
    user_name varchar(50) not null,
    user_password varchar(50)
);

create table print_object(
    id int not null primary key auto_increment,
    object_name varchar(50),
    stl_file_original varchar(255),
    stl_file_supported varchar(255),
    sliced_file varchar(255),
    project int
);

create table printer(
    id int not null primary key auto_increment,
    printer_name varchar(50),
    manufacturer varchar(50),
    printer_total_print_time time,
    fep_count int
);

create table print_job(
    id int not null primary key auto_increment,
    printer int,
    print_object int,
    material int,
    cost decimal(18,2),
    result boolean
);

create table material(
    id int not null primary key auto_increment,
    material_name varchar(50),
    manufacturer varchar(50),
    cost_per_unit decimal(18,2),
    calibrated_exposure decimal(18,2),
    layer_height decimal(18,2),
    bottom_exposure decimal(18,2),
    lift_distance int,
    lift_speed decimal(18,2),
    bottom_lift_distance int,
    bottom_lift_speed decimal(18,2),
    retract_speed decimal(18,2),
    bottom_retract_speed decimal(18,2),
    light_off_delay decimal(18,2)
);

alter table project add foreign key (user) references user(id);

alter table print_object add foreign key (project) references project(id);

alter table print_job add foreign key (printer) references printer(id);

alter table print_job add foreign key (print_object) references print_object(id);

alter table print_job add foreign key (material) references material(id);
