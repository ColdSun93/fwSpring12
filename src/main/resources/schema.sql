CREATE TABLE IF NOT EXISTS notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    heading varchar(50) NOT NULL,
    content varchar(100) NOT NULL,
    CREATION_DATE TIMESTAMP
);