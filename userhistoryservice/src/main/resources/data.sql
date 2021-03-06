DROP TABLE IF EXISTS tbl_userhistory;
CREATE TABLE tbl_userhistory (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT NOT NULL,
 movie_id INT NOT NULL,
 watch_date TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS tbl_userwatchlist;
CREATE TABLE tbl_userwatchlist (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT NOT NULL,
 movie_id INT NOT NULL,
 registry_date TIMESTAMP NOT NULL
);