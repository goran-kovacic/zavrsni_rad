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
    name varchar(50),
    manufacturer varchar(50),
    cost_unit decimal(18,2),
    calibrated_exposure decimal(18,2),
    ambient_temp decimal(5,2),
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


insert into material(id,name,manufacturer,cost_unit,calibrated_exposure,ambient_temp,layer_height,bottom_exposure,lift_distance,lift_speed,bottom_lift_distance,bottom_lift_speed,retract_speed,bottom_retract_speed,light_off_delay) values
(null,'Basic Grey','Anycubic',40,3.5,25,0.05,20,6,120,6,120,6,6,0.5);

insert into printer(id,printer_name,manufacturer,printer_total_print_time,fep_count) values
(null,'Mono 4K', 'Anycubic', null, null);

insert into user(id,user_name,last_name,password) values
(null,'Goran',null,null);

insert into project(id,project_name,creation_date,completion_date,project_status,total_print_time,total_print_count,user,project_description) values
(null,'Project_1','2023-05-20 12:00:00',null,'in progress',null,2,1,null);

insert into print_object(id,object_name,stl_file_original,stl_file_supported,sliced_file,project) values
(null,'object_1',null,null,null,1);

insert into print_job(id,printer,print_object,material,cost,result) values
(null,1,1,1,null,null);

