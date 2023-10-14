create database insta;
use insta;
-- drop database insta;

create table user(user_id int primary key auto_increment,
                  email varchar(30),
                  verified varchar(5),
                  phone_no varchar(10),
                  dateOfBirth date,
                  password varchar(20));
                  
alter table user auto_increment=100;                  
                  
insert into user values("101","grace@gmail.com","yes","9876543212","2002-12-12","grace");   
insert into user values("102","mala@gmail.com","no","9876543215","2003-2-2","mala");   
insert into user values("103","somu@gmail.com","no","9876543292","2006-6-12","somu");   
insert into user values("104","nithi@gmail.com","yes","9876546212","2002-8-12","nithi");   
insert into user values("105","mary@gmail.com","yes","9876549212","2002-12-6","mary");   
 
 create table pages(page_id int primary key auto_increment,
                    user_id int,
                    page_name varchar(30),
                    page_handle varchar(30),
                    bio varchar(300),
                    dp varchar(100),
                    avatar varchar(100),
                    password varchar(20),
                    dateOfBirth date,
                    page_privacy varchar(20),
                    highlights varchar(100),
                    foreign key(user_id) references user(user_id));
                    
insert into pages values("201","101","grace_10","grace","hi","dp1","avatar1","grace","2002-12-12","public","highlight1");                   
insert into pages values("202","102","mala_10","mala","hello","dp2","avatar2","mala","2002-12-12","public","highlight1");   
insert into pages values("203","103","somu_10","somu","hii","dp3","avatar3","somu","2002-12-12","public","highlight1");   
insert into pages values("204","104","nithi_10","nithi","nice","dp4","avatar4","nithi","2002-12-12","public","highlight1");   
insert into pages values("205","105","mary_10","mary","good","dp5","avatar5","mary","2002-12-12","public","highlight1");   
                  
-- drop view page_content;                  
                 
create table follow(following_page_id int,
					follower_page_id int,
                    foreign key(following_page_id) references pages(page_id),
                    foreign key(follower_page_id) references pages(page_id));
                    
create table content(content_id int primary key auto_increment,
					 post_media varchar(30),
                     media_type varchar(30),
                     views int,
                     primary_poster varchar(30),
                     likes int,
                     caption varchar(100),
                     music_id int,
                     date_and_time timestamp,
                     location varchar(100),
                     music_id_timestamp timestamp,
                     foreign key(music_id) references music(music_id));
  
alter table content drop constraint content_ibfk_1;   
alter table content drop column page_id; 
alter table content modify column primary_poster int;
alter table content add foreign key(primary_poster) references pages(page_id);                    
                     
insert into content values(301,"post","video",100,201,20050,"nature",801,sysdate(),"kovai",sysdate()); 
insert into content values(302,"story","video",200,202,200677,"sun",803,sysdate(),"us",sysdate());                    
insert into content values(303,"reels","video",1000,203,200978,"moon",802,sysdate(),"paris",sysdate());                    
insert into content values(304,"post","video",10000,204,206044445,"good",809,sysdate(),"namakkal",sysdate());                    
insert into content values(305,"post","video",4000,205,203055435,"baby",804,sysdate(),"chennai",sysdate());     

select * from content;                                 
                     
 create table music(music_id int primary key auto_increment,
                    title varchar(30),
                    author varchar(30),
                    lyrics varchar(300),
                    thumbnail varchar(20));
                    
insert into music values(801,"microcosmos","bts",null,"#thumbnail1");
insert into music values(802,"good","levis","it's a good day","#thumbnail2");  
insert into music values(803,"sunday","rowling",null,"#thumbnail3");  
insert into music values(804,"nature","somu","nature is everything","#thumbnail4");  
insert into music values(809,"sad","kavi",null,"#thumbnail5");  
                    
select * from music;
                    
create table collab_post(page_id int,
                         content_id int,
                         foreign key(page_id) references pages(page_id),
                         foreign key(content_id) references content(content_id));
                         
insert into collab_post values(201,301);     
insert into collab_post values(202,301);
insert into collab_post values(203,301);
insert into collab_post values(205,304);
insert into collab_post values(204,304);                    
                         
create table comment(comment_id int primary key auto_increment,
                     content_id int,
                     content varchar(30),
                     parent_post_id varchar(20),
                     foreign key(content_id) references content(content_id));
                     
insert into comment values(901,301,"wonderfull",201);
insert into comment values(902,302,"nice",202);
insert into comment values(903,301,"good",201);
insert into comment values(904,303,"good work",203);
insert into comment values(905,301,"smart",201);                     
                     
create table likes(page_id int,
                   content_id int,
				   comment_id int,
                   foreign key(page_id) references pages(page_id),
				   foreign key(content_id) references content(content_id),
                   foreign key(comment_id) references comment(comment_id));
                   
insert into likes values(201,301,905);
insert into likes values(202,302,902);
insert into likes values(203,303,904);
insert into likes values(204,304,null);
insert into likes values(205,305,null);                      
                   
create table collection(collection_id int primary key auto_increment,
                        collection_name varchar(30),
                        page_id int,
                        foreign key(page_id) references pages(page_id));
                        
insert into collection values(1001,"fav",201);  
insert into collection values(1002,"songs",202); 
insert into collection values(1003,"movies",201); 
insert into collection values(1004,"food",203); 
insert into collection values(1005,"songs",204);                       

drop table collab;
-- drop table saved; 
select * from collab;                       
create table collab(collab_id int auto_increment,
                    content_id int,
                    page_id int,
                    isOwner varchar(20),
                    primary key(collab_id,page_id),
                    foreign key(content_id) references content(content_id),
                    foreign key(page_id) references pages(page_id));
                    
insert into collab values(2001,305,201,"yes");  
insert into collab values(2001,305,202,"no"); 
insert into collab values(2002,301,203,"yes"); 
insert into collab values(2002,301,204,"no");
insert into collab values(2002,301,201,"no");
insert into collab values(2003,304,205,"no"); 
insert into collab values(2003,304,204,"yes");
insert into collab values(2004,301,203,"no");   
insert into collab values(2004,301,204,"yes");                    
                    
create table saved(content_id int,
                   page_id int,
                   foreign key(content_id) references content(content_id),
				   foreign key(page_id) references pages(page_id));
                   
insert into saved values(305,201);
insert into saved values(302,201);
insert into saved values(301,201);
insert into saved values(304,202);                   
                   
create table post(media_id int primary key auto_increment,
				  content_id int,
				  media_link varchar(50),
				  foreign key(content_id) references content(content_id));
                  
insert into post values(3001,301,"#link1");  
insert into post values(3002,303,"#link2"); 
insert into post values(3003,304,"#link3"); 
insert into post values(3004,305,"#link4");                 
                  
create table tags(tag_id int primary key auto_increment,
				  co_ordinates varchar(100),
                  media_id int,
                  page_id int,
                  foreign key(page_id) references pages(page_id),
                  foreign key(media_id) references post(media_id));
                  
insert into tags();                  
                   
create table story(story_id int primary key auto_increment,
                   content_id int,
                   liked_page_id varchar(20),
                   foreign key(content_id) references content(content_id));
                   
create table ref_story(coordinates varchar(100),
                       story_id int,
                       texts text,
                       foreign key(story_id) references story(story_id));
                    
create table hashtag(content_id int,
                     hashtag varchar(100),
                     foreign key(content_id) references content(content_id));
                     
                     -- drop table hashtag;
                     
 create table device(device_id int primary key auto_increment,
                     page_id int,
                     device_location varchar(30),
                     login_time timestamp,
                     logout_time timestamp,
                     cookie text,
                     foreign key(page_id) references pages(page_id));
                     
create table chats(chat_id int primary key auto_increment,
				   page_id int,
                   chat_name varchar(30),
                   chat_type varchar(30),
                   vanish_mode text,
                   setting text,
                   foreign key(page_id) references pages(page_id));
                     
create table chat_detail(chat_id int,
						 page_id int,
                         isAdmin varchar(20),
                         last_read_message_id varchar(20),
                         foreign key(chat_id) references chats(chat_id),
                         foreign key(page_id) references pages(page_id));
                         
create table message(message_id int primary key auto_increment,
                     content text,
                     sender varchar(10),
                     time timestamp,
                     chat_id int,
                     isVanishMode text,
                     foreign key(chat_id) references chats(chat_id));
                     
create table report(report_id int primary key auto_increment,
                    page_id int,
                    reporting_page_id int,
                    reason text,
                    foreign key(page_id) references pages(page_id));
                    
create table blocked(block_id int primary key auto_increment,
                     page_id int,
                     blocked_page_id int,
                     foreign key(page_id) references pages(page_id));
                     
show full tables;   

create index p_name on pages(page_name);
create index p_handle on pages(page_handle);
create index p_privacy on pages(page_privacy);
create index user_email on user(email);
create index user_verified on user(verified);
create index content_datetime on content(date_and_time);
create index content_location on content(location);
create index hashtags on hashtag(hashtag);
                  
create view pages_view as (select u.verified,u.email,p.page_name,p.bio,p.avatar,p.page_privacy,p.highlights from  user u inner join pages p on u.user_id = p.user_id);               
select * from pages_view;	

create view page_content as(select p.page_name,p.page_handle,p.dp,c.post_media,c.media_type,c.views,c.primary_poster,c.likes,c.caption,c.music_id,c.date_and_time,c.location from pages p inner join content c on p.page_id=c.page_id);
select * from page_content;		

create view content_view as (select post_media,media_type, views,primary_poster,likes,caption,music_id,date_and_time,location from content);

	