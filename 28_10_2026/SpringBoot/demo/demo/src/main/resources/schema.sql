CREATE TABLE IF NOT EXISTS supplies (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        item_name VARCHAR(100) NOT NULL UNIQUE,
    quantity INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS requests (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        item_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    requested_by VARCHAR(100) NOT NULL
    );