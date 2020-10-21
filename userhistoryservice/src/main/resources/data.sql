DROP TABLE IF EXISTS tbl_product;
CREATE TABLE tbl_product (
 id INT AUTO_INCREMENT PRIMARY KEY,
 description VARCHAR(250) NOT NULL,
 price DOUBLE NOT NULL
);
INSERT INTO tbl_product (description, price) VALUES
 ('Produto 1', 10.00),
 ('Produto 2', 20.00),
 ('Produto 3', 30.00),
 ('Produto 4', 40.00),
 ('Produto 5', 50.00),
 ('Produto 6', 60.00),
 ('Produto 7', 70.00),
 ('Produto 8', 80.00),
 ('Produto 9', 90.00),
 ('Produto 10', 100.00);