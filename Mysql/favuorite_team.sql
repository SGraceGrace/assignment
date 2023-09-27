create database one_team;
use one_team;
show tables;
create table matches(Match_id varchar(10),Match_name varchar(10),Dates date,Start_time time,End_time time,Status varchar(20),Score int);
create table players(player_id varchar(10) primary key,First_name varchar(10),Last_name varchar(10));
drop table players; 
create table teams(Team_id varchar(10) primary key,Team_name varchar(20),Total_members int);
create table player_score(player_id varchar(10),Match_id varchar(10),Score int,FOREIGN KEY (player_id) references players(player_id));