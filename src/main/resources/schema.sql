DROP TABLE IF EXISTS music;

CREATE TABLE music (
   id INT AUTO_INCREMENT  PRIMARY KEY,
   musicName VARCHAR(250) NOT NULL,
   urlAddress VARCHAR(250) NOT NULL,
   duration int default 0,
   uploadedDate DATETIME DEFAULT NULL
);