INSERT INTO customer (passport, last_name, first_name, middle_name, date_of_birth, phone_number) 
VALUES ('3198564123', 'Petrov', 'Vasya', 'Petrovich', '11-11-1975', '89276543761');
INSERT INTO customer (passport, last_name, first_name, middle_name, date_of_birth, phone_number)
VALUES ('9867560965', 'Sabirov', 'Anton', 'Andreyevich', '10-1-1990', '89459854238');
INSERT INTO customer (passport, last_name, first_name, middle_name, date_of_birth, phone_number)
VALUES ('1367999165', 'Haritonov', 'Vitaliy', 'Igorevich', '2-2-1995', '89439876238');
INSERT INTO customer (passport, last_name, first_name, middle_name, date_of_birth, phone_number)
VALUES ('1784659554', 'Medvedeva', 'Marina', 'Viktorovna', '12-10-1996', '89760965782');
INSERT INTO customer (passport, last_name, first_name, middle_name, date_of_birth, phone_number)
VALUES ('5690247645', 'Gorbunov', 'Anton', 'Andreyevich', '10-1-1990', '89459854338');
INSERT INTO customer (passport, last_name, first_name, middle_name, date_of_birth, phone_number)
VALUES ('7609564501', 'Baranov', 'Alexey', 'Romanovich', '9-1-1980', '89768945107');
INSERT INTO customer (passport, last_name, first_name, middle_name, date_of_birth, phone_number)
VALUES ('8297036491', 'Kulikova', 'Anna', 'Eremeeva', '5-6-1975', '89720154262');

INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('Phone', 'NOKIA', 2000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('Car', 'BMW', 300000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('THE PROPERTY', '2 rooms', 2000000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('Saber', 'Decorative saber', 10000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('Phone', 'Samsung S7', 20000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('THE PROPERTY', '3 rooms', 3000000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('THE PROPERTY', '2 rooms', 2500000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('TV', 'Panasonic', 5000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('Jewel', 'Gold necklace', 1000);
INSERT INTO goods (goods_type, description, pawnshop_price)
VALUES ('Jewel', 'Gold ring', 500);

INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (1, 1, '12-12-2016', 10, 2200);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (2, 1, '10-12-2016', 20, 330000);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (3, 2, '15-12-2016', 40, 2200000);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (4, 2, '16-12-2016', 30, 11000);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (5, 3, '14-12-2016', 30, 22000);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (6, 4, '17-12-2016', 100, 3300000);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (7, 5, '11-12-2016', 90, 2750000);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (8, 6, '12-12-2016', 40, 5500);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (9, 7, '12-12-2016', 30, 1100);
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return, return_amount)
 VALUES (10, 7, '15-12-2016', 40, 550);


INSERT INTO the_property (goods_id, address, dwelling_space)
 VALUES (3, 'Pr.Pobedy', 50);
INSERT INTO the_property (goods_id, address, dwelling_space)
 VALUES (6, 'Vostaniya street', 80);
INSERT INTO the_property (goods_id, address, dwelling_space)
 VALUES (7, 'Bauman street', 60);