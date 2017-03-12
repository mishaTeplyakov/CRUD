USE user;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user.user;
CREATE TABLE crud_user(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(25) NOT NULL,
  age INT NOT NULL ,
  admin BIT(1) NOT NULL DEFAULT FALSE ,
  createDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
RENAME TABLE crud_user TO user;
INSERT INTO user (name, age, admin) VALUE("Mark",21,TRUE );
INSERT INTO user (name, age, admin) VALUE ("Misha",45,FALSE );
INSERT INTO user (name, age, admin) VALUE ("Vlad", 65,TRUE );
INSERT INTO user (name, age, admin) VALUE ("Jack", 70,FALSE );
INSERT INTO user (name, age, admin) VALUE ("Petr",90,FALSE );