CREATE  TABLE users (
  id INTEGER NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  email VARCHAR(45) NOT NULL ,
  enabled BIT(1) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE user_roles (
    id INTEGER(11) NOT NULL AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    role varchar(45) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uni_username_role (role,user_id),
    FOREIGN KEY (user_id) REFERENCES users(id));