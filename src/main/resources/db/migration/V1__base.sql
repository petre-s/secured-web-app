
CREATE TABLE item (
  id int(11) NOT NULL,
  description varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE tag (
  id int(11) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE item_tag (
  id int(11) NOT NULL,
  rating int(11) DEFAULT NULL,
  item_id int(11) NOT NULL,
  tag_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY FKjjb157o07631yt4a1h2fi2i4s (item_id),
  KEY FKde89ewingaktwyec3nh82pirt (tag_id),
  CONSTRAINT FKde89ewingaktwyec3nh82pirt FOREIGN KEY (tag_id) REFERENCES tag (id),
  CONSTRAINT FKjjb157o07631yt4a1h2fi2i4s FOREIGN KEY (item_id) REFERENCES item (id)
);


