CREATE TABLE item (
  id INTEGER NOT NULL,
  description varchar(255),
  name varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE tag (
  id INTEGER NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE item_tag (
  id INTEGER NOT NULL,
  rating INTEGER,
  item_id INTEGER NOT NULL,
  tag_id INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (tag_id) REFERENCES tag (id),
  FOREIGN KEY (item_id) REFERENCES item (id)
);


