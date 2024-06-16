INSERT INTO user (id, password) VALUES ('user123', 'pass123');
INSERT INTO user (id, password) VALUES ('user456', 'pass456');
INSERT INTO user (id, password) VALUES ('user789', 'pass789');
INSERT INTO user (id, password) VALUES ('user101', 'pass101');
INSERT INTO user (id, password) VALUES ('user202', 'pass202');

INSERT INTO application (code, name, monthlyCost) VALUES (1, 'AppOne', 9.99);
INSERT INTO application (code, name, monthlyCost) VALUES (2, 'AppTwo', 14.99);
INSERT INTO application (code, name, monthlyCost) VALUES (3, 'AppThree', 19.99);
INSERT INTO application (code, name, monthlyCost) VALUES (4, 'AppFour', 7.99);
INSERT INTO application (code, name, monthlyCost) VALUES (5, 'AppFive', 12.99);

INSERT INTO client (code, name, email) VALUES (1, 'Alice', 'alice@example.com');
INSERT INTO client (code, name, email) VALUES (2, 'Bob', 'bob@example.com');
INSERT INTO client (code, name, email) VALUES (3, 'Carol', 'carol@example.com');
INSERT INTO client (code, name, email) VALUES (4, 'Dave', 'dave@example.com');
INSERT INTO client (code, name, email) VALUES (5, 'Eve', 'eve@example.com');

INSERT INTO subscription (code, app_code, client_code, startDate, endDate) VALUES (1, 1, 1, '2024-01-01', '2024-12-31');
INSERT INTO subscription (code, app_code, client_code, startDate, endDate) VALUES (2, 2, 2, '2024-02-01', '2024-12-31');
INSERT INTO subscription (code, app_code, client_code, startDate, endDate) VALUES (3, 3, 3, '2024-03-01', '2024-12-31');
INSERT INTO subscription (code, app_code, client_code, startDate, endDate) VALUES (4, 4, 4, '2024-04-01', '2024-12-31');
INSERT INTO subscription (code, app_code, client_code, startDate, endDate) VALUES (5, 5, 5, '2024-05-01', '2024-12-31');

INSERT INTO payment (code, subscription_code, paymentValue, paymentDate, promotion) VALUES (1, 1, 9.99, '2024-01-05', NULL);
INSERT INTO payment (code, subscription_code, paymentValue, paymentDate, promotion) VALUES (2, 2, 14.99, '2024-02-05', NULL);
INSERT INTO payment (code, subscription_code, paymentValue, paymentDate, promotion) VALUES (3, 3, 19.99, '2024-03-05', NULL);
INSERT INTO payment (code, subscription_code, paymentValue, paymentDate, promotion) VALUES (4, 4, 7.99, '2024-04-05', NULL);
INSERT INTO payment (code, subscription_code, paymentValue, paymentDate, promotion) VALUES (5, 5, 12.99, '2024-05-05', NULL);