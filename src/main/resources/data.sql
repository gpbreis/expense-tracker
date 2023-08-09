

INSERT INTO person (age, birthdate, name, salary, sex)VALUES (28, '1994-08-10', 'Gustavo Pereira Breis', 500, 'M');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (35, '1988-02-20', 'Emily Martinez', 600, 'F');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (41, '1981-11-05', 'Daniel Johnson', 800, 'M');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (30, '1993-06-15', 'Sophia Anderson', 450, 'F');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (33, '1989-09-27', 'Jacob Thompson', 550, 'M');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (32, '1991-04-12', 'Olivia Davis', 700, 'F');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (38, '1984-07-25', 'Matthew Wilson', 650, 'M');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (28, '1995-03-08', 'Emma Garcia', 550, 'F');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (45, '1978-12-16', 'Noah Rodriguez', 900, 'M');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (36, '1987-10-02', 'Ava Moore', 600, 'F');
INSERT INTO person (age, birthdate, name, salary, sex) VALUES (31, '1992-01-18', 'Liam Taylor', 700, 'M');

INSERT INTO card (owner_id, last_four_digits, closing_date, due_date, card_limit, brand, expiration_date) VALUES (1, '1992', '2023-08-31', '2023-09-08', 5000,'Visa', '2025-02-28');
INSERT INTO card (owner_id, last_four_digits, closing_date, due_date, card_limit, brand, expiration_date) VALUES (1, '4124', '2023-08-31', '2023-09-08', 3500,'Elo', '2028-04-30');
INSERT INTO card (owner_id, last_four_digits, closing_date, due_date, card_limit, brand, expiration_date) VALUES (2, '6372', '2023-09-04', '2023-09-11', 1800,'Mastercard', '2024-10-31');
INSERT INTO card (owner_id, last_four_digits, closing_date, due_date, card_limit, brand, expiration_date) VALUES (2, '9481', '2023-09-08', '2023-09-15', 15000,'Visa', '2025-05-31');

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO users (id, username, email, password, first_name, last_name, birthdate, document, created_on, updated_on, login_attempts, is_blocked) VALUES (1, 'admin', 'admin@admin.com', '$2a$10$PMkqihXSW5Fwre/srjNu3.C1.r9u7.vFXDClAHGWbh70x.a/rZ/1C', 'Admin', 'Administrator', '2000-01-01', '00000000000', '2023-08-08 00:00:00', '2023-08-08 00:00:00', 0, false);

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);