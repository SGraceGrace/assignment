create database register_office;
use register_office;
create table course (Course_no varchar(10) primary key,
                     Title varchar(30),
                     Credits int,
                     Syllabus text,
                     Prerequisite text);
select * from course;
describe course;
create table course_offerings (Course_no varchar(10) ,
							   Instructor_id varchar(20),
                               Semester int,
                               Year int,
                               Section_no varchar(10) not null,
                               Classroom varchar(5),
                               Timing time,
                               FOREIGN KEY (Course_no) references course(Course_no),
                               FOREIGN KEY (Instructor_id) references instructor(Instructor_id));
describe course_offerings;
drop table course_offerings;
create table student (Stud_id varchar(10) primary key,
					  First_name varchar(10),
                      Last_name varchar(10),
                      Program varchar(10),
                      Department varchar(10),
                      Email varchar(20),
                      Year int);
create table instructor (Instructor_id varchar(10) primary key,
                         First_name varchar(10),
                         Last_name varchar(10),
                         Title varchar(10),
                         Course_no varchar(10) ,
                         Email varchar(20),
                         Department varchar(10),
                         FOREIGN KEY (Course_no) references course(Course_no));
describe student;
create table course_enrollment (Enrollment_id int primary key auto_increment,
							    Course_no varchar(10),
                                Stud_id varchar(10),
                                FOREIGN KEY (Course_no) references course(Course_no),
                                FOREIGN KEY (Stud_id) references student(Stud_id));
describe course_enrollment;
alter table course_enrollment auto_increment=100;
show tables;
drop table student_result;
create table student_result(Enrollment_id int ,
                            Stud_id varchar(10),
                            First_name varchar(10),
                            Last_name varchar(10),
                            Course_no varchar(10),
                            Title varchar(20),
                            Grade int,
                            FOREIGN KEY (Enrollment_id) references course_enrollment(Enrollment_id));
drop database register_office;