-- noinspection SqlDialectInspectionForFile

DROP TABLE IF EXISTS products;

BEGIN TRANSACTION;

CREATE TABLE products
(
	product_code varchar(5),
	name varchar(64) not null,
	price decimal not null,
	type varchar(10),

	constraint pk_products primary key (product_code)
);

INSERT INTO products (product_code, name, price, type) VALUES ('A1', 'Potato Crisps', 3.05, 'Chip');
INSERT INTO products (product_code, name, price, type) VALUES ('A2', 'Stackers', 1.45, 'Chip');
INSERT INTO products (product_code, name, price, type) VALUES ('A3', 'Grain Waves', 2.75, 'Chip');
INSERT INTO products (product_code, name, price, type) VALUES ('A4', 'Cloud Popcorn', 3.65, 'Chip');
INSERT INTO products (product_code, name, price, type) VALUES ('B1', 'Moonpie', 1.80, 'Candy');
INSERT INTO products (product_code, name, price, type) VALUES ('B2', 'Cowtales', 1.50, 'Candy');
INSERT INTO products (product_code, name, price, type) VALUES ('B3', 'Wonka Bar', 1.50, 'Candy');
INSERT INTO products (product_code, name, price, type) VALUES ('B4', 'Crunchie', 1.75, 'Candy');
INSERT INTO products (product_code, name, price, type) VALUES ('C1', 'Cola', 1.25, 'Drink');
INSERT INTO products (product_code, name, price, type) VALUES ('C2', 'Dr. Salt', 1.50, 'Drink');
INSERT INTO products (product_code, name, price, type) VALUES ('C3', 'Mountain Melter', 1.50, 'Drink');
INSERT INTO products (product_code, name, price, type) VALUES ('C4', 'Heavy', 1.50, 'Drink');
INSERT INTO products (product_code, name, price, type) VALUES ('D1', 'U-Chews', 0.85, 'Gum');
INSERT INTO products (product_code, name, price, type) VALUES ('D2', 'Little League Chew', 0.95, 'Gum');
INSERT INTO products (product_code, name, price, type) VALUES ('D3', 'Chiclets', 0.75, 'Gum');
INSERT INTO products (product_code, name, price, type) VALUES ('D4', 'Triplemint', 0.75, 'Gum');

COMMIT TRANSACTION;



