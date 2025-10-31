INSERT INTO role (name, status) VALUES ('ADMIN', 1);
INSERT INTO role (name, status) VALUES ('USER', 1);


-- password: admin
-- https://bcrypt.online/
INSERT INTO user_data (status, id_role, username, password) VALUES
(1, 1, 'admin', '$2y$10$xe2W1PAG/4RWrAjLXwt7PO8pJLr6DC6SE55GwXW/cOLKCm3yBBu5O');