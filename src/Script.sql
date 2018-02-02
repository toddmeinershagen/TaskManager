create table department (dept_id int primary key, deptName VARCHAR(120));

alter table department drop column id;

show databases;
use taskmanager;
show tables;
use test;
describe task_list;
select * from task_list;

select * from department;

create table task_list(task_name VARCHAR(100) not null, task_class VARCHAR(100) not null, status VARCHAR(100) not null);
insert into task_list values("Shower curtain", "Gov", "ACTIVE");
insert into task_list values("Webassign", "Physics", "ACTIVE");
insert into task_list values("Study", "Microecon", "ACTIVE");


create table task_list(task_id int not null auto_increment primary key, task_name VARCHAR(100) not null, task_details VARCHAR (200) not null, class VARCHAR(100) not null, task_status VARCHAR(100) not null, task_archived bool default false);
drop table task_list;
insert into task_list values(1, "Physics Lab", "Write into Notebook", "AP Physics C", "ACTIVE", false);
insert into task_list values(2, "Shower Curtain", "Units 3 and 4", "AP Government", "ACTIVE", false);

create database taskManager;