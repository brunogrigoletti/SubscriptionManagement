INSERT INTO _user (code, username, password) VALUES (1, 'user123', 'pass123');
INSERT INTO _user (code, username, password) VALUES (2, 'user456', 'pass456');
INSERT INTO _user (code, username, password) VALUES (3, 'user789', 'pass789');
INSERT INTO _user (code, username, password) VALUES (4, 'user101', 'pass101');
INSERT INTO _user (code, username, password) VALUES (5, 'user202', 'pass202');

INSERT INTO application (code, name, monthly_cost) VALUES (1, 'AppOne', 9.99);
INSERT INTO application (code, name, monthly_cost) VALUES (2, 'AppTwo', 14.99);
INSERT INTO application (code, name, monthly_cost) VALUES (3, 'AppThree', 19.99);
INSERT INTO application (code, name, monthly_cost) VALUES (4, 'AppFour', 7.99);
INSERT INTO application (code, name, monthly_cost) VALUES (5, 'AppFive', 12.99);

INSERT INTO client (code, name, email) VALUES (1, 'Alice', 'alice@example.com');
INSERT INTO client (code, name, email) VALUES (2, 'Bob', 'bob@example.com');
INSERT INTO client (code, name, email) VALUES (3, 'Carol', 'carol@example.com');
INSERT INTO client (code, name, email) VALUES (4, 'Dave', 'dave@example.com');
INSERT INTO client (code, name, email) VALUES (5, 'Eve', 'eve@example.com');

INSERT INTO subscription (code, app_code, client_code, start_date, end_date) VALUES (1, 1, 1, '2023-01-01', '2023-12-31');
INSERT INTO subscription (code, app_code, client_code, start_date, end_date) VALUES (2, 2, 2, '2023-02-01', '2023-12-31');
INSERT INTO subscription (code, app_code, client_code, start_date, end_date) VALUES (3, 3, 3, '2024-03-01', '2025-12-31');
INSERT INTO subscription (code, app_code, client_code, start_date, end_date) VALUES (4, 4, 4, '2024-04-01', '2025-12-31');
INSERT INTO subscription (code, app_code, client_code, start_date, end_date) VALUES (5, 5, 5, '2024-05-01', '2025-12-31');

INSERT INTO payment (code, subscription_code, payment_value, payment_date, promotion) VALUES (1, 1, 9.99, '2024-01-05', '15');
INSERT INTO payment (code, subscription_code, payment_value, payment_date, promotion) VALUES (2, 2, 14.99, '2024-02-05', '15');
INSERT INTO payment (code, subscription_code, payment_value, payment_date, promotion) VALUES (3, 3, 19.99, '2024-03-05', 'None');
INSERT INTO payment (code, subscription_code, payment_value, payment_date, promotion) VALUES (4, 4, 7.99, '2024-04-05', 'None');
INSERT INTO payment (code, subscription_code, payment_value, payment_date, promotion) VALUES (5, 5, 12.99, '2024-05-05', 'None');