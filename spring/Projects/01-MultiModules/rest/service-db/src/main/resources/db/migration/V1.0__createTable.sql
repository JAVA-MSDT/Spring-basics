----------------------------------------------------
------------------- BUILD TABLES -------------------
----------------------------------------------------
create table users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
     birth_date DATE,
     name VARCHAR(255),
     surname VARCHAR(255)
);

create table subscription(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    start_date DATE,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

----------------------------------------------------
------------------- INSERT RECORDS -----------------
----------------------------------------------------
INSERT INTO users(id, name, surname, birth_date) VALUES (1, 'ADMIN', 'admin', '1985-01-25');
INSERT INTO users(id, name, surname, birth_date) VALUES (2, 'USER', 'user', '1995-11-15');
INSERT INTO users(id, name, surname, birth_date) VALUES (3, 'USER ONE', 'user one', '2000-12-04');
INSERT INTO users(id, name, surname, birth_date) VALUES (4, 'USER TWO', 'user two', '2004-04-30');

INSERT INTO subscription(id, user_id, start_date) VALUES (1, 2, '2020-01-15');
INSERT INTO subscription(id, user_id, start_date) VALUES (2, 1, '2022-10-10');
INSERT INTO subscription(id, user_id, start_date) VALUES (3, 4, '2019-04-16');
INSERT INTO subscription(id, user_id, start_date) VALUES (4, 3, '2021-06-25');
