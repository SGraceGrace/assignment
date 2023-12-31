create database sports;
use sports;
drop table matches;
create table matches(Match_id varchar(10) primary key,
                     Match_name varchar(10),
                     Dates date,
                     Start_time time,
                     End_time time,
                     Winner_team varchar(20));
create table players(player_id varchar(10) primary key,
                     First_name varchar(10),
                     Last_name varchar(10),
                     Team_id varchar(10),
                     FOREIGN KEY (Team_id) references teams(Team_id));
drop table players; 
create table teams(Team_id varchar(10) primary key,
                   Team_name varchar(20),
                   Total_members int);
drop table teams; 
alter table teams modify Team_id varchar(10) primary key;
create table players_score(player_id varchar(10),
                           Team_id varchar(10),
                           Match_id varchar(10),
                           Score int, 
                           FOREIGN KEY (Team_id) references teams(Team_id),
                           FOREIGN KEY (player_id) references players(player_id));
SHOW TABLES;
describe teams;
drop table team_score;
create table team_score(Team_id varchar(10),
						Match_id varchar(10),
                        Score int,
                        FOREIGN KEY (Team_id) references teams(Team_id),
                        FOREIGN KEY (Match_id) references matches(Match_id));
                        
create table match_payed(Match_id varchar(10),
                         Match_name varchar(20),
                         Team_id varchar(10),
                         Team_name varchar(20),
                         FOREIGN KEY (Team_id) references teams(Team_id),
                         FOREIGN KEY (Match_id) references matches(Match_id));
drop database sports;