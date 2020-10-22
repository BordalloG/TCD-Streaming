DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user (
 id INT AUTO_INCREMENT PRIMARY KEY,
 name NVARCHAR(250) NOT NULL,
 password NVARCHAR(250) NOT NULL,
 createdDate TIMESTAMP NOT NULL,
 status INT NOT NULL
);

INSERT INTO tbl_user (name, password, createdDate, status) VALUES ('Claudio Araujo',
'senha123', '20201021 10:50:00',1);
INSERT INTO tbl_user (name, password, createdDate, status) VALUES ('Guilherme Bordallo',
'senha123', '20201021 10:50:00',1);
INSERT INTO tbl_user (name, password, createdDate, status) VALUES ('Felipe Pereira',
'senha123', '20201021 10:50:00',1);
INSERT INTO tbl_user (name, password, createdDate, status) VALUES ('Serafim Junior',
'senha123', '20201021 10:50:00',1);