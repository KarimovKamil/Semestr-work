DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS goods CASCADE;
DROP TABLE IF EXISTS operation CASCADE;
DROP TABLE IF EXISTS the_property CASCADE;

CREATE TABLE customer
(
  customer_id SERIAL,
  passport VARCHAR(20) NOT NULL,
  last_name VARCHAR(40),
  first_name VARCHAR(40),
  middle_name VARCHAR(40),
  date_of_birth DATE,
  phone_number VARCHAR(22) NOT NULL,
  CONSTRAINT customer_pkey PRIMARY KEY (customer_id),
  CONSTRAINT passport_unique UNIQUE (passport),
  CONSTRAINT pass_check CHECK (passport::text ~ '[0-9]{10}'::text),
  CONSTRAINT phone_check CHECK (phone_number::text ~ '[0-9]{11}'::text)
);

CREATE TABLE goods
(
  goods_id SERIAL,
  goods_type VARCHAR(50),
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
  REFERENCES customer (customer_id),
  CONSTRAINT operation_goods_id_fkey FOREIGN KEY (goods_id)
  REFERENCES goods (goods_id),
  CONSTRAINT time_check CHECK (time_of_return > 0),
  CONSTRAINT pledge_date_check CHECK (pledge_date + time_of_return * interval '1 day' < now())
);

CREATE TABLE the_property
(
  the_property_id SERIAL,
  goods_id INT,
  address VARCHAR(70) NOT NULL,
  dwelling_space INT NOT NULL,
  CONSTRAINT the_property_pkey PRIMARY KEY (the_property_id),
  CONSTRAINT the_property_good_id_fkey FOREIGN KEY (goods_id)
  REFERENCES goods (goods_id)
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