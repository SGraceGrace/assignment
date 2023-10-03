create database final_exam;
use final_exam;

create table course(course_id varchar(10) primary key,
                    course_name varchar(20),
                    department varchar(20));
                    
describe course;
                    
create table room(room_id varchar(10) primary key,
                    capacity int,
                    building varchar(10));
                    
create table section(section_no varchar(10),
                    course_id varchar(10),
                    enrollment int,
                    foreign key (course_id) references course(course_id));
                    
create table exam(exam_id varchar(10) primary key,
                  exam_name varchar(20),
                  course_id varchar(10),
                  room_id varchar(10),
                  section_no varchar(10),
                  foreign key (course_id) references course(course_id),
                  foreign key (room_id) references room(room_id));