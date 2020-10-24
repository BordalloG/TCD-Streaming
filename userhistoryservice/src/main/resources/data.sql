DROP TABLE IF EXISTS tbl_userhistory;
CREATE TABLE tbl_userhistory (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT NOT NULL,
 movie_id INT NOT NULL,
 watch_date TIMESTAMP NOT NULL
);

INSERT INTO tbl_userhistory (user_id, movie_id, watch_date) VALUES 
(1,3, '20201021 10:50:00'),
(1,4, '20201021 10:50:00'),
(1,5, '20201021 10:50:00'),
(1,6, '20201021 10:50:00'),
(2,3, '20201021 10:50:00'),
(2,4, '20201021 10:50:00');

DROP TABLE IF EXISTS tbl_userwatchlist;
CREATE TABLE tbl_userwatchlist (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT NOT NULL,
 movie_id INT NOT NULL,
 registry_date TIMESTAMP NOT NULL
);

INSERT INTO tbl_userwatchlist (user_id, movie_id, registry_date) VALUES 
(1,3, '20201021 10:50:00'),
(1,4, '20201021 10:50:00'),
(1,5, '20201021 10:50:00'),
(1,6, '20201021 10:50:00'),
(2,3, '20201021 10:50:00'),
(2,4, '20201021 10:50:00');