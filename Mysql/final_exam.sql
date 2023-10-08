create database final_exam;
use final_exam;
drop database final_exam;

create table course(course_id varchar(10) primary key,
                    course_name varchar(20),
                    department varchar(20));
                    
describe course;
                    
create table room(room_id varchar(10) primary key,
                    capacity int,
                    building varchar(10));
           
drop table course;		
drop table section;
				
create table section(section_no varchar(10),
                    course_id varchar(5),          -- using int instead of varchar error , changing size no error ,
                    enrollment int,
                    foreign key (course_id) references course(course_id));
drop table exam;               
create table exam(exam_id varchar(10) primary key,
                  exam_name varchar(20),
                  course_id varchar(10),
                  room_id varchar(10),
                  section_no varchar(10),
                  foreign key (course_id) references course(course_id),
                  foreign key (room_id) references room(room_id));