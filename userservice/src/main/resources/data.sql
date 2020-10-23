DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user (
 id INT AUTO_INCREMENT PRIMARY KEY,
 name NVARCHAR(250) NOT NULL,
 password NVARCHAR(250) NOT NULL,
 created_date TIMESTAMP NOT NULL,
 status INT NOT NULL
);

INSERT INTO tbl_user (name, password, created_date, status) VALUES 
('Claudio Araujo','senha123', '20201021 10:50:00',1),
('Guilherme Bordallo','senha123', '20201021 10:50:00',1),
('Felipe Pereira','senha123', '20201021 10:50:00',1),
('Serafim Junior','senha123', '20201021 10:50:00',1);