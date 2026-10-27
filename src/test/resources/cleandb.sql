-- Drop tables in reverse order of foreign key dependencies to avoid constraint errors
DROP TABLE IF EXISTS tackle_items;
DROP TABLE IF EXISTS catch_logs;
DROP TABLE IF EXISTS users;

-- Recreate tables
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL
);

CREATE TABLE catch_logs (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            species VARCHAR(255),
                            weight DOUBLE,
                            user_id INT,
                            FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE tackle_items (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              item_name VARCHAR(255),
                              lure_type VARCHAR(255),
                              user_id INT,
                              FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);