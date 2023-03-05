CREATE DATABASE resproject;
USE resproject;
SELECT * FROM dish_details;
CREATE TABLE dish_details(
dish_id int primary key auto_increment,
dish_name varchar(50) ,
dish_price varchar(20),
dish_quantity varchar(20)
);
SELECT * FROM dish_details;
DESC dish_details;
DROP TABLE dish_details;
UPDATE  dish_details SET dish_quantity=4 WHERE dish_id=8;
CREATE TABLE menu(
dish_id int ,
dish_name varchar(50) ,
dish_price varchar(20),
dish_quantity varchar(20)
);
TRUNCATE TABLE menu;
TRUNCATE TABLE dish_details;
INSERT INTO menu SELECT * FROM dish_details WHERE dish_id=1;
SELECT * FROM menu;
SELECT * FROM customer;
CREATE TABLE customer(
dish_id int ,
dish_name varchar(50) ,
dish_price varchar(20),
dish_quantity varchar(20)
);
ALTER TABLE customer ADD amount varchar(20);
ALTER TABLE customer DROP COLUMN dish_price;
ALTER TABLE customer ADD rate varchar(20) AFTER dish_name;
TRUNCATE TABLE customer;
INSERT INTO customer SELECT * FROM menu WHERE dish_id=1;
DROP TABLE customer;
INSERT INTO customer SELECT * FROM menu WHERE dish_id=1;
UPDATE customer SET dish_quantity= 4 WHERE dish_id=1;
INSERT INTO customer(dish_id,dish_name,rate,dish_quantity) SELECT dish_id,dish_name,dish_price,dish_quantity FROM menu WHERE dish_id=4;
-- select * from customer where dish_id=(select dish_id from customer);
CREATE TABLE cus_menu_to_Admin(
dish_id int ,
dish_name varchar(50) ,
rate varchar(20),
dish_quantity varchar(20),
amount varchar(20)
);