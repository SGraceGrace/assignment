create database Book_music_store;
use Book_music_store;
show tables;
create table artist (artist_id varchar(10) primary key,
					 artist_name varchar(20), 
                     Address varchar(20), 
                     url varchar(30));
                     
create table producer (producer_id varchar(10) primary key,
					producer_name varchar(20),
                    Address varchar(20),
                    Phone int,
                    url varchar(30));
                    
create table product(product_id varchar(10) primary key,
                     product_name varchar(10),
                     product_type varchar(10),
                     artist_id varchar(20),
                     producer_id varchar(20),
                     Year int,
                     Price int,
                     foreign key (artist_id) references artist(artist_id),
                     foreign key (producer_id) references producer(producer_id));
 
 create table warhouse(code varchar(20) primary key,
                      warhouse_name varchar(20),
                      address varchar(20),
                      phone int);
                      
create table stocks(stock_id varchar(10) primary key,
                    product_id varchar(10),
                    code varchar(20),
                    product_count int ,
                    price int ,
                    foreign key (product_id) references product(product_id),
                    foreign key (code) references warhouse(code));
                      
create table customer ( Name varchar(20),
                        Address varchar(20),
                        Email varchar(20) primary key,
                        Phone int);
                        
create table shopping_basket(basketID varchar(10) primary key,
                             stock_id varchar(10),
                             email varchar(20),
                             product_count int,
                             price int,
                             foreign key(stock_id) references stocks(stock_id),
                             foreign key(email) references customer(email));
                             
 create table customer_order(order_id varchar(10) primary key,
                    basketID varchar(10),
                    email varchar(20),
                    stock_id varchar(10),
                    product_count int,
                    total_price int,
                    order_data date,
                    foreign key(basketID) references shopping_basket(basketID));
                    
create table tracking(tracking_id varchar(10) primary key,
                      order_id varchar(10),
                      modeOfPayment varchar(50),
                      payment_status varchar(10),
                      deliver_status varchar(30),
                      delivered_date date,
                      foreign key(order_id) references customer_order(order_id));
 
drop table tracking;
drop table customer_order;
drop table shopping_basket;

                      