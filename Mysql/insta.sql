create database insta;
use insta;

drop table pages;
create table user(user_id varchar(20) primary key,
                  email varchar(30),
                  verified varchar(5),
                  phone_no varchar(10),
                  dateOfBirth date,
                  password varchar(20));
                  
 insert into user values("101","grace@gmail.com","yes","9876543212","2002-12-12","grace");   
 
 create table pages(page_id varchar(20) primary key,
                    user_id varchar(20),
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
                    
create table follow(following_page_id varchar(20),
					follower_page_id varchar(20),
                    foreign key(following_page_id) references pages(page_id),
                    foreign key(follower_page_id) references pages(page_id));
                    
create table content(post_id varchar(20) primary key,
                     page_id varchar(20),
					 post_media varchar(30),
                     media_type varchar(30),
                     views int,
                     primary_poster varchar(30),
                     likes int,
                     caption varchar(100),
                     date_and_time timestamp,
                     location varchar(100),
                     music_id_timestamp timestamp,
                     foreign key(page_id) references pages(page_id));
                     
alter table content add column music_id varchar(20);
alter table content add foreign key(music_id) references music(music_id);
                     
 create table music(music_id varchar(20) primary key,
					post_id varchar(20),
                    title varchar(30),
                    author varchar(30),
                    lyrics varchar(300),
                    thumbnail varchar(20),
                    foreign key(post_id) references content(post_id));
                    
create table collab_post(page_id varchar(20),
                         post_id varchar(20),
                         foreign key(page_id) references pages(page_id),
                         foreign key(post_id) references content(post_id));
                         
create table comment(comment_id varchar(20) primary key,
                     post_id varchar(20),
                     content varchar(30),
                     parent_post_id varchar(20),
                     foreign key(post_id) references content(post_id));
                     
create table likes(page_id varchar(20),
                   post_id varchar(20),
				   comment_id varchar(20),
                   foreign key(page_id) references pages(page_id),
				   foreign key(post_id) references content(post_id),
                   foreign key(comment_id) references comment(comment_id));
                   
create table collection(collection_id varchar(20) primary key,
                        collection_name varchar(30),
                        page_id varchar(20),
                        foreign key(page_id) references pages(page_id));
                        
create table collab(collab_id varchar(20) primary key,
                    page_id varchar(20),
                    isOwner varchar(20),
                    foreign key(page_id) references pages(page_id));
                    
create table saved(post_id varchar(20),
                   collab_id varchar(20),
                   foreign key(post_id) references content(post_id),
                   foreign key(collab_id) references collab(collab_id));
                   
create table post(media_id varchar(20) primary key,
				  post_id varchar(20),
				  media_link varchar(50),
				  foreign key(post_id) references content(post_id));
                  
create table tags(tag_id varchar(20) primary key,
				  co_ordinates varchar(100),
                  media_id varchar(20),
                  page_id varchar(20),
                  foreign key(page_id) references pages(page_id),
                  foreign key(media_id) references post(media_id));
                   
create table story(story_id varchar(20) primary key,
                   post_id varchar(20),
                   liked_page_id varchar(20),
                   foreign key(post_id) references content(post_id));
                   
create table ref_story(coordinates varchar(100),
                       story_id varchar(20),
                       texts text,
                       foreign key(story_id) references story(story_id));
                    
create table hashtag(post_id varchar(20),
                     hashtag text,
                     foreign key(post_id) references content(post_id));
                     
 create table device(device_id varchar(20) primary key,
                     page_id varchar(20),
                     device_location varchar(30),
                     login_time timestamp,
                     logout_time timestamp,
                     cookie text,
                     foreign key(page_id) references pages(page_id));
                     
create table chats(chat_id varchar(20) primary key,
				   page_id varchar(20),
                   chat_name varchar(30),
                   chat_type varchar(30),
                   vanish_mode text,
                   setting text,
                   foreign key(page_id) references pages(page_id));
                     
create table chat_detail(chat_id varchar(20),
						 page_id varchar(20),
                         isAdmin varchar(20),
                         last_read_message_id varchar(20),
                         foreign key(chat_id) references chats(chat_id),
                         foreign key(page_id) references pages(page_id));
                         
create table message(message_id varchar(20) primary key,
                     content text,
                     sender varchar(10),
                     time timestamp,
                     chat_id varchar(10),
                     isVanishMode text,
                     foreign key(chat_id) references chats(chat_id));
                     
show tables;                     
                     
                    