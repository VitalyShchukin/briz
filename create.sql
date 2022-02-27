create table grade (id int8 generated by default as identity, academic_year int8, mnemocode varchar(255), teacher_id int8, primary key (id));
create table student (id int8 generated by default as identity, born_year int8, first_name varchar(255), gender varchar(255), last_name varchar(255), middle_name varchar(255), primary key (id));
create table teacher (id int8 generated by default as identity, born_year int8, first_name varchar(255), gender varchar(255), last_name varchar(255), main_subject varchar(255), middle_name varchar(255), primary key (id));
alter table if exists grade add constraint FKqb6g3kbua30kxih2f8kfx2giu foreign key (teacher_id) references teacher;


--CREATE DATABASE briz;

--CREATE TABLE public.student (
--id SERIAL NOT NULL,
--first_name VARCHAR(50) NOT NULL,
--middle_name VARCHAR(50) NOT NULL,
--last_name VARCHAR(50) NOT NULL,
--born_year INTEGER NOT NULL,
--gender VARCHAR(1) NOT NULL,
--CHECK (born_year>1900),
--PRIMARY KEY (id)
--);
--
--CREATE TABLE public.teacher (
--id SERIAL NOT NULL,
--first_name VARCHAR(50) NOT NULL,
--middle_name VARCHAR(50) NOT NULL,
--last_name VARCHAR(50) NOT NULL,
--born_year INTEGER NOT NULL,
--gender VARCHAR(1) NOT NULL,
--main_subject VARCHAR(50) NOT NULL,
--CHECK (born_year>1900),
--PRIMARY KEY (id)
--);
--
--CREATE TABLE public.grade (
--id SERIAL NOT NULL,
--mnemocode VARCHAR(10) NOT NULL,
--academic_year INTEGER NOT NULL,
--student_id INTEGER,
--teacher_id INTEGER,
--CHECK (academic_year>1900),
--PRIMARY KEY (id),
--FOREIGN KEY (student_id) REFERENCES public.student (id),
--FOREIGN KEY (teacher_id) REFERENCES public.teacher (id)
--);

