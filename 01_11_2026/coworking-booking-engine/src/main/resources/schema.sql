DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS workspaces;
DROP TABLE IF EXISTS users;

CREATE TABLE workspaces (
                            space_id INT AUTO_INCREMENT PRIMARY KEY,
                            space_name VARCHAR(100) NOT NULL,
                            space_type VARCHAR(50) NOT NULL,
                            hourly_rate DECIMAL(8,2) NOT NULL,
                            is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       full_name VARCHAR(100) NOT NULL,
                       email VARCHAR(120) UNIQUE NOT NULL,
                       wallet_balance DECIMAL(10,2) DEFAULT 0.00
);

CREATE TABLE bookings (
                          booking_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          space_id INT NOT NULL,
                          booking_date DATE NOT NULL,
                          slot_hour INT NOT NULL,
                          total_cost DECIMAL(8,2) NOT NULL,
                          booking_status VARCHAR(30) NOT NULL,
                          CONSTRAINT fk_bookings_user FOREIGN KEY (user_id) REFERENCES users(user_id),
                          CONSTRAINT fk_bookings_space FOREIGN KEY (space_id) REFERENCES workspaces(space_id),
                          CONSTRAINT uk_space_date_slot UNIQUE (space_id, booking_date, slot_hour)
);