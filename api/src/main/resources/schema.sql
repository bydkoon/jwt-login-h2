DROP TABLE IF EXISTS USER;

CREATE TABLE USER
(
    id bigint NOT NULL auto_increment,
    userId  VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    `name`   VARCHAR(255),
    regNo    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)

);
