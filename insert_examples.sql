insert into material(id,name,manufacturer,cost_unit,calibrated_exposure,ambient_temp,layer_height,bottom_exposure,lift_distance,lift_speed,bottom_lift_distance,bottom_lift_speed,retract_speed,bottom_retract_speed,light_off_delay) values
(null,'Basic Grey','Anycubic',44,3.5,25,0.05,20,6,120,6,120,6,6,0.5),
(null,'Water Washable','Anycubic',33,2.5,25,0.05,20,6,120,6,120,6,6,0.5),
(null,'Water Washable','Sunlu',33,3,25,0.05,20,6,120,6,120,6,6,0.5),
(null,'ABS Like','Anycubic',44,3.5,25,0.05,20,6,120,6,120,6,6,0.5);

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