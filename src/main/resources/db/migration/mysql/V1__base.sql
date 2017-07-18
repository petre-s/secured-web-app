CREATE TABLE item (
  id INTEGER NOT NULL AUTO_INCREMENT,
  description varchar(255),
  name varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE tag (
  id INTEGER NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);

CREATE TABLE item_tag (
  id INTEGER NOT NULL AUTO_INCREMENT,
  rating INTEGER,
  item_id INTEGER NOT NULL,
  tag_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (tag_id) REFERENCES tag (id),
  FOREIGN KEY (item_id) REFERENCES item (id)
);
