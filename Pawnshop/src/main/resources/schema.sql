DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS goods CASCADE;
DROP TABLE IF EXISTS operation CASCADE;
DROP TABLE IF EXISTS the_property CASCADE;

CREATE TABLE customer
(
  customer_id SERIAL,
  passport VARCHAR(20) NOT NULL UNIQUE,
  last_name VARCHAR(40),
  first_name VARCHAR(40),
  middle_name VARCHAR(40),
  date_of_birth DATE,
  phone_number VARCHAR(22) NOT NULL UNIQUE,
  CONSTRAINT customer_pkey PRIMARY KEY (customer_id),
  CONSTRAINT pass_check CHECK (passport::text ~ '[0-9]{10}'::text),
  CONSTRAINT phone_check CHECK (phone_number::text ~ '[0-9]{11}'::text)
);

CREATE TABLE goods
(
  goods_id SERIAL,
  goods_type VARCHAR(50),
  description VARCHAR(100),
  pawnshop_price INT NOT NULL,
  CONSTRAINT goods_pkey PRIMARY KEY (goods_id)
);

CREATE TABLE operation
(
  operation_id SERIAL,
  goods_id INT,
  customer_id INT,
  pledge_date DATE NOT NULL,
  time_of_return INT NOT NULL ,
  status VARCHAR(50) DEFAULT 'DEPT',
  return_amount INT NOT NULL,
  CONSTRAINT operation_pkey PRIMARY KEY (operation_id),
  CONSTRAINT operation_customer_id_fkey FOREIGN KEY (customer_id)
  REFERENCES customer (customer_id) ON DELETE SET NULL,
  CONSTRAINT operation_goods_id_fkey FOREIGN KEY (goods_id)
  REFERENCES goods (goods_id) ON DELETE CASCADE,
  CONSTRAINT time_check CHECK (time_of_return > 0),
  CONSTRAINT pledge_date_check CHECK (pledge_date + time_of_return * interval '1 day' > now())
);

CREATE TABLE the_property
(
  the_property_id SERIAL,
  goods_id INT,
  address VARCHAR(70) NOT NULL,
  dwelling_space INT NOT NULL,
  CONSTRAINT the_property_pkey PRIMARY KEY (the_property_id),
  CONSTRAINT the_property_good_id_fkey FOREIGN KEY (goods_id)
  REFERENCES goods (goods_id) ON DELETE CASCADE
);


CREATE FUNCTION trigger_s_after_insert () RETURNS trigger AS '
BEGIN
UPDATE operation SET (status) = (''OVERDUE'')
  WHERE pledge_date + time_of_return * interval ''1 day'' < now()
  AND status = ''DEPT'';
  RETURN new;
END;
' LANGUAGE  plpgsql;

CREATE TRIGGER tr_operation_after_insert
AFTER INSERT ON operation FOR EACH ROW
EXECUTE PROCEDURE trigger_s_after_insert();


CREATE INDEX customer_index ON customer (customer_id);
CREATE INDEX goods_index ON goods (goods_id);
CREATE INDEX operation_index ON operation (operation_id);


CREATE OR REPLACE FUNCTION add_operation (cid integer, gtype character varying, gdesc character varying, gprice integer, treturn integer) RETURNS void
LANGUAGE plpgsql
AS $$
DECLARE
gid INT;
BEGIN
INSERT INTO goods (goods_type, pawnshop_price, description)
VALUES (gtype, gprice, gdesc)
RETURNING goods_id INTO gid;
INSERT INTO operation (goods_id, customer_id, pledge_date, time_of_return,
return_amount) VALUES ( gid, cid, now(), treturn,
gprice*1.1);

END;
$$



CREATE OR REPLACE FUNCTION add_property
  (gid INT, address VARCHAR(70), space INT)
  RETURNS VOID AS '
  BEGIN
  IF (SELECT count(*) FROM goods WHERE (goods_id = gid) AND (goods_type = ''THE PROPERTY'')) > 0
  THEN
  INSERT INTO the_property (goods_id, address, dwelling_space) VALUES (gid, address, space);
  END IF;
  END;
'
LANGUAGE plpgsql;


CREATE VIEW property_view AS (SELECT p.address, p.dwelling_space, p.the_property_id, g.* FROM the_property AS p
INNER JOIN goods AS g ON g.goods_id = p.goods_id);
