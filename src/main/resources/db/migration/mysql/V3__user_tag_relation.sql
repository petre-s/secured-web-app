ALTER TABLE tag ADD user_id INTEGER;

ALTER TABLE tag ADD FOREIGN KEY (user_id) REFERENCES users(id);