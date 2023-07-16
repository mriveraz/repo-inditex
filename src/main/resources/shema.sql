DROP TABLE IF EXISTS products;
create table products(
	product_Id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	brand VARCHAR(1),
	price_List VARCHAR(1)
);