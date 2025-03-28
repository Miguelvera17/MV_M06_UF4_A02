CREATE DATABASE IF NOT EXISTS llibres;

USE llibres;

CREATE TABLE llibre (
    id_llibre INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    published_year DATE,
    genre VARCHAR(100),
    ISBN VARCHAR(13)
);
