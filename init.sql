CREATE DATABASE IF NOT EXISTS DB;
USE DB;
CREATE TABLE IF NOT EXISTS user(
                                   id bigint AUTO_INCREMENT,
                                   username varchar(255),
                                   password varchar(255),
                                   splitwise_key varchar(255),
    PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS payment (
                                         id bigint AUTO_INCREMENT,
                                         payment_type varchar(255),
                                         category varchar(255),
    payment_name varchar(255),
    amount double,
    user_id bigint,
    PRIMARY KEY (id)
    );
INSERT INTO
    user(username, password)
VALUES
    ("test","test")